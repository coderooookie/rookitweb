package pers.shubin.service.interfaces;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-28 10:59
 * @lastdate:
 */

import pers.shubin.domain.User;

/**
 * Created by hongshubin on 2017/7/28.
 */
public interface UserService {
    public User getUserByName(String username);
    public long insertUser(String username, String pwd);
    public int checkUser(String username,String pwd);
    public int deleteUserByName(String username, String pwd);
}
