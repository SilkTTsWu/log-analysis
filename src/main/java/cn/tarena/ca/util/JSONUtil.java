package cn.tarena.ca.util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.TypeAdapterFactory;

public class JSONUtil {

	private List<TypeAdapterFactory> factories;

	public JSONUtil() {

	}

	//当转换的时候出现类型不匹配的情况进行使用
	public JSONUtil(List<TypeAdapterFactory> factories) {
		this.factories = factories;
	}

	/**
	 * json转对象
	 */
	public static <T> T jsonToObject(String jsonStr, Type type) {
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, type);
	}

	/**
	 * json转对象
	 */
	public static <T> T jsonToObject(String jsonStr, Class<T> type) {
		Gson gson = new Gson();
		return gson.fromJson(jsonStr, type);
	}
	
	/**
	 * 对象转json 
	 */
	public static String ObjectToJson(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object);
		return json;
	}
}
