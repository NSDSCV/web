package web.com.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 用户实体类
 *
 */
public class User {

    private String id;

    private String name;

    private String username;

    private String password;


    private String text;

    
    private String rc;

    public User() {
    }

    public User(String id, String name, String username, String password, String text, String rc) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;

        this.text = text;
        this.rc = rc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, text, rc);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +

                ", text='" + text + '\'' +
                ", rc=" + rc +
                '}';
    }

}
