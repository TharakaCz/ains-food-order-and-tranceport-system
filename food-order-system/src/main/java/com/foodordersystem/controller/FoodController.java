/**
 * Jun 4, 2019	
 * food-order-system
 * com.foodordersystem.controller
 */
package com.foodordersystem.controller;

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

import com.foodordersystem.helper.FoodDto;
import com.foodordersystem.service.FoodService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@PostMapping(value="/saveFood")
	public ResponseEntity<Object>saveFood(@RequestBody FoodDto foodDto){
		try {
			return new ResponseEntity<Object>(foodService.saveFood(foodDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deleteFood/{foodID}")
	public ResponseEntity<Object>deleteFood(@PathVariable("foodID") String foodID){
		try {
			return new ResponseEntity<Object>(foodService.deleteFood(foodID),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updateFood")
	public ResponseEntity<Object>updateFood(@RequestBody FoodDto foodDto){
		try {
			return new ResponseEntity<Object>(foodService.updateFood(foodDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/searchFood/{foodID}")
	public ResponseEntity<Object>searchFood(@PathVariable("foodID") String foodID){
		try {
			return new ResponseEntity<Object>(foodService.searchFood(foodID),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllFood")
	public ResponseEntity<Object>getAllFood(){
		try {
			return new ResponseEntity<Object>(foodService.getAllFood(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
