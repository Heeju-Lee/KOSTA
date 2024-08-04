package broker.twotier.vo;
/*
 누가....ssn
 어떤 주식을....symbol
 얼마만큼....quantity
 가지고 있는지에 대한 정보를 저장하는 클래스
 shares 테이블 정보이다.
 */

public class SharesRec {
	private String ssn;
	private String symbol;
	private int quantity;
	
	public SharesRec() {}
	public SharesRec(String ssn, String symbol, int quantity) {
		super();
		this.ssn = ssn;
		this.symbol = symbol;
		this.quantity = quantity;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "SharesRec [ssn=" + ssn + ", symbol=" + symbol + ", quantity=" + quantity + "]";
	}
}
