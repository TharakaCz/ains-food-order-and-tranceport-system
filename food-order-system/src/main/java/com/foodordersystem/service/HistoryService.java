/**
 * Jun 5, 2019	
 * food-order-system
 * com.foodordersystem.service
 */
package com.foodordersystem.service;

import java.util.Date;
import java.util.List;

import com.foodordersystem.helper.HistoryDto;

/**
 * @author Tharaka Chandralal
 */
public interface HistoryService {

	
	public String deleteHistory(String historyID)throws Exception;
	
	public List<HistoryDto> getAllHistory()throws Exception;
	
	public List<HistoryDto> searchHistory(Date date)throws Exception;
}
