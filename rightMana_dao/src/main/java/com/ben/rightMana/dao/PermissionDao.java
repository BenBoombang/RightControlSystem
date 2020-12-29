package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 19:50
 */
public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> queryPermissionByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> queryAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
