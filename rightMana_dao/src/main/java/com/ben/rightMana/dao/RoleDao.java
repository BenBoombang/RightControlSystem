package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 21:13
 */
public interface RoleDao {
    @Select("select * from role where id in (select roleId from user_role where userId = #{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ben.rightMana.dao.PermissionDao.queryPermissionByRoleId"))
    })
    List<Role> queryRoleByUserId(String id);

    @Select("select * from role")
    List<Role> queryAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
}
