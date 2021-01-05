package web.com.entity;

import java.util.Date;

/**
 * 评论实体
 */
public class Comment {
    private String id ;
    //评论用户Id
    private String userId;
    private String articleId;
    private String text;
    private String creattime;
    public Comment() {
    }


	public Comment(String id, String userId, String articleId, String text, String creattime) {
		super();
		this.id = id;
		this.userId = userId;
		this.articleId = articleId;
		this.text = text;
		this.creattime = creattime;
	}


	public String getCreattime() {
		return creattime;
	}


	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", articleId=" + articleId + ", text=" + text
				+ ", creattime=" + creattime + "]";
	}


    
 
}
