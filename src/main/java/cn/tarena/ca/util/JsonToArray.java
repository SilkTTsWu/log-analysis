package cn.tarena.ca.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import cn.tarena.ca.pojo.DataByHours;


/**
 * 此工具类将json文本文件按行读入,并将其转换为Java数组。
 * @author wuyw
 *
 */
public class JsonToArray {
	
	/**
	 * 该方法将读json文件,并将每一条数据存入到数组当中...
	 * @param path
	 * @return
	 */
	public static List<DataByHours> readJsonToArray(String path){
		String fileName = path;
		File file = new File(fileName);
		StringBuffer sb = new StringBuffer();
		String line;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine())!= null){
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String json = sb.toString();
		
		/*
		 * 利用gson将json转List
		 */
		List<DataByHours> list = new ArrayList<>();
		Gson gson = new Gson();
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(json);//将json字符串转换成JsonElement
		JsonArray jsonArray = jsonElement.getAsJsonArray();//将JsonElement转换成JsonArray
		Iterator<JsonElement> iterator = jsonArray.iterator();//Iterator
		while(iterator.hasNext()){//遍历
			jsonElement=iterator.next();//提取JsonElement
			json=jsonElement.toString();//JsonElement转换成String
			DataByHours data = gson.fromJson(json, DataByHours.class);//String转化成JavaBean
			list.add(data);//加入到List当中
		}
		return list;
	}
	
	/**
	 * 测试方法
	 */
	/*@Test
	public void test() {
		List<DataByHours> list = readJsonToArray("d:/temp/data_by_hours.json");
		System.out.println(list.get(0));
		DataByHours dbh = (DataByHours) list.get(0);
		System.out.println(dbh.getPv());
	}*/
	
	
}
