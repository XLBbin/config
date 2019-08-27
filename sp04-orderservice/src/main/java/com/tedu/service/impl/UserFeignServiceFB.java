package com.tedu.service.impl;

import org.springframework.stereotype.Component;

import com.tedu.pojo.User;
import com.tedu.service.UserFeignService;
import com.tedu.util.JsonResult;
@Component
public class UserFeignServiceFB implements UserFeignService {

	@Override
	@SuppressWarnings("unchecked")
	public JsonResult<User> getUser(Integer userId) {
		if (Math.random()<0.4) {
			return JsonResult.ok(new User(userId,"缓存name"+userId, "缓存pwd"+userId));
		}
		return JsonResult.err("无法获取用户信息");
	}

	@Override
	@SuppressWarnings("rawtypes")
	public JsonResult addScore(Integer userId, Integer score) {
		
		return JsonResult.err("无法增加用户积分");
	}

}
