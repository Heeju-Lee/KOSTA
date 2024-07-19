package test3;

class Product<T1, T2, T3>{//타입지정 여러개 가능, 대문자만 가능
	private T1 serialnumber;
	private T2 brand;
	private T3 price;//구체적으로 타입을 명시하지 않아도 됨.
	
	public Product(T1 serialnumber, T2 brand, T3 price) {
		this.serialnumber = serialnumber;
		this.brand = brand;
		this.price = price;
	}
	
	public T1 getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(T1 serialnumber) {
		this.serialnumber = serialnumber;
	}
	public T2 getBrand() {
		return brand;
	}
	public void setBrand(T2 brand) {
		this.brand = brand;
	}
	public T3 getPrice() {
		return price;
	}
	public void setPrice(T3 price) {
		this.price = price;
	}
}

public class GenericProductTest1 {

	public static void main(String[] args) {
		Product<Long, String, Double> p = new Product<>(112233L,"LG Gram", 1700000.0);//타입지정시 첫자리는 대문자
		System.out.println(p.getBrand()+","+p.getPrice());
	}
}
