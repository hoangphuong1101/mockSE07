package model.bean;

public class Account {
	int accountId;
	int level;
	int categoryId;
	String name;
	String email;
	String password;
	String phone;
	int status;

	public Account() {
		super();
	}

	public Account(int accountId, int level, int categoryId, String name, String email, String password, String phone,
			int status) {
		super();
		this.accountId = accountId;
		this.level = level;
		this.categoryId = categoryId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.status = status;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
