/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.dao
 */
package com.foodordersystem.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodordersystem.model.OrderDetails;
import com.foodordersystem.model.Orders;

/**
 * @author Tharaka Chandralal
 */
public interface OrderDetailsDao extends CrudRepository<OrderDetails, String>{

	List<OrderDetails>findAllByOrders(Orders orders)throws Exception;
	OrderDetails findOneByOrderDetailID(String orderDetailID);
}
