package com.tedu.service;

import java.util.List;

import com.tedu.pojo.Item;

public interface ItemService {
	/*
	 * 通过订单id来获取商品列表
	 */
	List<Item> getItems(String orderId);
	/*
	 * 在保存订单时减少商品库存
	 */
	void decreaseNumbers(List<Item> list);
	
}
