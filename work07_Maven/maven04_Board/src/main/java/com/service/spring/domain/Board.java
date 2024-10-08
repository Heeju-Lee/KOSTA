package com.service.spring.domain;
/*
 * 게시글에 대한 정보를 담고 있는 클래스
 * 해당 게시글은 로그인한 사람만 쓸수있다.
 * 
 * Board와 Member 클래스 간의 Relation이 지정되어 있다.
 * Has a Relation -- Framework 에서 DI
 */
public class Board {
	//이전의 password 컬럼은 제외했다...
	private int no;
	private String title;
	private String content;
	private int count;
	private String writeDate;//컬럼명과 다르다.
	
	private Member member;//Has a Relation...? ResultMap을 어떻게 설정해야 할지

	public Board(int no, String title, String content, int count,
			String writeDate, Member member) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
		this.member = member;
	}
	
	public Board(String title, String content, 	 Member member) {
		super();
		this.title = title;
		this.content = content;			
		this.member = member;
	}

	//기본생성자
	public Board() {	}

	public Board(int no, String title, String content, int count,
			String writeDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.count = count;
		this.writeDate = writeDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content="
				+ content + ", count=" + count + ", writeDate=" + writeDate
				+ ", member=" + member + "]";
	}	
}

















