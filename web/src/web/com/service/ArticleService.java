package web.com.service;

import java.util.UUID;

import web.com.dao.ArticleDao;
import web.com.entity.Article;
import web.com.entity.User;
import web.com.until.PageData;

public class ArticleService {
ArticleDao dao = new ArticleDao();
	  /**
     * 添加
     * @param article
     * @return 影响对象数量
     */
    public int articleAdd(Article article) {
    	if(article ==null) {
    		return 0;
    	}
    	article.setArtId(UUID.randomUUID().toString());
    return dao.articleAdd(article);
	}

	/**
	 * 分页模糊查询
	 *
	 * @return 返回	PageData<User> 无值返回null
	 */
	public PageData<Article> getUserAll(String artName, int pageNum, int pageSize){

		return dao.getUserAll(artName,pageNum,pageSize);
	}
}
