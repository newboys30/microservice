package com.bioFish.Params;

import java.io.Serializable;

/**
 * 返回值Json模型
 * @ClassName: JsonObject
 * @Description: TODO
 * @author: newbo
 * @date: 2018年11月9日 上午11:06:03
 */
public class JsonObject implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = -3065507137896906213L;
	private String msg = "";
	private Boolean success = false;
	private Object obj = null;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
