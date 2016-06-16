package cloud_analysis_test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

import com.google.common.reflect.TypeToken;

import cn.tarena.ca.pojo.IpJsonFromWeb;
import cn.tarena.ca.util.IpAnalysis;
import cn.tarena.ca.util.JSONUtil;
import cn.tarena.ca.util.UnicodeToCH;

/**
 * 根据IP地址获取详细的地域信息
 */
public class ip_demo {
	/**
	 * 
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getAddresses(String content, String encodingString) throws UnsupportedEncodingException {
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		String returnStr = this.getResult(urlStr, content, encodingString);
		System.out.println(returnStr);
//		if (returnStr != null) {
//
//			// 处理返回的省市区json信息
//			String[] temp = returnStr.split(",");
//			if (temp.length < 3) {
//				return "0";// 无效IP，局域网测试
//			}
//			String country = "";
//			String area = "";
//			String region = "";
//			String city = "";
//			String county = "";
//			String isp = "";
//			for (int i = 0; i < temp.length; i++) {
//				switch (i) {
//				case 1:
//					country = (temp[i].split(":"))[2].replaceAll("\"", "");
//					country = UnicodeToCH.decodeUnicode(country);// 国家 break;
//				case 3:
//					area = (temp[i].split(":"))[1].replaceAll("\"", "");
//					area = UnicodeToCH.decodeUnicode(area);// 地区 break;
//				case 5:
//					region = (temp[i].split(":"))[1].replaceAll("\"", "");
//					region = UnicodeToCH.decodeUnicode(region);// 省份 break;
//				case 7:
//					city = (temp[i].split(":"))[1].replaceAll("\"", "");
//					city = UnicodeToCH.decodeUnicode(city);// 市区 break;
//				case 9:
//					county = (temp[i].split(":"))[1].replaceAll("\"", "");
//					county = UnicodeToCH.decodeUnicode(county);// 地区 break;
//				case 11:
//					isp = (temp[i].split(":"))[1].replaceAll("\"", "");
//					isp = UnicodeToCH.decodeUnicode(isp);// ISP公司 break;
//				}
//			}
//		}
		return returnStr;
	}

	/**
	 * @param urlStr
	 *            请求的地址
	 * @param content
	 *            请求的参数 格式为：name=xxx&pwd=xxx
	 * @param encoding
	 *            服务器端请求编码。如GBK,UTF-8等
	 * @return
	 */
	private String getResult(String urlStr, String content, String encoding) {
//		urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		URL url = null;
		HttpURLConnection connection = null;
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
	
	@Test
	public void test2(){
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		String str = getResult(urlStr, "ip="+"219.136.134.157", "utf-8");
		System.out.println(str);
	}

	// 测试
	@Test
	public void test() {
		ip_demo demo = new ip_demo();
		// 测试ip 219.136.134.157 中国=华南=广东省=广州市=越秀区=电信
		String ip = "219.136.134.157";
		String address = "";
		try {
			address = demo.getAddresses("ip=" + ip, "utf-8");
			System.out.println(address);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(address);
//		IpJsonFromWeb data = JSONUtil.jsonToObject(address, new TypeToken<IpJsonFromWeb>(){}.getType());
//		System.out.println(data);
	}
	@Test
	public void test1(){
		String ip = "219.136.134.157";
		String str = IpAnalysis.getResult("ip=" + ip, "utf-8");
		System.out.println(str);
	}
}