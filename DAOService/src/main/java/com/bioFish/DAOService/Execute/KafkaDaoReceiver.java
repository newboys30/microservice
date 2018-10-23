package com.bioFish.DAOService.Execute;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaDaoReceiver {
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
