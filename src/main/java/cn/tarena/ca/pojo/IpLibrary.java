package cn.tarena.ca.pojo;

/**
 * Ip地址库实体类 对应数据库表ipInfo
 * 
 * @author wuyw
 *
 */
public class IpLibrary {
	public Integer id;
	public String name;
	public Integer countryId;
	public Integer regionId;
	public Integer cityId;
	public Integer countyId;
	public Integer ispId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	public Integer getIspId() {
		return ispId;
	}

	public void setIspId(Integer ispId) {
		this.ispId = ispId;
	}

	@Override
	public String toString() {
		return "IpLibrary [id=" + id + ", name=" + name + ", countryId=" + countryId + ", regionId=" + regionId
				+ ", cityId=" + cityId + ", countyId=" + countyId + ", ispId=" + ispId + "]";
	}

}
