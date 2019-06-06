/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.dao
 */
package com.foodordersystem.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodordersystem.model.History;
import com.foodordersystem.model.Orders;


/**
 * @author Tharaka Chandralal
 */
public interface OrdersDao extends CrudRepository<Orders, String>{

	Orders findOneByOrderID(String orderID)throws Exception;
	
	List<Orders> findAllByStatus(String status)throws Exception;
	
	Orders findOneByHistory(History history)throws Exception;
	
	List<Orders>findAllByStatusAndDateOrderByDateDesc(String status,Date date)throws Exception;
}
