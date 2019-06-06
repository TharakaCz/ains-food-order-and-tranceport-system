/**
 * Jun 6, 2019	
 * food-order-system
 * com.foodordersystem.service.impl
 */
package com.foodordersystem.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodordersystem.dao.HistoryDao;
import com.foodordersystem.helper.HistoryDto;
import com.foodordersystem.model.History;
import com.foodordersystem.service.HistoryService;
import com.foodordersystem.utill.AppConstent;

/**
 * @author Tharaka Chandralal
 */
@Service
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	private HistoryDao historyDao;
	
	/* (non-Javadoc)
	 * @see com.foodordersystem.service.HistoryService#deleteHistory(java.lang.String)
	 */
	@Override
	public String deleteHistory(String historyID) throws Exception {
		
		History history = historyDao.findOneByHistoryID(historyID);
		
		history.setStatus(AppConstent.DEACTIVE);
		if (history != null) {
			historyDao.save(history);
			
			return "History Succsessfully Deleted . . !";
		}else {
			return "History Delete Faild Try Again . . !";
		}
		
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.HistoryService#getAllHistory()
	 */
	@Override
	public List<HistoryDto> getAllHistory() throws Exception {
	
		List<History>histories = historyDao.findAllByStatus(AppConstent.ACTIVE);
		ArrayList<HistoryDto> historyList = new  ArrayList<>();
		
		histories.forEach(each->{
			try {
				historyList.add(getAllHistory(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return historyList;
	}

	/* (non-Javadoc)
	 * @see com.foodordersystem.service.HistoryService#searchHistory(java.util.Date)
	 */
	@Override
	public List<HistoryDto> searchHistory(Date date) throws Exception {
		
		List<History>histories = historyDao.findAllByDateAndStatusOrderByDateDesc(date, AppConstent.ACTIVE);
		ArrayList<HistoryDto>historyDtos = new ArrayList<>();
		
		histories.forEach(each->{
			try {
				historyDtos.add(getAllHistory(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
				return historyDtos;
	}
	
	private HistoryDto getAllHistory(History history)throws Exception{
		
		HistoryDto historyDto = new HistoryDto();
		historyDto.setHistoryID(history.getHistoryID());
		historyDto.setDate(history.getDate());
		historyDto.setHistoryType(history.getHistoryType());
		historyDto.setTime(history.getTime());
		
		return historyDto;
	}
}
