package com.bioFish.ZKService.Execute;

import java.util.concurrent.CountDownLatch;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * 分布式锁
 * @ClassName: DistributedLockByZookeeper
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月19日 下午3:31:50
 */
@Service("distributedLockByZookeeper")
public class DistributedLockByZookeeper implements InitializingBean {
	
	private final static String ROOT_PATH_LOCK = "rootlock";
	private CountDownLatch countDownLatch = new CountDownLatch(1);
	@Autowired
	private CuratorFramework curatorFramework;
	
	/**
	 * 获取锁
	 * @Title: acquireDistributedLock
	 * @Description: TODO
	 * @param path
	 * @return: void
	 */
	public void acquireDistributedLock(String path) throws Exception{
		String keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
		while(true) {
			try {
				curatorFramework
				.create()
				.creatingParentContainersIfNeeded()
				.withMode(CreateMode.EPHEMERAL)
				.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
				.forPath(keyPath);
				
				break;
			} catch (Exception e) {
				try {
					if(countDownLatch.getCount() <= 0) {
						countDownLatch = new CountDownLatch(1);
					}
					countDownLatch.wait();
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 释放锁
	 * @Title: releaseDistributedLock
	 * @Description: TODO
	 * @param path
	 * @return
	 * @return: boolean
	 */
	public boolean releaseDistributedLock(String path) throws Exception{
		String keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
		try {
			if(curatorFramework.checkExists().forPath(keyPath) != null) {
				curatorFramework.delete().forPath(keyPath);
			}
		} catch (Exception e) {
			 return false;
		}
		return true;
	}
	
	/**
	 * watcher事件
	 * @Title: addWatcher
	 * @Description: TODO
	 * @param path
	 * @throws Exception
	 * @return: void
	 */
	public void addWatcher(String path) throws Exception{
		String keyPath;
		if(path.equals(ROOT_PATH_LOCK)) {
			keyPath = "/" + path;
		}else {
			keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
		}
		final PathChildrenCache cache = new PathChildrenCache(curatorFramework, keyPath, false);
		cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
		cache.getListenable().addListener((client, event) -> {
			if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)) {
				String oldPath = event.getData().getPath();
				if(oldPath.contains(path)) {
					countDownLatch.countDown();
				}
			}
		});
		
	}
	
	/**
	 * 创建父节点，并创建永久节点
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		curatorFramework = curatorFramework.usingNamespace("lock-namespace");
		String path = "/" + ROOT_PATH_LOCK;
		if(curatorFramework.checkExists().forPath(path) == null) {
			curatorFramework
			.create()
			.creatingParentContainersIfNeeded()
			.withMode(CreateMode.PERSISTENT)
			.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
			.forPath(path);
		}
		addWatcher(ROOT_PATH_LOCK);
	}

}
