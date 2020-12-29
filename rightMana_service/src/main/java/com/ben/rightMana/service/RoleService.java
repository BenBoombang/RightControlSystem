package com.ben.rightMana.service;

import com.ben.rightMana.domain.Role;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:54
 */
public interface RoleService {
    List<Role> queryAll();

    void save(Role role);
}
