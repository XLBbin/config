package com.tedu.service;

import com.tedu.pojo.Order;

public interface OrderService {
	//获取订单数据
	Order getOrder(String orderId);
	//保存订单
	void addOrder(Order order);
	
}
