/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.service
 */
package com.foodordersystem.service;

import java.util.List;

import com.foodordersystem.helper.OrdersDto;


/**
 * @author Tharaka Chandralal
 */
public interface OrdersService {

	public String saveOrders(OrdersDto ordersDto)throws Exception;
	
	public String updateOrders(OrdersDto ordersDto)throws Exception;
	
	public String deleteOrders(String orderID)throws Exception;
	
	public OrdersDto search(String orderID)throws Exception;
	
	public List<OrdersDto> getAllOrders()throws Exception;
}
