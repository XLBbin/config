package com.tedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.pojo.Item;
import com.tedu.pojo.Order;
import com.tedu.pojo.User;
import com.tedu.service.ItemFeignService;
import com.tedu.service.OrderService;
import com.tedu.service.UserFeignService;
import com.tedu.util.JsonResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ItemFeignService itemFeignService;
	@Autowired
	private UserFeignService userFeignService;
	@Override
	public Order getOrder(String orderId) {
		//  调用user-service获取用户信息
		JsonResult<User> u = userFeignService.getUser(7);// 写死,要从缓存中获取的
		// 调用item-service获取商品信息
		JsonResult<List<Item>> items = itemFeignService.getItems(orderId);
		Order order = new Order();
		order.setId(orderId);
		order.setUser(u.getData());
		order.setItems(items.getData());
		return order;
	}

	@Override
	public void addOrder(Order order) {
		// 调用item-service减少商品库存
		itemFeignService.decreaseNumber(order.getItems());
		// 调用user-service增加用户积分
		userFeignService.addScore(order.getUser().getId(), 100);
		log.info("保存订单："+order);
	}

}
