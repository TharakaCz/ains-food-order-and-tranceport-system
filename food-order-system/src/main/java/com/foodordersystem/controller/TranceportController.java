/**
 * Jun 6, 2019	
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

import com.foodordersystem.helper.TranceportDto;
import com.foodordersystem.service.TranceportService;

/**
 * @author Tharaka Chandralal
 */
@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/tranceport")
public class TranceportController {

	@Autowired
	private TranceportService tranceportService;
	
	@PostMapping(value="/saveTranceport")
	public ResponseEntity<Object>saveTranceport(@RequestBody TranceportDto tranceportDto){
		try {
			return new ResponseEntity<Object>(tranceportService.saveTranceport(tranceportDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value="/updateTranceport")
	public ResponseEntity<Object>updateTranceport(@RequestBody TranceportDto tranceportDto){
		try {
			return new ResponseEntity<Object>(tranceportService.updateTranceport(tranceportDto),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/deleteTranceport/{tranceportID}")
	public ResponseEntity<Object>deleteTranceport(@PathVariable("tranceportID")String tranceportID){
		try {
			return new ResponseEntity<Object>(tranceportService.deleteTranceport(tranceportID),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/searchTranceport/{tranceportID}")
	public ResponseEntity<Object>searchTranceport(@PathVariable("tranceportID")String tranceportID){
		try {
			return new ResponseEntity<Object>(tranceportService.searchTranceport(tranceportID),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/getAllTranceports")
	public ResponseEntity<Object>getAllTranceport(){
		try {
			return new ResponseEntity<Object>(tranceportService.getAllTranceport(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
