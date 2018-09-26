package com.bioFish.KafkaService.execute;

import org.springframework.kafka.annotation.KafkaListener;


/**
 * kafka接收者
 * @ClassName: KafkaReceiver
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月26日 下午5:24:26
 */
public class KafkaReceiver {
	
	/*@KafkaListener(topics = {"testKafka"})
	public void listen(ConsumerRecord<String, String> record) {
		Optional<String> kafkaMessage = Optional.ofNullable(record.value());
		if(kafkaMessage.isPresent()) {
			String message = kafkaMessage.get();
			System.out.println("message====" + message);
		}
	}*/
	@KafkaListener(topics = {"testKafka"})
	public void consumer(String message){
		System.out.println(message);
	}
}
