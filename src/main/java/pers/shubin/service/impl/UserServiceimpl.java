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

/**
 * Created by hongshubin on 2017/7/28.
 */
@Service
public class UserServiceimpl implements UserService{
    @Resource
    private UserMapper userMapper;
    public boolean addUser(String username, String password){
        return false;
    }
    public User getUserByName(String name){
        return userMapper.getUserByName(name);
    }
    public boolean findUser(String username, String password){
        return false;
    }
}
