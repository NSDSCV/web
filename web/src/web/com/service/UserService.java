package web.com.service;


import java.util.List;
import java.util.UUID;

import web.com.dao.UserDao;
import web.com.entity.User;
import web.com.until.PageData;

/**
 * 登录（用户服务层）
 * @author 宗明禄
 *
 */
public class UserService {
    UserDao dao = new UserDao();

    /**
     * 登录判断
     * @param username
     * @param password
     * @return user
     */
    public User login(String username,String password){
      
        User user = new User();
            user.setUsername(username);
            user.setPassword(password);
         
        return dao.userLogin(user);
    }

    /**
     * 注册帐号
     * @param name
     * @param password
     * @param username 
     * @return 布尔类型 true 插入成功
     */
    public boolean regUser(String name ,String  username ,String password,String rc){
        boolean fag = false;
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRc(rc);
        user.setText("精神骁伙");
        int a = dao.userAdd(user);
        if (a>0){
            fag = true;
        }
        return fag;
    }
    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public boolean editUser(User user) {
    	
    	return dao.userUpdata(user) > 0;
	}
    /**
     * 根据ID查询用户
     * @param id
     * @return User
     */
    public User getUserById(String id) {
		return dao.getUserById(id);
	}
    public List<User> getUserALL(){
    	return dao.getUserAll();
    }
    /**
     * 分页模糊查询用户
     *
     * @return 返回	PageData<User> 无值返回null
     */
    public PageData<User> getUserAll(String name, int pageNum, int pageSize){
        if (pageNum<1){
            pageNum = 1;
        }

        return dao.getUserAll(name,pageNum,pageSize);
    }
    /**
     * 分页模糊查询用户
     *
     * @return 返回	PageData<User> 无值返回null
     */
    public List<User> getUserAll(){

        return dao.getUserAll();
    }
}
