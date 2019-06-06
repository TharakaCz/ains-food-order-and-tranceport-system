/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.controller
 */
package com.foodordersystem.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodordersystem.helper.OrdersDto;
import com.foodordersystem.service.OrdersService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@PostMapping(value="/placeOrder")
	public ResponseEntity<Object>placeOrder(@RequestBody OrdersDto ordersDto){
		try {
			return new ResponseEntity<Object>(ordersService.saveOrders(ordersDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/seachOrder/{orderID}")
	public ResponseEntity<Object>searchOrder(@PathVariable("orderID")String orderID){
		try {
			return new ResponseEntity<Object>(ordersService.search(orderID),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/delete/{orderID}")
	public ResponseEntity<Object>deleteOrder(@PathVariable("orderID")String orderID){
		try {
			return new ResponseEntity<Object>(ordersService.deleteOrders(orderID),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/updateOrder")
	public ResponseEntity<Object>updateOrder(@RequestBody OrdersDto ordersDto){
		try {
			return new ResponseEntity<Object>(ordersService.updateOrders(ordersDto),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllOrders")
	public ResponseEntity<Object>getAllOrders(){
		try {
			return new ResponseEntity<Object>(ordersService.getAllOrders(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllOrdersDate")
	public ResponseEntity<Object>getAllOrdersByDate(@PathVariable("date")Date date){
		try {
			return new ResponseEntity<Object>(ordersService.getAllOrdersByDate(date),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
