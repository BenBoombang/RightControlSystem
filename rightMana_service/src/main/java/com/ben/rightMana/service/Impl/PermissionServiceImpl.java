package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.PermissionDao;
import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 21:08
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> queryAll() {
        return permissionDao.queryAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
