package pers.shubin.dao;
/**
 * @description:
 * @author: hongshubin
 * @requireNo:
 * @createdate: 2017-07-28 14:38
 * @lastdate:
 */

import org.apache.ibatis.annotations.*;
import pers.shubin.domain.User;

import java.util.List;


/**
 * Created by hongshubin on 2017/7/28.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user_tbl WHERE user_name = #{name}")
    @Results({
            @Result(property = "username",column = "user_name"),
            @Result(property = "password",column = "user_password"),
    })
    User getUserByName(@Param("name")String name);
}
