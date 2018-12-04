package com.bioFish.Oauth2service.api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试一下
 * @ClassName: UserController
 * @Description: TODO
 * @author: newbo
 * @date: 2018年12月4日 下午4:18:14
 */
@Controller
public class UserController {
	
	@CrossOrigin
	@RequestMapping("/api/userinfo")
	public ResponseEntity<UserInfo> getUserInfo(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = user.getUsername() + "@outlook.com";
		UserInfo userInfo = new UserInfo();
		userInfo.setName(user.getUsername());
		userInfo.setEmail(email);
		return ResponseEntity.ok(userInfo);
	}
}
