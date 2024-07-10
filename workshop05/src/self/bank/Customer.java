package self.bank;

public class Customer {
	private String name;
	private int ssn;
	
	Address address;
	Account account;

	public Customer() {}

	public Customer(String name, int ssn, Address address, Account account) {
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public int getSsn() {
		return ssn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String toString() {
		return "고객명: "+name+"\n주소: "+address+"\n계좌번호: "+account;
	}

}



