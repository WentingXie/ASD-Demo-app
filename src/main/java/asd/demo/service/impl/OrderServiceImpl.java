package asd.demo.service.impl;

import java.util.List;

import asd.demo.model.Order;
import asd.demo.model.dao.IOrderDao;
import asd.demo.model.dao.impl.OrderDaoImpl;
import asd.demo.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	IOrderDao orderDao = new OrderDaoImpl();

	@Override
	public int createOrder(Order order) {
		return orderDao.insertOrder(order);
	}

	@Override
	public List<Order> getOrdersByUserIdAndSequenceNumberAndStatus(String userId, String sequenceNumber,
			String status) {
		return orderDao.findOrdersByUserIdAndSequenceNumberAndStatus(userId, sequenceNumber, status);
	}

	@Override
	public int updateOrderStatus(Order order) {
		return orderDao.updateOrderStatus(order);
	}

	@Override
	public List<String> getOrdersTypesByUserId(String userId) {
		return orderDao.findOrdersTypesByUserId(userId);
	}

}
