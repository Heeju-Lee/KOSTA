package com.stay.vo;

public class Review {
	String content;
	int rating;
	
	public Review() {}
	public Review(String content, int rating) {
		super();
		this.content = content;
		this.rating = rating;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Review [content=" + content + ", rating=" + rating + "]";
	}

}
