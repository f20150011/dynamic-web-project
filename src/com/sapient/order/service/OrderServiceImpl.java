package com.sapient.order.service;

import com.sapient.order.dto.Order;
import com.sapient.order.repository.IOrderRepository;
import com.sapient.order.repository.OrderRepositoryHibernate;
import com.sapient.order.repository.OrderRepositoryJDBC;
import com.sapient.order.repository.OrderRepositoryMongoDB;
import com.sapient.order.repository.OrderRepositoryPSQL;

public class OrderServiceImpl implements IOrderService {

	IOrderRepository orderRepository = new OrderRepositoryMongoDB();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sapient.order.service.IOrderService#processOrder()
	 */
	@Override
	public void processOrder(Order order) {
		// sapient people are allowed for any price
		if (order.getCompany().equals("sapient")) {
			orderRepository.save(order);
		}
		// others only less than $50
		else if(order.getPrice() <= 50){
			orderRepository.save(order);
		}
	}

}
