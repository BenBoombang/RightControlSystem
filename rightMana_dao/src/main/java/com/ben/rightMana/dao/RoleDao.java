package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Permission;
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

    @Select("select * from role where id = #{roleId}")
    Role queryDetailById(Integer roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId + #{roleId})")
    List<Permission> queryUnaddPermission(Integer roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") Integer roleId,@Param("permissionId") Integer permissionId);

    List<Role> pageQuery(@Param("queryText") String queryText);

    @Update("update role set roleName = #{roleName},roleDesc = #{roleDesc} where id = #{id}")
    void updateRole(Role role);
}
