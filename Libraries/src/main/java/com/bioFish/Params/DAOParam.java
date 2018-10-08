package com.bioFish.Params;

import java.io.Serializable;

/**
 * 持久层调用封装类
 * @ClassName: DAOParam
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月17日 上午10:21:30
 */
public class DAOParam implements Serializable{
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -2571115250269944706L;
	/**
	 * class类名
	 */
	String FileName;
	/**
	 * 方法名
	 */
	String Methods;
	/**
	 * 传入参数 json化
	 */
	String jsonParam;
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	public String getMethods() {
		return Methods;
	}
	public void setMethods(String methods) {
		Methods = methods;
	}
	public String getJsonParam() {
		return jsonParam;
	}
	public void setJsonParam(String jsonParam) {
		this.jsonParam = jsonParam;
	}
}
