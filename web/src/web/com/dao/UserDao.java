package web.com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import web.com.entity.User;
import web.com.until.MySqlUtil;
import web.com.until.PageData;

/**
 * 用户数据处理层
 */
public class UserDao {
    Connection connection = null;
    PreparedStatement pt = null;
    List<User> list = new ArrayList<>();
    Statement statement = null;

    MySqlUtil<User> mySqlUtil = new MySqlUtil<User>();
    /**
     * 用户注册模块
     * @param user
     * @return 返回修改次数 0 未添加
     */
    public int userAdd(User user){
        String sql = "INSERT INTO blog_user VALUES(?,?,?,?,?,?)";
        return MySqlUtil.exEdit(sql,user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getText(),user.getRc());
    }

    /**
     * 登录查询模块
     * @param user
     * @return 返回对象
     */
    public User userLogin(User user){
        String sql = "SELECT * FROM blog_user where username = ? AND password = ? ";
        User user1;
        List<User> list = MySqlUtil.exQuery(sql,user.getClass(),user.getUsername(),user.getPassword());
        if (list.size()==0){
            user1 = null ;
        }else{
            user1 = list.get(0);
        }
        return user1;
    }
    /**
     *用户修改信息
     * @param user
     * @return 返回影响行数
     */
    public int userUpdata (User user){
        String sql = "UPDATE blog_user SET name = ?,username = ?,password = ?,rc = ?, text = ? WHERE id = ?";
        return MySqlUtil.exEdit(sql,user.getName(),user.getUsername(),user.getPassword(),user.getRc(),user.getText(),user.getId());
    }

    /**
     * 根据Id查询用户
     * @param id
     * @return 返回User 无值返回null
     */
    public User getUserById(String id){
        String sql = "SELECT * FROM blog_user where id = ?";
        List<User> list  = MySqlUtil.exQuery(sql,User.class,id);
        if (list.size()==0){
            return null;
        }
        return  list.get(0);
    }

    /**
     * 查询用户
     * 
     * @return 返回	List 无值返回null
     */
    public List<User> getUserAll(){
        String sql = "SELECT * FROM blog_user";
        List<User> list  = MySqlUtil.exQuery(sql,User.class,null);
        return  list;
    }
    /**
     * 分页模糊查询用户
     *
     * @return 返回	PageData<User> 无值返回null
     */
    public PageData<User> getUserAll(String name,int pageNum,int pageSize){
        String sql = "SELECT * FROM blog_user where name like ?";
        return mySqlUtil.exQueryByPageData(sql,User.class,pageNum,pageSize,"%"+name+"%");
    }

}
