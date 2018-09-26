package com.bioFish.KafkaService.execute;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.bioFish.KafkaService.data.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wtl.Utils.JsonUtil;

/**
 * kafka发送
 * @ClassName: KafkaSender
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月26日 下午5:06:25
 */
@Component
public class KafkaDaoSender {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private Gson gson = new GsonBuilder().create();
	
	public void send() {
		Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setMsg("Hello Kafka");
		message.setSendTime(new Date());
		
		kafkaTemplate.send("testKafka", gson.toJson(message));
	}
}
