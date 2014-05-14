package mvc.exam2;

public class BookDto {
	private String title;
	private String author;
	private int price;
	private int quantity;
	//외부에서 직접 값을 저장하면 미처 그값이 정확한 값인지 확인할 타이밍이 없다
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
