package broker.twotier.vo;

//주식정보를 저장하는 vo클래스.....

public class StockRec {
	
	private String symbol;
	private float price;
	
	public StockRec() {}
	public StockRec(String symbol, float price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "StockRec [symbol=" + symbol + ", price=" + price + "]";
	}

}
