package com.bioFish.DAOService.Config;

/**
 * 数据库线程
 * @ClassName: DataSourceContextHolder
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月30日 下午6:18:57
 */
public class DataSourceContextHolder {
	
	//线程本地环境
	private static final ThreadLocal<String> local = new ThreadLocal<String>();
	
	public static final ThreadLocal<String> getLocal(){
		return local;
	}
	
	/**
	 * 读库
	 * @Title: setRead
	 * @Description: TODO
	 * @return: void
	 */
	public static void setRead() {
		local.set(DataSourceType.read.getType());
	}
	
	/**
	 * 写库
	 * @Title: setWrite
	 * @Description: TODO
	 * @return: void
	 */
	public static void setWrite() {
		local.set(DataSourceType.write.getType());
	}
	
	public static String getReadOrWrite() {
		return local.get();
	}
	
	public static void clear() {
		local.remove();
	}
}
