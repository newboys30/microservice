package com.wtl.DAOService.Execute;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 将字符串转换成Bean
 * @ClassName: BeanTransverter
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月18日 下午4:09:59
 */
@Service("beanTransverter")
public class BeanTransverter<T> implements BeanFactoryAware {
	
	@Autowired
	private BeanFactory beanFactory;
	
	public T getBean(String enumName) {
		String beanName = toBeanName(enumName);
		return (T) beanFactory.getBean(beanName);
	}
	
	private String toBeanName(String enumName) {
		String a = enumName.substring(0, 1);
		String b = enumName.substring(1, enumName.length());
		return new StringBuffer().append(a.toLowerCase()).append(b).toString();
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		 this.beanFactory = beanFactory;
	}

}
