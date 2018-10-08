package com.bioFish.ZKService.Execute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 连接
 * @ClassName: DistributedLockClient
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月19日 下午4:53:22
 */
@RestController
public class DistributedLockClient {
	
	@Autowired
	private DistributedLockByZookeeper distributedLockByZookeeper;
	
	/**
	 * watch目录
	 * @Title: addWatcherPath
	 * @Description: TODO
	 * @param path
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping(value = "/addWatcherPath")
	public void addWatcherPath(String path) throws Exception {
		distributedLockByZookeeper.addWatcher(path);
	}
	
	/**
	 * 获取锁
	 * @Title: addLock
	 * @Description: TODO
	 * @param path
	 * @throws Exception
	 * @return: void
	 */
	@RequestMapping(value = "/acquireLock")
	public void acquireLock(String path) throws Exception {
		distributedLockByZookeeper.acquireDistributedLock(path);
	}
	
	/**
	 * 释放锁
	 * @Title: releaseLock
	 * @Description: TODO
	 * @param path
	 * @return
	 * @throws Exception
	 * @return: boolean
	 */
	@RequestMapping(value = "/acquireLock")
	public boolean releaseLock(String path) throws Exception {
		return distributedLockByZookeeper.releaseDistributedLock(path);
	}
}
