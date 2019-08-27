package com.tedu.service;

import com.tedu.pojo.User;

public interface UserService {
	//根据用户id获取用户数据
	User getUser(Integer id);
	//根据用户id增加用户积分
	void addScore(Integer id,Integer score);
	
}
