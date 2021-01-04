package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Role;
import com.ben.rightMana.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ben.rightMana.dao.RoleDao.queryRoleByUserId"))
    })
    UserInfo queryDetailById(@Param("userId") Integer userId);

    @Select("select * from role where id not in (select roleId from user_role where userId = #{userId})")
    List<Role> queryUnaddRole(Integer userId);

    @Insert("insert into user_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    List<UserInfo> pageQuery(@Param("queryText") String queryText);

    void openStatus(Map<String, Object> map);

    void closeStatus(Map<String, Object> map);

    List<UserInfo> exportQuery(Map<String, Object> map);
}
