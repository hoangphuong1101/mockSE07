package model.bean;

public class Province {
	int provinceId;
	String name;

	public Province() {
		super();
	}

	public Province(int provinceId, String name) {
		super();
		this.provinceId = provinceId;
		this.name = name;
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
