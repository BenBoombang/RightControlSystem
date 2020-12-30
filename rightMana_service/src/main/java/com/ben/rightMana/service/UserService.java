package com.ben.rightMana.service;

import com.ben.rightMana.domain.Role;
import com.ben.rightMana.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:07
 */
public interface UserService extends UserDetailsService {
    List<UserInfo> queryAll();

    void save(UserInfo userInfo);

    UserInfo queryDetailById(Integer userId);

    List<Role> queryUnaddRole(Integer userId);

    void addRoleToUser(Integer userId, Integer[] roleIds);
}
