package Actors;


public class Books {
	/**
	 * ���
	 */
	String bookNumber;
	String bookName;
	/**
	 * ����
	 */
	String author;
	/**
	 * ������
	 */
	String press;
	/**
	 * ������
	 */
	String count;
	/**
	 * �۸�
	 */
	String price;
	@Override
	public String toString() {
		return   bookNumber + "," + bookName + "," + author + "," + press
				+ "," + count +","+price;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
