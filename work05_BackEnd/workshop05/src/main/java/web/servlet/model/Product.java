package web.servlet.model;

public class Product {

	private int productNum;
	private String name;
	private int price;
	private String desc;
	
	public Product() {}
	public Product(int productNum, String name, int price, String desc) {
		this.productNum = productNum;
		this.name = name;
		this.price = price;
		this.desc = desc;
	}
	
	public Product(String name, int price, String desc) {
		this(0, name, price, desc);
	}
	
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "Product [productNum=" + productNum + ", name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}
	
}
