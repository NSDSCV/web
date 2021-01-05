package test.web.com.dao;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import web.com.dao.ArticleDao;
import web.com.dao.UserDao;
import web.com.entity.Article;
import web.com.entity.User;
import web.com.until.LayuiJson;
import web.com.until.PageData;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/** 
* UserDao Tester. 
* 
* @author <Authors name> 
* @since <pre>12月 29, 2020</pre> 
* @version 1.0 
*/ 
public class UserDaoTest { 

/** 
* 
* Method: userAdd(User user) 
* 
*/ 
@Test
public void testUserAdd() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: userLogin(User user) 
* 
*/ 
@Test
public void testUserLogin() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: userUpdata(User user) 
* 
*/ 
@Test
public void testUserUpdata() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUserById(String id) 
* 
*/ 
@Test
public void testGetUserById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUserAll() 
* 
*/ 
@Test
public void testGetUserAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getUserAll(String name, int pageNum, int pageSize) 
* 
*/ 
@Test
public void testGetUserAllForNamePageNumPageSize() throws Exception {
    UserDao dao = new UserDao();
    String name = "";
    int pageNum = 1;
    int pageSize =10;
    PageData<User> pageData = dao.getUserAll(name,pageNum,pageSize);
    System.out.println("getPageNum ="+pageData.getPageNum());
    System.out.println("getPageSize ="+pageData.getPageSize());
    System.out.println("getTotalPage ="+pageData.getTotalPage());
    System.out.println("getTotalCount ="+pageData.getTotalCount());
    Gson gson = new Gson();
    LayuiJson<User> layuiJson = new LayuiJson<User>();
    layuiJson.setCode(0);
    layuiJson.setCount((long) pageData.getTotalCount());
    layuiJson.setData(pageData.getList());
    layuiJson.setMsg("");
    //使用GSON 把list转化为json格式的string
    String str = gson.toJson(layuiJson);
    System.out.println(str);

}
//    @Test
//    public void adddd() throws Exception {    //添加数据
//        UserDao dao = new UserDao();
//        User u = new User();
//        for (int i = 0; i <1000; i++) {
//            u.setId(UUID.randomUUID().toString());
//            u.setName("马保国"+i);
//            u.setUsername(String.valueOf(i+i));
//            u.setPassword(String.valueOf((i+i)*2));
//            u.setText("芜湖"+i);
//            u.setRc(String.valueOf(0));
//            dao.userAdd(u);
//        }
//
//
//    }

@SuppressWarnings("unused")
private static  Date randomDate(String beginDate,String endDate){
    try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date start = format.parse(beginDate);
        Date end = format.parse(endDate);

        if(start.getTime() >= end.getTime()){
            return null;
        }
        long date = random(start.getTime(),end.getTime());
        return new Date(date);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

private static long random(long begin,long end){
    long rtn = begin + (long)(Math.random() * (end - begin));
    if(rtn == begin || rtn == end){
        return random(begin,end);
    }
    return rtn;
}


@Test
public void testTime(){
	ArticleDao dao = new ArticleDao();
	String str1 = "";
	String str2 = null;
	List<Article> list = dao.getAllArticle();
	for (Article article : list) {
		str2 = article.getArtId();
		 Date date = randomDate("2010-01-01","2020-10-30");
         str1 = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
         System.out.println("date:"+str1+"id:"+str2);
         dao.articleUpdataByTime(str1,str2);
	}
        
           
        
    
	
} 


} 
