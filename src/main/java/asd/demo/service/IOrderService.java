package asd.demo.service;

import java.util.List;

import asd.demo.model.Order;

public interface IOrderService {

	int createOrder(Order order);

	List<Order> getOrdersByUserIdAndSequenceNumberAndStatus(String userId, String sequenceNumber, String status);

	int updateOrderStatus(Order order);

	List<String> getOrdersTypesByUserId(String userId);

}
