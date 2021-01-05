package web.com.dao;

import java.util.List;

import web.com.entity.Comment;
import web.com.until.MySqlUtil;
/**
 * ���۷����
 * @author ����»
 *
 */
public class CommentDao {

	/**
	 *  ����ID��ѯ
	 * @param id
	 * @return list
	 */
	public List<Comment> getCommentById(String id) {
		 String sql = "SELECT * FROM blog_comment where id = ?";
	        List<Comment> list = MySqlUtil.exQuery(sql, Comment.class, id);
	        return list;
	}
//	/**
//	 * �����û�id��ѯ
//	 * @param id
//	 * @return list
//	 */
//	public List<Comment> getCommentByUserId(String id) {
//		 String sql = "SELECT * FROM blog_comment where userId = ?";
//	        List<Comment> list = Util.exQuery(sql, Comment.class, id);
//	        return list;
//	}
	/**
	 * ��������id��ѯ
	 * @param id
	 * @return list
	 */
	public List<Comment> getCommentByArticleId(String id) {
		 String sql = "SELECT * FROM blog_comment where articleId = ?";
	        List<Comment> list = MySqlUtil.exQuery(sql,Comment.class, id);
	     
	        return list;
	}
	/**
	 * �����������
	 * @param comment
	 * @return int Ӱ�����
	 */
	public int CommentAdd(Comment comment) {
    	String sql = "INSERT INTO blog_comment VALUES (?,?,?,?,?)";
        return MySqlUtil.exEdit(sql,comment.getId(),comment.getUserId(),comment.getArticleId(),comment.getText(),comment.getCreattime());
		
	}
}
