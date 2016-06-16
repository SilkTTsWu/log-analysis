package cn.tarena.ca.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IpAnalysis {
	/*
	public String getIpJson(String content, String encodingString) {
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		String returnStr = this.getResult(urlStr, content, encodingString);
		return returnStr;
	}*/

	/**
	 * 该方法可以通过传ip地址获取到淘宝ip地址库返回的信息
	 * urlStr 这里给的就是淘宝地址库的地址  http://ip.taobao.com/service/getIpInfo.php
	 * @param content 需要查询的ip地址 必须以该形式传参:IpAnalysis.getResult("ip="+ip, "utf-8")
	 * @param encoding 编码格式
	 * @return
	 */
	public static String getResult(String content, String encoding) {
		URL url = null;
		HttpURLConnection connection = null;
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();// 新建连接实例
			connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫秒
			connection.setReadTimeout(2000);// 设置读取数据超时时间，单位毫秒
			connection.setDoOutput(true);// 是否打开输出流 true|false
			connection.setDoInput(true);// 是否打开输入流true|false
			connection.setRequestMethod("POST");// 提交方法POST|GET
			connection.setUseCaches(false);// 是否缓存true|false
			connection.connect();// 打开连接端口
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
			out.writeBytes(content);// 写数据,也就是提交你的表单 name=xxx&pwd=xxx
			out.flush();// 刷新
			out.close();// 关闭输出流
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));// 往对端写完数据对端服务器返回数据
			// ,以BufferedReader流来读取
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();// 关闭连接
			}
		}
		return null;
	}

}
