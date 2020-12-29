package com.ben.rightMana.service;

import com.ben.rightMana.domain.Permission;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 21:08
 */
public interface PermissionService {

    List<Permission> queryAll();

    void save(Permission permission);
}
