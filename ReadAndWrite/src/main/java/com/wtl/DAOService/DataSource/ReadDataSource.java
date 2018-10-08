package com.wtl.DAOService.DataSource;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 读数据源
 * @ClassName: ReadDataSOurce
 * @Description: TODO
 * @author: newbo
 * @date: 2018年9月30日 下午6:06:34
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ReadDataSource {

}
