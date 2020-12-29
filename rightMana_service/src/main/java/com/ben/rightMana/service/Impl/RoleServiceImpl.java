package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.RoleDao;
import com.ben.rightMana.domain.Role;
import com.ben.rightMana.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 20:55
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> queryAll() {
        return roleDao.queryAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
