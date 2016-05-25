package cn.tarena.ca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.tarena.ca.pojo.DataByHours;
import cn.tarena.ca.util.JsonToArray;

/*list_uv.add(data.uv);
			list_vv.add(data.vv);
			list_uniqueIp.add(data.uniqueIp);
			list_jumpOutRate.add(data.jumpOutRate);
			list_avgOnline.add(data.avgOnline);*/

/*//得到数组形式的uv
		String[] data_uv = (String[])list_uv.toArray(new String[0]);
		//得到数组形式的vv
		String[] data_vv = (String[])list_vv.toArray(new String[0]);
		//得到数组形式的独立IP
		String[] data_uniqueIp = (String[])list_uniqueIp.toArray(new String[0]);
		//得到数组形式的跳出率
		String[] data_jumpOutRate = (String[])list_jumpOutRate.toArray(new String[0]);
		//得到数组形式的平均在线时长
		String[] data_avgOnline = (String[])list_avgOnline.toArray(new String[0]);*/

@Service
public class RealTimeService {
	
	/**
	 * 该方法可以获取到当天的数据,之后会交给前台进行解析
	 * @return list 返回的list交给Controller层
	 */
	public List<DataByHours> queryRealTime_today(){
		List<DataByHours> list = JsonToArray.readJsonToArray("d:/temp/data_by_hours.json");
		return list;
		
	}
	
	/**
	 * 该方法可以获取到昨天的数据,在之后会交给前台进行解析
	 * @return list 返回的list交给Controller层
	 */
	public List<DataByHours> queryRealTime_yestoday(){
		List<DataByHours> list = JsonToArray.readJsonToArray("d:/temp/data_by_hours_yestoday.json");
		return list;
	}
	
	/**
	 * 该方法可以获取到7天前的数据,在之后会交给前台进行解析
	 * @return list 返回的list交给Controller层
	 */
	public List<DataByHours> queryRealTime_7daysago(){
		List<DataByHours> list = JsonToArray.readJsonToArray("d:/temp/data_by_hours_7.json");
		return list;
	}
	
	/**
	 * 该方法可以获取到30天前的数据,在之后会交给前台进行解析
	 * @return list 返回的list交给Controller层
	 */
	public List<DataByHours> queryRealTime_30daysago(){
		List<DataByHours> list = JsonToArray.readJsonToArray("d:/temp/data_by_hours_30.json");
		return list;
	}
	
	/* 
	 *List<String> list_pv = new ArrayList<String>();
	 * 这是以前的写法,直接在后台进行option的拼接并传到前台,现在仅在后台组织数据,在前台写option
		for (DataByHours data : list) {
			list_pv.add(data.pv);
		}
		
		//得到数组形式的pv
		String[] data_pv = (String[])list_pv.toArray(new String[0]);
		
	 * 将组织好的数据传入,拼接option,并返回显示PV的option
		 
		Option option = RealTimeTrendencyChart.LineTrendencyChart("浏览量(PV)", data_pv, data_pv, data_pv, data_pv);
		return option;*/	
	
}
