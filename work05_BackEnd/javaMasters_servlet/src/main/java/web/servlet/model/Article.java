package web.servlet.model;

import java.sql.Date;

public class Article {
	int articleNum;
	String category;
	String title;
	String nickName;
	String content;
	String imgFileName;
	Date writeDate;
	int like;
	int hate;
	
	public Article() {}
	
	public Article(int articleNum, String category, String title, String nickName, String content, String imgFileName,
			Date writeDate, int like, int hate) {
		super();
		this.articleNum = articleNum;
		this.category = category;
		this.title = title;
		this.nickName = nickName;
		this.content = content;
		this.imgFileName = imgFileName;
		this.writeDate = writeDate;
		this.like = like;
		this.hate = hate;
	}

	public int getArticleNum() {
		return articleNum;
	}

	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getHate() {
		return hate;
	}

	public void setHate(int hate) {
		this.hate = hate;
	}

	@Override
	public String toString() {
		return "Article [articleNum=" + articleNum + ", category=" + category + ", title=" + title + ", nickName="
				+ nickName + ", content=" + content + ", imgFileName=" + imgFileName + ", writeDate=" + writeDate
				+ ", like=" + like + ", hate=" + hate + "]";
	}
}
