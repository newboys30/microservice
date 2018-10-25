package com.bioFish.DAOService.Execute.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bioFish.DAOService.DaoSupport.DaoSupport;
import com.bioFish.DAOService.DataSource.ReadDataSource;
import com.bioFish.DAOService.DataSource.WriteDataSource;
import com.bioFish.DAOService.Entity.User;
import com.bioFish.DAOService.util.SpringContextUtil;
import com.bioFish.Utils.JsonUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * User实际执行类
 * 数据库操作必须指定数据库
 * @ClassName: UserExecute
 * @Description: TODO
 * @author: newbo
 * @date: 2018年10月8日 下午6:01:41
 */
@Service("userExecute")
public class UserExecute {
	
	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	@ReadDataSource
	public User getUserByName(String jsonStr) throws Exception{
		String user_name = JsonUtil.changeGsonToBean(jsonStr, String.class);
		return (User) dao.findForObject("UserMapper.selectByName", user_name);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false)
	@WriteDataSource
	public Map<String,String> insertUser(String jsonStr) throws Exception{
		Map<String,String> retMap = new HashMap<String,String>();
		User user = JsonUtil.changeGsonToBean(jsonStr, User.class);
		int i = (int) dao.save("UserMapper.saveUser", user);
		if(0 != i) {
			retMap.put("retMsg", "保存成功");
			retMap.put("retFlag", "1");
		}else {
			retMap.put("retMsg", "保存失败");
			retMap.put("retFlag", "0");
		}
		retMap.put("retMsg", "保存成功");
		return retMap;
	}
	
	/**
	 * 分页查询
	 * String userName,int pageNum,int pageSize
	 * @Title: queryPage
	 * @Description: TODO
	 * @return
	 * @throws Exception
	 * @return: PageInfo<User>
	 */
	@WriteDataSource
	public PageInfo<User> queryPage(String jsonStr) throws Exception{
		Map<String,Object> pageMap = JsonUtil.changeGsonToMaps(jsonStr);
		int pageNum = pageMap.get("pageNum") == null?0:Integer.parseInt(pageMap.get("pageNum").toString());
		int pageSize = pageMap.get("pageSize") == null?20:Integer.parseInt(pageMap.get("pageSize").toString());
		String username = pageMap.get("username").toString();
		Page<User> page = PageHelper.startPage(pageNum, pageSize);
		dao.findForList("UserMapper.selectAll", username);
		return page.toPageInfo();
	}
	
	/**
	 * 内部调用触发AOP拦截
	 * @Title: getExecute
	 * @Description: TODO
	 * @return
	 * @return: UserExecute
	 */
	private UserExecute getExecute() {
		return SpringContextUtil.getBean(this.getClass());
	}
}
