package com.ben.rightMana.dao;

import com.ben.rightMana.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:13
 */
public interface UserDao {

    @Select("select * from users where username = #{name}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ben.rightMana.dao.RoleDao.queryRoleByUserId"))
    })
    UserInfo queryByUserName(@Param("name") String name);

    @Select("select * from users")
    List<UserInfo> queryAll();

}
