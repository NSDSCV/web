package web.com.service;

import java.util.List;
import java.util.UUID;

import web.com.dao.CommentDao;
import web.com.dao.UserDao;
import web.com.entity.Comment;
/**
 * ���۷����
 * @author ����»
 *
 */
public class CommentService {
	CommentDao commentDao = new CommentDao();
	UserDao userDao = new UserDao();

	/**
	 * ��������id��ѯ
	 * 
	 * @param id
	 * @return list
	 */
	public List<Comment> getCommentByArticleId(String id) {

		List<Comment> list = commentDao.getCommentByArticleId(id);
		
	return list;
	}

/**
 * �����������
 * @param comment
 * @return true�ɹ�
 */
public boolean CommentAdd(Comment comment) {
	comment.setId(UUID.randomUUID().toString());
	return commentDao.CommentAdd(comment)>0;
   
}
}