/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.service
 */
package com.foodordersystem.service;

import java.util.List;

import com.foodordersystem.helper.TranceportDto;

/**
 * @author Tharaka Chandralal
 */
public interface TranceportService {

	public String saveTranceport(TranceportDto tranceportDto)throws Exception;
	
	public String deleteTranceport(String tranceportID)throws Exception;
	
	public String updateTranceport(TranceportDto tranceportDto)throws Exception;
	
	public TranceportDto searchTranceport(String tranceportID)throws Exception;
	
	public List<TranceportDto> getAllTranceport()throws Exception;
}
