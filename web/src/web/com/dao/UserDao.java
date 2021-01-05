package web.com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import web.com.entity.User;
import web.com.until.MySqlUtil;
import web.com.until.PageData;

/**
 * �û����ݴ����
 */
public class UserDao {
    Connection connection = null;
    PreparedStatement pt = null;
    List<User> list = new ArrayList<>();
    Statement statement = null;

    MySqlUtil<User> mySqlUtil = new MySqlUtil<User>();
    /**
     * �û�ע��ģ��
     * @param user
     * @return �����޸Ĵ��� 0 δ���
     */
    public int userAdd(User user){
        String sql = "INSERT INTO blog_user VALUES(?,?,?,?,?,?)";
        return MySqlUtil.exEdit(sql,user.getId(),user.getName(),user.getUsername(),user.getPassword(),user.getText(),user.getRc());
    }

    /**
     * ��¼��ѯģ��
     * @param user
     * @return ���ض���
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
     *�û��޸���Ϣ
     * @param user
     * @return ����Ӱ������
     */
    public int userUpdata (User user){
        String sql = "UPDATE blog_user SET name = ?,username = ?,password = ?,rc = ?, text = ? WHERE id = ?";
        return MySqlUtil.exEdit(sql,user.getName(),user.getUsername(),user.getPassword(),user.getRc(),user.getText(),user.getId());
    }

    /**
     * ����Id��ѯ�û�
     * @param id
     * @return ����User ��ֵ����null
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
     * ��ѯ�û�
     * 
     * @return ����	List ��ֵ����null
     */
    public List<User> getUserAll(){
        String sql = "SELECT * FROM blog_user";
        List<User> list  = MySqlUtil.exQuery(sql,User.class,null);
        return  list;
    }
    /**
     * ��ҳģ����ѯ�û�
     *
     * @return ����	PageData<User> ��ֵ����null
     */
    public PageData<User> getUserAll(String name,int pageNum,int pageSize){
        String sql = "SELECT * FROM blog_user where name like ?";
        return mySqlUtil.exQueryByPageData(sql,User.class,pageNum,pageSize,"%"+name+"%");
    }

}
