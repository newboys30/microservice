package com.bioFish.KafkaService.data;

import java.util.Date;

/**
 * kafka消息体
 * @ClassName: Message
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月26日 下午5:49:42
 */
public class Message {
	private Long id;
	private String msg;
	private Date sendTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
}
