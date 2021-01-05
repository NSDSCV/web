package web.com.dao;
import java.util.List;

import web.com.entity.Article;
import web.com.entity.User;
import web.com.until.MySqlUtil;
import web.com.until.PageData;

/**
 * �������ݴ����
 * @author ����»
 *
 */
public class ArticleDao {
    MySqlUtil<Article> mySqlUtil = new MySqlUtil<Article>();
    /**
     * ��ѯȫ������
     *
     * @return ����list
     */
    public List<Article> getAllArticle() {
        String sql = "SELECT * FROM article";
        List<Article> list = MySqlUtil.exQuery(sql, Article.class, null);
        return list;
    }
    
    /**
     * ��ҳ��ѯ����
     * no1 ��һ  len ����
     * @return ����list
     */
    public List<Article> getAllArticle(int no1,int no2) {
        String sql = "SELECT * FROM article LIMIT ?,?";
      
        List<Article> list = MySqlUtil.exQuery(sql, Article.class,no1,no2);
        return list;
    }
    
    /**
     *  ����ID��ѯ
     * @param id
     * @return list
     */
    public List<Article> getArticleById(String id) {
        String sql = "SELECT * FROM article where artId = ?";
        List<Article> list = MySqlUtil.exQuery(sql, Article.class, id);
        return list;
    }
    
    /**
     * ���
     * @param article
     * @return Ӱ���������
     */
    public int articleAdd(Article article) {
    	String sql = "INSERT INTO article (artId, artName, artText, userId, path) VALUES (?,?,?,?,?)";
        return MySqlUtil.exEdit(sql,article.getArtId(), article.getArtName(), article.getArtText(),article.getUserId(),article.getPath());
		
	}


    /**
     * ����ID�޸�����
     *
     * @param article
     * @return ������Ӱ�����
     */
    public int articleUpdata(Article article) {
        String sql = "UPDATE article SET artName =?, artText=?, userId=? WHERE artId=?";
        return MySqlUtil.exEdit(sql,article.getArtName(), article.getArtText(), article.getUserId(), article.getArtId());
    }
    /**
     * ģ����ѯ
     * @param name
     * @return list
     */
    public List<Article> getAllArticle(String name) {
    	 String sql = "SELECT * FROM article where artName like ?";
         List<Article> list = MySqlUtil.exQuery(sql, Article.class, "%"+name+"%");
         return list;
	}
    /**
     *  ɾ������ID
     * @param id
     * @return int ��Ӱ����
     */
    public int deleteArticle(String id) {
    	String sql = "DELETE FROM article WHERE artId = ?";
    	return MySqlUtil.exEdit(sql,id);
    }
    /**
     * ��ҳģ����ѯ
     *
     * @return ����	PageData<User> ��ֵ����null
     */
    public PageData<Article> getUserAll(String artName, int pageNum, int pageSize){
        String sql = "SELECT * FROM article where artName like ?";
        return mySqlUtil.exQueryByPageData(sql,Article.class,pageNum,pageSize,"%"+artName+"%");
    }
    
    
    /**
     * ����ID�޸�����
     *
     * @param article
     * @return ������Ӱ�����
     */
    public int articleUpdataByTime(String str1,String str2) {
        String sql = "UPDATE article SET createtime = ? WHERE artId=?";
        return MySqlUtil.exEdit(sql,str1,str2);
    }
    
    
    /**
     * ��ҳģ����ѯ ʱ������
     *
     * @return ����	PageData<User> ��ֵ����null
     */
    public PageData<Article> getUserAllByTime(String artName, int pageNum, int pageSize){
        String sql = "SELECT * FROM article where artName like ?";
        return mySqlUtil.exQueryByPageData(sql,Article.class,pageNum,pageSize,"%"+artName+"%");
    }
}
