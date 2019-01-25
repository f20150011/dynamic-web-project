package com.sapient.order.repository;

import com.sapient.order.dto.Order;

public interface IOrderRepository {

	public void save(Order order);
	
}
