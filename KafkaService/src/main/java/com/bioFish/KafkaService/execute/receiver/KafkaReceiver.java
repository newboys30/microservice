package com.bioFish.KafkaService.execute.receiver;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * kafka接收者
 * @ClassName: KafkaReceiver
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月26日 下午5:24:26
 */
@Component
public class KafkaReceiver {
	
	/**
	 * 测试方法
	 * @Title: testlisten
	 * @Description: TODO
	 * @param record
	 * @return: void
	 */
	@KafkaListener(topics = {"testKafka"})
	public void testlisten(ConsumerRecord<String, String> record) {
		Optional<String> kafkaMessage = Optional.ofNullable(record.value());
		if(kafkaMessage.isPresent()) {
			String message = kafkaMessage.get();
			System.out.println("message====" + message);
		}
	}
	
}
