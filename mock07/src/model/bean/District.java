package model.bean;

public class District {
	int districtId;
	int provinceId;
	String name;

	public District() {
		super();
	}

	public District(int districtId, int provinceId, String name) {
		super();
		this.districtId = districtId;
		this.provinceId = provinceId;
		this.name = name;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
