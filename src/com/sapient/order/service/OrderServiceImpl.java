package com.sapient.order.service;

import com.sapient.order.dto.Order;

public class OrderServiceImpl implements IOrderService {

	/* (non-Javadoc)
	 * @see com.sapient.order.service.IOrderService#processOrder()
	 */
	@Override
	public void processOrder(Order order) {
		System.out.println("process order");
	}
	
}
