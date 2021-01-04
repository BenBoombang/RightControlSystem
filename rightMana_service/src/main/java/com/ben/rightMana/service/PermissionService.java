package com.ben.rightMana.service;

import com.ben.rightMana.domain.Permission;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 21:08
 */
public interface PermissionService {

    List<Permission> queryAll();

    void save(Permission permission);

    List<Permission> pageQuery(Map<String, Object> map);

    Permission queryById(Integer permissionId);

    void updatePermission(Permission permission);
}
