package web.com.service;

import java.util.UUID;

import web.com.dao.ArticleDao;
import web.com.entity.Article;
import web.com.entity.User;
import web.com.until.PageData;

public class ArticleService {
ArticleDao dao = new ArticleDao();
	  /**
     * ���
     * @param article
     * @return Ӱ���������
     */
    public int articleAdd(Article article) {
    	if(article ==null) {
    		return 0;
    	}
    	article.setArtId(UUID.randomUUID().toString());
    return dao.articleAdd(article);
	}

	/**
	 * ��ҳģ����ѯ
	 *
	 * @return ����	PageData<User> ��ֵ����null
	 */
	public PageData<Article> getUserAll(String artName, int pageNum, int pageSize){

		return dao.getUserAll(artName,pageNum,pageSize);
	}
}
