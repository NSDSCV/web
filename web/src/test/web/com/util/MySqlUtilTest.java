package test.web.com.util;


import org.junit.Test;
import web.com.entity.Article;
import web.com.until.MySqlUtil;
import web.com.until.PageData;

class MySqlUtilTest {

    @Test
    void getConn() {
    }

    @Test
    void exEdit() {
    }

    @Test
    void setParameters() {
    }

    @Test
    void exQuery() {
    }

    @Test
    void exQueryByPageData() {
        Article article = new Article();
        MySqlUtil<Article> mySqlUtil = new MySqlUtil<Article>();
        String sql = "SELECT * FROM article";
        PageData<Article> pageData = mySqlUtil.exQueryByPageData(sql,article.getClass(),1,10,null);
        System.out.println("getPageNum ="+pageData.getPageNum());
        System.out.println("getPageSize ="+pageData.getPageSize());
        System.out.println("getTotalPage ="+pageData.getTotalPage());
        System.out.println("getTotalCount ="+pageData.getTotalCount());

    }

    @Test
    void exQueryPageDataNum() {
    }

    @Test
    void closeAll() {
    }
}