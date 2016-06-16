package cn.tarena.ca.pojo;

public class AreaLibrary {
	public Integer id;
	public String name;
	public Integer pid;
	public Integer areaId;
	public Integer level;

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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "AreaLibrary [id=" + id + ", name=" + name + ", pid=" + pid + ", areaId=" + areaId + ", level=" + level
				+ "]";
	}

}
