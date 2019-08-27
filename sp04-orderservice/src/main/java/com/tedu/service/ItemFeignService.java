package com.tedu.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tedu.pojo.Item;
import com.tedu.service.impl.ItemFeignServiceFB;
import com.tedu.util.JsonResult;

@FeignClient(name = "item-service",fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
	
	@GetMapping("/{orderId}")
	JsonResult<List<Item>> getItems(@PathVariable String orderId);
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/decreaseNumber")
	JsonResult decreaseNumber(@RequestBody List<Item> items);
}
