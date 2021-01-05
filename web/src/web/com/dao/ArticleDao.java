package web.com.dao;
import java.util.List;

import web.com.entity.Article;
import web.com.entity.User;
import web.com.until.MySqlUtil;
import web.com.until.PageData;

/**
 * 文章数据处理层
 * @author 宗明禄
 *
 */
public class ArticleDao {
    MySqlUtil<Article> mySqlUtil = new MySqlUtil<Article>();
    /**
     * 查询全部文章
     *
     * @return 返回list
     */
    public List<Article> getAllArticle() {
        String sql = "SELECT * FROM article";
        List<Article> list = MySqlUtil.exQuery(sql, Article.class, null);
        return list;
    }
    
    /**
     * 分页查询文章
     * no1 第一  len 长度
     * @return 返回list
     */
    public List<Article> getAllArticle(int no1,int no2) {
        String sql = "SELECT * FROM article LIMIT ?,?";
      
        List<Article> list = MySqlUtil.exQuery(sql, Article.class,no1,no2);
        return list;
    }
    
    /**
     *  根据ID查询
     * @param id
     * @return list
     */
    public List<Article> getArticleById(String id) {
        String sql = "SELECT * FROM article where artId = ?";
        List<Article> list = MySqlUtil.exQuery(sql, Article.class, id);
        return list;
    }
    
    /**
     * 添加
     * @param article
     * @return 影响对象数量
     */
    public int articleAdd(Article article) {
    	String sql = "INSERT INTO article (artId, artName, artText, userId, path) VALUES (?,?,?,?,?)";
        return MySqlUtil.exEdit(sql,article.getArtId(), article.getArtName(), article.getArtText(),article.getUserId(),article.getPath());
		
	}


    /**
     * 根据ID修改文章
     *
     * @param article
     * @return 返回受影响个数
     */
    public int articleUpdata(Article article) {
        String sql = "UPDATE article SET artName =?, artText=?, userId=? WHERE artId=?";
        return MySqlUtil.exEdit(sql,article.getArtName(), article.getArtText(), article.getUserId(), article.getArtId());
    }
    /**
     * 模糊查询
     * @param name
     * @return list
     */
    public List<Article> getAllArticle(String name) {
    	 String sql = "SELECT * FROM article where artName like ?";
         List<Article> list = MySqlUtil.exQuery(sql, Article.class, "%"+name+"%");
         return list;
	}
    /**
     *  删除根据ID
     * @param id
     * @return int 受影响行
     */
    public int deleteArticle(String id) {
    	String sql = "DELETE FROM article WHERE artId = ?";
    	return MySqlUtil.exEdit(sql,id);
    }
    /**
     * 分页模糊查询
     *
     * @return 返回	PageData<User> 无值返回null
     */
    public PageData<Article> getUserAll(String artName, int pageNum, int pageSize){
        String sql = "SELECT * FROM article where artName like ?";
        return mySqlUtil.exQueryByPageData(sql,Article.class,pageNum,pageSize,"%"+artName+"%");
    }
    
    
    /**
     * 根据ID修改文章
     *
     * @param article
     * @return 返回受影响个数
     */
    public int articleUpdataByTime(String str1,String str2) {
        String sql = "UPDATE article SET createtime = ? WHERE artId=?";
        return MySqlUtil.exEdit(sql,str1,str2);
    }
    
    
    /**
     * 分页模糊查询 时间区间
     *
     * @return 返回	PageData<User> 无值返回null
     */
    public PageData<Article> getUserAllByTime(String artName, int pageNum, int pageSize){
        String sql = "SELECT * FROM article where artName like ?";
        return mySqlUtil.exQueryByPageData(sql,Article.class,pageNum,pageSize,"%"+artName+"%");
    }
}
