package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.UserDao;
import com.ben.rightMana.domain.Role;
import com.ben.rightMana.domain.UserInfo;
import com.ben.rightMana.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 20:07
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private HttpServletRequest request;

    // 引入密码加密类
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.queryByUserName(name);

        // 创建一个 spring-security 提供的 User 对象
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 1 ,true,true,true ,getAuthory(userInfo.getRoles()));
        HttpSession session = request.getSession();
        session.setAttribute("username",user.getUsername());
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthory(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
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

    @Override
    public List<Role> queryUnaddRole(Integer userId) {
        return userDao.queryUnaddRole(userId);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) {

        for (int i = 0;i < roleIds.length;i++){
            userDao.addRoleToUser(userId,roleIds[i]);
        }
    }

    @Override
    public List<UserInfo> pageQuery(Map<String, Object> map) {
        int pageno = (Integer) map.get("pageno");
        int pagesize = (Integer) map.get("pagesize");
        String queryText = null;
        if (map.containsKey("queryText")){
            queryText = map.get("queryText").toString();
        }

        PageHelper.startPage(pageno,pagesize);
        return userDao.pageQuery(queryText);
    }

    @Override
    public void openStatus(Map<String, Object> map) {
        userDao.openStatus(map);
    }

    @Override
    public void closeStatus(Map<String, Object> map) {
        userDao.closeStatus(map);
    }

    @Override
    public List<UserInfo> exportQuery(Map<String, Object> map) {
        return userDao.exportQuery(map);
    }
}
