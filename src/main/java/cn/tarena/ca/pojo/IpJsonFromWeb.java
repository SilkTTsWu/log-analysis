package cn.tarena.ca.pojo;

/**
 * 该类是为了解析淘宝IP地址库返回的信息,根据返回的json串格式,data是对象,
 * 为此分为两个pojo类,方便Gson做解析
 * @author wuyw
 *
 */

/*获取到的Json格式
 * {"code":0,
    "data":
 	{"country":"\u4e2d\u56fd",
	 "country_id":"CN",
	 "area":"\u534e\u5357",
	 "area_id":"800000",
	 "region":"\u5e7f\u4e1c\u7701",
	 "region_id":"440000",
	 "city":"\u5e7f\u5dde\u5e02",
	 "city_id":"440100",
	 "county":"\u8d8a\u79c0\u533a",
	 "county_id":"440104",
	 "isp":"\u7535\u4fe1",
	 "isp_id":"100017",
	 "ip":"219.136.134.157"}
}*/

public class IpJsonFromWeb {
	public Integer code;
	public IpDataFromWeb data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public IpDataFromWeb getData() {
		return data;
	}

	public void setData(IpDataFromWeb data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "IpJsonFromWeb [code=" + code + ", data=" + data + "]";
	}
}
