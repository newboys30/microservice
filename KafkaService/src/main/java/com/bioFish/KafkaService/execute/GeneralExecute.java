package com.bioFish.KafkaService.execute;

import java.util.Map;

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
	/**
	 * 测试方法
	 * @Title: testDaoExe
	 * @Description: TODO
	 * @return: void
	 */
	@RequestMapping(value = "/testDaoExe")
	public void testDaoExe() {
		kafkaDaoSender.testsend();
	}
	
	/**
	 * 通用执行器
	 * @Title: generalDaoExe
	 * @Description: TODO
	 * @param exeMap topic：节点名称 exeJson 执行Json
	 * @return: void
	 */
	@RequestMapping(value = "/generalDaoExe")
	public void generalDaoExe(Map<String,String> exeMap) {
		String topic = exeMap.get("topic");
		String exeJson = exeMap.get("exeJson");
		kafkaDaoSender.generalDaoSend(topic, exeJson);
	}
}
