package Actors;

public class User{
	String id;
	String password;
	/**
	 * 用户类型
	 * 1. 用户
	 * 2. 管理员
	 */
	String type;
	String name;
	String unit;
	String telephone;
	/**
	 * 账户余额
	 */
	String balance;

	@Override
	public String toString() {
		return id + "," + password + "," + type +","+name+","+unit+","+telephone+","+balance;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
}