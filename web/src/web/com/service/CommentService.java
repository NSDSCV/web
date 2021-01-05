package web.com.service;

import java.util.List;
import java.util.UUID;

import web.com.dao.CommentDao;
import web.com.dao.UserDao;
import web.com.entity.Comment;
/**
 * 评论服务层
 * @author 宗明禄
 *
 */
public class CommentService {
	CommentDao commentDao = new CommentDao();
	UserDao userDao = new UserDao();

	/**
	 * 根据文章id查询
	 * 
	 * @param id
	 * @return list
	 */
	public List<Comment> getCommentByArticleId(String id) {

		List<Comment> list = commentDao.getCommentByArticleId(id);
		
	return list;
	}

/**
 * 添加评论留言
 * @param comment
 * @return true成功
 */
public boolean CommentAdd(Comment comment) {
	comment.setId(UUID.randomUUID().toString());
	return commentDao.CommentAdd(comment)>0;
   
}
}