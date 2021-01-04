package com.ben.rightMana.service;

import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.domain.Role;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 20:54
 */
public interface RoleService {
    List<Role> queryAll();

    void save(Role role);

    Role queryDetailById(Integer roleId);

    List<Permission> queryUnaddPermission(Integer roleId);

    void addPermissionToRole(Integer roleId, Integer[] permissionIds);

    List<Role> pageQuery(Map<String, Object> map);

    void updateRole(Role role);
}
