package web.servlet.model;

public class User {
	private String id;
	private String pw;
	private String nickName;
	private String phoneNum;
	private String address;
	
	public User() {}
	
	public User(String id, String pw, String name, String phoneNum, String address) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickName = nickName;
		this.phoneNum = phoneNum;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getnickName() {
		return nickName;
	}

	public void setnickName(String name) {
		this.nickName = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", nickName=" + nickName + ", phoneNum=" + phoneNum + ", address=" + address
				+ "]";
	}
}
