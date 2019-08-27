package com.tedu.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tedu.pojo.User;
import com.tedu.service.impl.UserFeignServiceFB;
import com.tedu.util.JsonResult;

@FeignClient(name = "user-service",fallback = UserFeignServiceFB.class)
public interface UserFeignService {
	
	@GetMapping("/{userId}")
	JsonResult<User> getUser(@PathVariable Integer userId);
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/{userId}/score")
	JsonResult addScore(@PathVariable Integer userId,@RequestParam Integer score);
}
