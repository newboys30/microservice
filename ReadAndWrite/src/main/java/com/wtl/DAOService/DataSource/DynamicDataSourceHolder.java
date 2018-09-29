package com.wtl.DAOService.DataSource;

/**
 * 使用ThreadLocal保证线程安全
 * @ClassName: DynamicDataSourceHolder
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月28日 上午10:03:31
 */
public class DynamicDataSourceHolder {
	
	//写库数据源key
	private static final String MASTER = "master";
	
	//读库数据源key
	private static final String SLAVE = "slave";
	
	//使用ThreadLocal记录数据源key
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();
	
	/**
	 * 设置数据源key
	 * @Title: putDataSourceKey
	 * @Description: TODO
	 * @param key
	 * @return: void
	 */
	public static void putDataSourceKey(String key) {
		holder.set(key);
	}
	
	public static String getDataSourceKey() {
		return holder.get();
	}
	
	/**
	 * 标记写库
	 * @Title: markMaster
	 * @Description: TODO
	 * @return: void
	 */
	public static void markMaster() {
		putDataSourceKey(MASTER);
	}
	
	/**
	 * 标记读库
	 * @Title: markSlave
	 * @Description: TODO
	 * @return: void
	 */
	public static void markSlave() {
		putDataSourceKey(SLAVE);
	}
}
