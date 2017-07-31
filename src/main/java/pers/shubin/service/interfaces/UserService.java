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
    public User getUserByName(String name);
    public long insertUser(String username, String password);
    public boolean findUser(String username, String password);
    public int deleteUserByName(String username, String password);
}
