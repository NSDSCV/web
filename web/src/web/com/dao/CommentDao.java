package web.com.dao;

import java.util.List;

import web.com.entity.Comment;
import web.com.until.MySqlUtil;
/**
 * 评论服务层
 * @author 宗明禄
 *
 */
public class CommentDao {

	/**
	 *  根据ID查询
	 * @param id
	 * @return list
	 */
	public List<Comment> getCommentById(String id) {
		 String sql = "SELECT * FROM blog_comment where id = ?";
	        List<Comment> list = MySqlUtil.exQuery(sql, Comment.class, id);
	        return list;
	}
//	/**
//	 * 根据用户id查询
//	 * @param id
//	 * @return list
//	 */
//	public List<Comment> getCommentByUserId(String id) {
//		 String sql = "SELECT * FROM blog_comment where userId = ?";
//	        List<Comment> list = Util.exQuery(sql, Comment.class, id);
//	        return list;
//	}
	/**
	 * 根据文章id查询
	 * @param id
	 * @return list
	 */
	public List<Comment> getCommentByArticleId(String id) {
		 String sql = "SELECT * FROM blog_comment where articleId = ?";
	        List<Comment> list = MySqlUtil.exQuery(sql,Comment.class, id);
	     
	        return list;
	}
	/**
	 * 添加评论留言
	 * @param comment
	 * @return int 影响个数
	 */
	public int CommentAdd(Comment comment) {
    	String sql = "INSERT INTO blog_comment VALUES (?,?,?,?,?)";
        return MySqlUtil.exEdit(sql,comment.getId(),comment.getUserId(),comment.getArticleId(),comment.getText(),comment.getCreattime());
		
	}
}
