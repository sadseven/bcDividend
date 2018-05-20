package com.sadseven.bcdividend.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.sadseven.bcdividend.util.HttpUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class BCService {

	public BigDecimal getDividend(String url) {

		// String url = "http://bc.plus/Market/GetKlineData?ceId=3&type=5min&size=1000";

		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String currentDay = sdf.format(d);
		Date date;
		long currentDayTime = 0;
		long nextDayTime = 0;
		try {
			date = sdf.parse(currentDay);
			currentDayTime = date.getTime();
			nextDayTime = currentDayTime + 86400000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject doHttpGet = HttpUtil.doHttpGet(url);
		JSONArray jsonArray = doHttpGet.getJSONObject("datas").getJSONArray("data");
		BigDecimal total = new BigDecimal("0");
		BigDecimal totalVolume = new BigDecimal("0");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			long time = (long) object.get("Date"); // 获取时间
			if (time >= currentDayTime && time < nextDayTime) {
				Double maxPrice = (Double) object.get("MaxPrice"); // 获取最高价
				Double minPrice = (Double) object.get("MinPrice"); // 获取最低价
				Double volume = (Double) object.get("Volume"); // 获取成交量
				BigDecimal price = new BigDecimal(Double.toString(maxPrice))
						.add(new BigDecimal(Double.toString(minPrice))).divide(new BigDecimal("2.00000000"));
				total = total.add(price.multiply(new BigDecimal(Double.toString(volume))));
				totalVolume = totalVolume.add(new BigDecimal((Double.toString(volume))));
			} else {
				continue;
			}
		}
		return total;
	}

}
