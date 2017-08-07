package pers.shubin.service.impl;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-28 11:40
 * @lastdate:
 */

import org.springframework.stereotype.Service;
import pers.shubin.dao.UserMapper;
import pers.shubin.domain.User;
import pers.shubin.service.interfaces.UserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by hongshubin on 2017/7/28.
 */
@Service
public class UserServiceimpl implements UserService{
    @Resource
    private UserMapper userMapper;
    public long insertUser(String username, String pwd){
        long id = userMapper.insertUser(username,pwd);
        return id;
    }
    public int deleteUserByName(String username, String pwd){
        int resultNum = userMapper.deleteUserByName(username,pwd);
        return resultNum;
    }

    public User getUserByName(String username){
        User user = userMapper.getUserByName(username);
        return user;
    }

    public int checkUser(String username, String pwd){
        return userMapper.checkUser(username, pwd);
    }

    public List<User> getAllUsers(){
        return userMapper.getAllUsers();
    }
}
