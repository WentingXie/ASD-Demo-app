package asd.demo.model.dao;

import java.util.List;

import asd.demo.model.Order;

public interface IOrderDao {

	int insertOrder(Order Order);

	int updateOrderInfo(Order Order);

	List<Order> findOrdersByUserIdAndSequenceNumberAndStatus(String userId, String sequenceNumber, String status);

	int updateOrderStatus(Order order);

	List<String> findOrdersTypesByUserId(String userId);
}
