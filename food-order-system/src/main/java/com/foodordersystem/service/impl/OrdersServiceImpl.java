/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.service.impl
 */
package com.foodordersystem.service.impl;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodordersystem.dao.FoodDao;
import com.foodordersystem.dao.HistoryDao;
import com.foodordersystem.dao.OrderDetailsDao;
import com.foodordersystem.dao.OrdersDao;
import com.foodordersystem.helper.FoodDto;
import com.foodordersystem.helper.HistoryDto;
import com.foodordersystem.helper.OrderDetailsDto;
import com.foodordersystem.helper.OrdersDto;
import com.foodordersystem.model.Food;
import com.foodordersystem.model.History;
import com.foodordersystem.model.OrderDetails;
import com.foodordersystem.model.Orders;
import com.foodordersystem.service.OrdersService;
import com.foodordersystem.utill.AppConstent;

/**
 * @author Tharaka Chandralal
 */
@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private HistoryDao historyDao;
	
	
	/* (non-Javadoc)
	 * @see com.foodordersystem.service.OrdersService#saveOrders(com.foodordersystem.helper.PlaceOrderDto)
	 */
	@Override
	public String saveOrders(OrdersDto ordersDto) throws Exception {
		
		Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	   
	    
		Orders orders = new Orders();
		History history = new History();
		
		
		orders.setOrderID(UUID.randomUUID().toString());
		orders.setDate(new Date());
		orders.setDepartment(ordersDto.getDepartment());
		orders.setOrderSenderName(ordersDto.getOrderSenderName());
		orders.setStatus(AppConstent.ACTIVE);
		
		history.setHistoryID(UUID.randomUUID().toString());
		history.setDate(new Date());
		history.setHistoryType(AppConstent.HISTORY_TYPE_ORDER);
		history.setStatus(AppConstent.ACTIVE);
		history.setTime(formattedDate);
		history.setDepartmentName(ordersDto.getDepartment());
		
		orders.setHistory(historyDao.save(history));
		ordersDao.save(orders);
		
		ordersDto.getOrderDetailsDtos().forEach(each->{
			try {
				Food food = foodDao.findOneByFoodID(each.getFoodDto().getFoodID());
				OrderDetails orderDetails = new OrderDetails();
				
				orderDetails.setOrderDetailID(UUID.randomUUID().toString());
				orderDetails.setFood(food);
				orderDetails.setOrders(orders);
				orderDetails.setQuntity(each.getQuntity());
				orderDetails.setStatus(AppConstent.ACTIVE);
				
				orderDetailsDao.save(orderDetails);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return "Order Save Succsessfully";
		
	}


	/* (non-Javadoc)
	 * @see com.foodordersystem.service.OrdersService#updateOrders(com.foodordersystem.helper.OrdersDto)
	 */
	@Override
	public String updateOrders(OrdersDto ordersDto) throws Exception {
		
		Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(date);
	    
		Orders orders = ordersDao.findOneByOrderID(ordersDto.getOrderID());
		History history = historyDao.findOneByHistoryID(ordersDto.getHistoryDto().getHistoryID());
		
		
		orders.setDate(new Date());
		orders.setDepartment(ordersDto.getDepartment());
		
		orders.setOrderSenderName(ordersDto.getOrderSenderName());
		orders.setStatus(AppConstent.ACTIVE);
		
		
		history.setDate(new Date());
		history.setTime(formattedDate);
		history.setDepartmentName(ordersDto.getDepartment());
		orders.setHistory(historyDao.save(history));
		
		ordersDao.save(orders);
		
		orders.getOrderDetails().forEach(each->{
			OrderDetails orderDetails = orderDetailsDao.findOneByOrderDetailID(each.getOrderDetailID());
			Food food = foodDao.findOneByFoodID(each.getFood().getFoodID());
			
			orderDetails.setQuntity(each.getQuntity());
			orderDetails.setFood(food);
			
			orderDetailsDao.save(orderDetails);
		});
		
		return "Order Update Succsessfull . . !";
	}


	/* (non-Javadoc)
	 * @see com.foodordersystem.service.OrdersService#deleteOrders(java.lang.String)
	 */
	@Override
	public String deleteOrders(String orderID) throws Exception {
		
		Orders orders = ordersDao.findOneByOrderID(orderID);
		List<OrderDetails> orderDetails = orderDetailsDao.findAllByOrders(orders);
		History history = historyDao.findOneByHistoryID(orders.getHistory().getHistoryID());
		
		if (orders != null) {
			orders.setStatus(AppConstent.DEACTIVE);
			ordersDao.save(orders);
			
			orderDetails.forEach(each->{
				each.setStatus(AppConstent.DEACTIVE);
				orderDetailsDao.save(each);
			});
			
			history.setStatus(AppConstent.DEACTIVE);
			historyDao.save(history);
			
			return "Order Deletion Succsess . . !";
		}else {
			return "Order Deletion Faild Try Again . . !";
		}
	}


	/* (non-Javadoc)
	 * @see com.foodordersystem.service.OrdersService#search(java.lang.String)
	 */
	@Override
	public OrdersDto search(String orderID) throws Exception {
		
		Orders orders = ordersDao.findOneByOrderID(orderID);
		History history = historyDao.findOneByHistoryID(orders.getHistory().getHistoryID());
		OrdersDto ordersDto = new OrdersDto();
		HistoryDto historyDto = new HistoryDto();
		List<OrderDetails> orderDetails = orderDetailsDao.findAllByOrders(orders);
		ArrayList<OrderDetailsDto>orderDetailsDto = new ArrayList<>();
		
		ordersDto.setOrderID(orders.getOrderID());
		ordersDto.setDate(orders.getDate());
		ordersDto.setDepartment(orders.getDepartment());
		
		ordersDto.setOrderSenderName(orders.getOrderSenderName());
		
		historyDto.setHistoryID(history.getHistoryID());
		historyDto.setDate(history.getDate());
		historyDto.setHistoryType(history.getHistoryType());
		historyDto.setTime(history.getTime());
		
		orderDetails.forEach(each->{
			
			try {
				orderDetailsDto.add(getOrderDetails(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		});
		
		ordersDto.setHistoryDto(historyDto);
		ordersDto.setOrderDetailsDtos(orderDetailsDto);
		
		return ordersDto;
	}
	

	


	/* (non-Javadoc)
	 * @see com.foodordersystem.service.OrdersService#getAllOrders()
	 */
	@Override
	public List<OrdersDto> getAllOrders() throws Exception {
		
		List<Orders> orders = ordersDao.findAllByStatus(AppConstent.ACTIVE);
		ArrayList<OrdersDto>ordersDtos = new ArrayList<>();
		
		orders.forEach(each->{
			try {
				ordersDtos.add(getOrders(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return ordersDtos;
	}

	private OrdersDto getOrders(Orders orders)throws Exception{
		
		History history = historyDao.findOneByHistoryID(orders.getHistory().getHistoryID());
		List<OrderDetails>orderDetails = orderDetailsDao.findAllByOrders(orders);
		ArrayList<OrderDetailsDto>orderDetailsDtos = new ArrayList<>();
		HistoryDto historyDto = new HistoryDto();
		
		historyDto.setHistoryID(history.getHistoryID());
		historyDto.setDate(history.getDate());
		historyDto.setHistoryType(history.getHistoryType());
		historyDto.setTime(history.getTime());
		historyDto.setDepartmentName(history.getDepartmentName());
		
		orderDetails.forEach(each->{
			try {
				orderDetailsDtos.add(getOrderDetails(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		OrdersDto ordersDto = new OrdersDto();
		ordersDto.setOrderID(orders.getOrderID());
		ordersDto.setDate(orders.getDate());
		ordersDto.setDepartment(orders.getDepartment());
		ordersDto.setOrderSenderName(orders.getOrderSenderName());
		
		ordersDto.setHistoryDto(historyDto);
		ordersDto.setOrderDetailsDtos(orderDetailsDtos);
		
		return ordersDto;
	}
	
	private OrderDetailsDto getOrderDetails(OrderDetails orderDetails)throws Exception{
		
		Food food = foodDao.findOneByFoodID(orderDetails.getFood().getFoodID());
		FoodDto foodDto = new FoodDto();
		foodDto.setFoodID(food.getFoodID());
		foodDto.setFoodName(food.getFoodName());
		
		
		OrderDetailsDto orderDetailsDto = new OrderDetailsDto();
		orderDetailsDto.setOrderDetailID(orderDetails.getOrderDetailID());
		orderDetailsDto.setQuntity(orderDetails.getQuntity());
		orderDetailsDto.setFoodDto(foodDto);
		
		return orderDetailsDto;
	}


	/* (non-Javadoc)
	 * @see com.foodordersystem.service.OrdersService#getAllOrdersByDate(java.util.Date)
	 */
	@Override
	public List<OrdersDto> getAllOrdersByDate(Date date) throws Exception {
		
		List<Orders>orders = ordersDao.findAllByStatusAndDateOrderByDateDesc(AppConstent.ACTIVE, date);
		ArrayList<OrdersDto>ordersDtos = new ArrayList<>();
		
		orders.forEach(each->{
			try {
				ordersDtos.add(getOrders(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return ordersDtos;
	}
}

