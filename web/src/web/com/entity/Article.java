package web.com.entity;

import web.com.dao.UserDao;

public class Article {
	private String artId;
    private String artName;
    private String artText;
    //×÷ÕßId
    private String userId;

	private String path;
	
	private String createtime;
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return user.getUsername();
	}

	public void setUsername(String username) {
		user.setUsername(username);
	}



 public Article() {
	// TODO Auto-generated constructor stub
}


	public String getArtId() {
	return artId;
}

public void setArtId(String artId) {
	this.artId = artId;
}

public String getArtName() {
	return artName;
}

public void setArtName(String artName) {
	this.artName = artName;
}

public String getArtText() {
	return artText;
}

public void setArtText(String artText) {
	this.artText = artText;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}


@Override
public String toString() {
	return "Article [artId=" + artId + ", artName=" + artName + ", artText=" + artText + ", userId=" + userId
			 + "]";
}



public Article(String artName, String artText, String userId,String path) {
	super();
	this.artName = artName;
	this.artText = artText;
	this.userId = userId;
	this.path = path;
}

	public Article(String artId, String artName, String artText, String userId, String path, User user) {
		this.artId = artId;
		this.artName = artName;
		this.artText = artText;
		this.userId = userId;
		this.path = path;
		this.user = user;
	}
}
