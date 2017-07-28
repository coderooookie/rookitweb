package pers.shubin.domain;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-28 10:56
 * @lastdate:
 */

/**
 * Created by hongshubin on 2017/7/28.
 */
public class User {
   private String username;
   private String password;

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

    public String toString(){
        return String.format("{\"username\":\"%s\",\"password\":\"%s\"}",username,password);
    }
}
