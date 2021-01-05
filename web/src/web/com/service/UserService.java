package web.com.service;


import java.util.List;
import java.util.UUID;

import web.com.dao.UserDao;
import web.com.entity.User;
import web.com.until.PageData;

/**
 * ��¼���û�����㣩
 * @author ����»
 *
 */
public class UserService {
    UserDao dao = new UserDao();

    /**
     * ��¼�ж�
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
     * ע���ʺ�
     * @param name
     * @param password
     * @param username 
     * @return �������� true ����ɹ�
     */
    public boolean regUser(String name ,String  username ,String password,String rc){
        boolean fag = false;
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setRc(rc);
        user.setText("�������");
        int a = dao.userAdd(user);
        if (a>0){
            fag = true;
        }
        return fag;
    }
    /**
     * �޸��û���Ϣ
     * @param user
     * @return
     */
    public boolean editUser(User user) {
    	
    	return dao.userUpdata(user) > 0;
	}
    /**
     * ����ID��ѯ�û�
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
     * ��ҳģ����ѯ�û�
     *
     * @return ����	PageData<User> ��ֵ����null
     */
    public PageData<User> getUserAll(String name, int pageNum, int pageSize){
        if (pageNum<1){
            pageNum = 1;
        }

        return dao.getUserAll(name,pageNum,pageSize);
    }
    /**
     * ��ҳģ����ѯ�û�
     *
     * @return ����	PageData<User> ��ֵ����null
     */
    public List<User> getUserAll(){

        return dao.getUserAll();
    }
}
