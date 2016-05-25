package cn.tarena.ca.pojo;

/**
 * 该类并非真正意义上的实体类,是为了作为数据传输而定义的
 * 
 * @author wuyw
 *
 */
public class DataByHours {
	public String timeByHours;
	public String pv;
	public String uv;
	public String vv;
	public String uniqueIp;
	public String jumpOutRate;
	public String avgOnline;

	public String getVv() {
		return vv;
	}

	public void setVv(String vv) {
		this.vv = vv;
	}

	public String getTimeByHours() {
		return timeByHours;
	}

	public void setTimeByHours(String timeByHours) {
		this.timeByHours = timeByHours;
	}

	public String getPv() {
		return pv;
	}

	public void setPv(String pv) {
		this.pv = pv;
	}

	public String getUv() {
		return uv;
	}

	public void setUv(String uv) {
		this.uv = uv;
	}

	public String getUniqueIp() {
		return uniqueIp;
	}

	public void setUniqueIp(String uniqueIp) {
		this.uniqueIp = uniqueIp;
	}

	public String getJumpOutRate() {
		return jumpOutRate;
	}

	public void setJumpOutRate(String jumpOutRate) {
		this.jumpOutRate = jumpOutRate;
	}

	public String getAvgOnline() {
		return avgOnline;
	}

	public void setAvgOnline(String avgOnline) {
		this.avgOnline = avgOnline;
	}

	@Override
	public String toString() {
		String s = "timebyhours" + timeByHours + "pv:" + pv + "uv:" + uv + "avgOnline:" + avgOnline;
		return s;
	}

}
