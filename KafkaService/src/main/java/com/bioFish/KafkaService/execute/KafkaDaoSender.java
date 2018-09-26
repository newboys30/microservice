package com.bioFish.KafkaService.execute;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


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
	
	public void send() {
		/*Message message = new Message();
		message.setId(System.currentTimeMillis());
		message.setMsg("Hello Kafka");
		message.setSendTime(new Date());
		
		kafkaTemplate.send("testKafka", gson.toJson(message));*/
		 kafkaTemplate.send("testKafka","hello,kafka  "  + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
	}
}
