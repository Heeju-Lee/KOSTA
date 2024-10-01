package web.servlet.model;


public class Article {
	int articleNum;
	String category;
	String title;
	String nickName;
	String content;
	String imgFileName;
	String writeDate;
	int like;
	int hate;
	
	public static final int DEFAULT_LIKE=0;
	public static final int DEFAULT_HATE=0;
	
	public Article() {}
	
	public Article(int articleNum, String category, String title, String nickName, String content, String imgFileName,
			String writeDate) {
		
		int i = 1;
		
		this.articleNum = i++;
		this.category = category;
		this.title = title;
		this.nickName = nickName;
		this.content = content;
		this.imgFileName = imgFileName;
		this.writeDate = writeDate;
		this.like = DEFAULT_LIKE;
		this.hate = DEFAULT_HATE;
	}
	
	public Article(String category, String title, String nickName, String content, String imgFileName,
			String writeDate) {
		
		int i = 1;
		
		this.articleNum = i++;
		this.category = category;
		this.title = title;
		this.nickName = nickName;
		this.content = content;
		this.imgFileName = imgFileName;
		this.writeDate = writeDate;
		this.like = DEFAULT_LIKE;
		this.hate = DEFAULT_HATE;
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

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
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
