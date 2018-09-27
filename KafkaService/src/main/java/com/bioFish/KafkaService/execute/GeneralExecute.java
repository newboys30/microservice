package com.bioFish.KafkaService.execute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bioFish.KafkaService.execute.sender.KafkaDaoSender;

/**
 * 通用执行器
 * @ClassName: GeneralExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月27日 下午2:32:03
 */
@RestController
public class GeneralExecute {
	
	@Autowired
	private KafkaDaoSender kafkaDaoSender;
	
	@RequestMapping(value = "/generelExe")
	public void generalExe() {
		kafkaDaoSender.send();
	}
}
