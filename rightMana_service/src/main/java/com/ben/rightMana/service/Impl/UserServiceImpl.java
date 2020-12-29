package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.UserDao;
import com.ben.rightMana.domain.Role;
import com.ben.rightMana.domain.UserInfo;
import com.ben.rightMana.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:07
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // 引入密码加密类
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.queryByUserName(name);

        // 创建一个 spring-security 提供的 User 对象
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 1 ,true,true,true ,getAuthory(userInfo.getRoles()));

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthory(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return list;
    }

    @Override
    public List<UserInfo> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public void save(UserInfo userInfo) {

        // 对密码进行加密
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

        userDao.save(userInfo);
    }

    @Override
    public UserInfo queryDetailById(Integer userId) {
        return userDao.queryDetailById(userId);
    }
}
