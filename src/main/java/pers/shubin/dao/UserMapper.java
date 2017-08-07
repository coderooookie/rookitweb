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
    @Select("SELECT username,created,modified FROM user_info WHERE username = #{username}")
    @Results({
            @Result(property = "username",column = "username"),
            @Result(property = "created",column = "created"),
            @Result(property = "modified",column = "modified"),
    })
    User getUserByName(@Param("username")String username);

    @Delete("DELETE FROM user_info WHERE username = #{name} AND pwd = #{pwd}")
    int deleteUserByName(@Param("name")String name, @Param("pwd")String pwd);

    @Insert("INSERT INTO user_info (username,pwd,created,modified) VALUES (#{username},#{pwd},now(),now())")
    @Results({@Result(property = "id",column = "id")})
    long insertUser(@Param("username")String username, @Param("pwd")String pwd);

    @Select("Select COUNT(*) FROM user_info where username=#{username} AND pwd = #{pwd}")
    int checkUser(@Param("username")String username,  @Param("pwd")String pwd);

    @Select("Select username,created,modified FROM user_info")
    List<User> getAllUsers();
}
