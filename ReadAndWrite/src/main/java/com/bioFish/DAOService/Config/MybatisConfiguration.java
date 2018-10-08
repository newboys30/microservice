package com.bioFish.DAOService.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import com.bioFish.DAOService.util.SpringContextUtil;
import com.sun.jersey.api.core.DefaultResourceConfig;


/**
 * Mybatis配置
 * @ClassName: MybatisConfiguration
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月4日 下午11:48:09
 */
@Configuration
@AutoConfigureAfter(DataSourceConfiguration.class)
public class MybatisConfiguration {
	@Value("${mysql.datasource.readSize}")
	private String readDataSourceSize;
	@Value("${mysql.datasource.mapperLocations}")
	private String mapperLocations;
	@Value("${mysql.datasource.configLocation}")
	private String configLocation;
	
	@Autowired
	@Qualifier("writeDataSource")
	private DataSource writeDataSource;
	
	@Autowired
	@Qualifier("readDataSource")
	private DataSource readDataSource;
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		 try {
			SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
			//数据源
			sessionFactoryBean.setDataSource(roundRobinDataSouceProxy());
			//实体类
			sessionFactoryBean.setTypeAliasesPackage("com.wtl.DAOService.Entity");
			//mapper位置
			Resource[] resources = new PathMatchingResourcePatternResolver().getResources(mapperLocations);
			sessionFactoryBean.setMapperLocations(resources);
			
			//设置mybatis-config.xml配置文件位置
			sessionFactoryBean.setConfigLocation(new DefaultResourceLoader().getResource(configLocation));
			
			return sessionFactoryBean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 将数据库连接放入路由
	 * @Title: roundRobinDataSouceProxy
	 * @Description: TODO
	 * @return
	 * @return: AbstractRoutingDataSource
	 */
	@Bean(name = "roundRobinDataSouceProxy")
	public AbstractRoutingDataSource roundRobinDataSouceProxy() {
		
		/**
		 * 将全部数据库数据放入资源中，key值必须与determineCurrentLookupKey()代码中的一致
		 */
		Map<Object, Object> targetDataSources = new HashMap<Object,Object>();
		targetDataSources.put(DataSourceType.write.getType(), writeDataSource);
		targetDataSources.put(DataSourceType.read.getType(), readDataSource);
		
		final int readSize = Integer.parseInt(readDataSourceSize);
		
		//路由
		AbstractRoutingDataSource proxy = new AbstractRoutingDataSource() {
			private AtomicInteger count = new AtomicInteger(0);
			
			/**
			 * AbstractRoutingDataSource类中的一个抽象方法
			 * 返回值为DataSource的key值
			 * 使用这个key值可以从targetDataSources中取出相应的DataSource,否则使用默认的数据源
			 */
			@Override
			protected Object determineCurrentLookupKey() {
				String typeKey = DataSourceContextHolder.getReadOrWrite();
				if(null == typeKey) {
					throw new NullPointerException("数据库路由时，决定使用哪个数据库源类型不能为空");
				}
				//写库
				if(typeKey.equals(DataSourceType.write.getType())) {
					return DataSourceType.write.getType();
				}
				//读库
				return DataSourceType.read.getType();
			}
		};
		
		proxy.setDefaultTargetDataSource(writeDataSource);
		proxy.setTargetDataSources(targetDataSources);
		return proxy;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	/**
	 * 事务管理
	 * @Title: annotationDrivenTransactionManager
	 * @Description: TODO
	 * @return
	 * @return: PlatformTransactionManager
	 */
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager((DataSource) SpringContextUtil.getBean("roundRobinDataSouceProxy"));
	}
}
