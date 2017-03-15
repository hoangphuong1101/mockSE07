package model.bean;

public class Village {
	int villageId;
	int districtId;
	String name;

	public Village() {
		super();
	}

	public Village(int villageId, int districtId, String name) {
		super();
		this.villageId = villageId;
		this.districtId = districtId;
		this.name = name;
	}

	public int getVillageId() {
		return villageId;
	}

	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
