package com.sadseven.bcdividend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadseven.bcdividend.mapper.DividendMapper;
import com.sadseven.bcdividend.model.Dividend;
import com.sadseven.bcdividend.model.DividendExample;

@Service
public class DividendService {
	
	@Autowired
    private DividendMapper dividendDao;
	
	public void insert(Dividend record) {
		int insert = dividendDao.insert(record);
		System.out.println(insert);
	}
	
	public List<Dividend> selectByExample(DividendExample record) {
		List<Dividend> records = dividendDao.selectByExample(record);
		return records;
	}
}
