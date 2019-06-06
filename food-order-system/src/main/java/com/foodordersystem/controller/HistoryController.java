/**
 * Jun 6, 2019	
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodordersystem.service.HistoryService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/history")
public class HistoryController {

	@Autowired
	private HistoryService historyService;
	
	@GetMapping(value="/getAllHistory")
	public ResponseEntity<Object>getAllHistory(){
		try {
			return new ResponseEntity<Object>(historyService.getAllHistory(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/searchHistory/{date}")
	public ResponseEntity<Object>searchHistory(@PathVariable("date")Date date){
		try {
			return new ResponseEntity<Object>(historyService.searchHistory(date),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deleteHistory/{historyID}")
	public ResponseEntity<Object>deleteHistory(@PathVariable("historyID") String historyID){
		try {
			return new ResponseEntity<Object>(historyService.deleteHistory(historyID),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
