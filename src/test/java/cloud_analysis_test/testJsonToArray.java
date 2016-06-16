package cloud_analysis_test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.reflect.TypeToken;

import cn.tarena.ca.pojo.DataByHours;
import cn.tarena.ca.util.JSONUtil;

public class testJsonToArray {
	//list - json
		@Test
		public void testObjectToJson(){
			DataByHours dbh1 = new DataByHours();
			dbh1.setPv("23");
			dbh1.setUv("12");
			dbh1.setVv("23");
			DataByHours dbh2 = new DataByHours();
			dbh2.setPv("323");
			dbh2.setUv("312");
			dbh2.setVv("233");
			List<DataByHours> list = new ArrayList<>();
			list.add(dbh1);
			list.add(dbh2);
			String json = JSONUtil.ObjectToJson(list);
			System.out.println(json);
		}
		
		@Test
		public void testJsonToObject(){
			DataByHours dbh1 = new DataByHours();
			dbh1.setPv("23");
			dbh1.setUv("12");
			dbh1.setVv("23");
			DataByHours dbh2 = new DataByHours();
			dbh2.setPv("323");
			dbh2.setUv("312");
			dbh2.setVv("233");
			List<DataByHours> list = new ArrayList<>();
			list.add(dbh1);
			list.add(dbh2);
			String json = JSONUtil.ObjectToJson(list);
			
			/* List<Person> rtn = JsonUtil.fromJson(jsonStr, new TypeToken<List<Person>>(){}.getType());  
		        for(Person person : rtn){  
		            System.out.println(person.getId()+","+person.getName());  
		        }  */
			List<DataByHours> list_a = JSONUtil.jsonToObject(json, new TypeToken<List<DataByHours>>(){}.getType());
			for (DataByHours dataByHours : list_a) {
				System.out.println(dataByHours.getPv()+","+dataByHours.getUv());
			}
			
		}
		
		
	
}
