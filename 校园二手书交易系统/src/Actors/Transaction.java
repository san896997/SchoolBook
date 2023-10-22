package Actors;

public class Transaction {
	/**
	 * 流水号
	 */
	String serialNo;
	/**
	 * 用户ID
	 */
	String id;
	/**
	 * 书号
	 */
	String number;
	/**
	 * 日期
	 */
	String data1;
	/**
	 * 类型
	 */
	String type;
	/**
	 * 订单状态
	 */
	String order;
	@Override
	public String toString() {
		return   serialNo + "," + id + "," + number + "," + data1
				+ "," + type + "," + order ;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
}
