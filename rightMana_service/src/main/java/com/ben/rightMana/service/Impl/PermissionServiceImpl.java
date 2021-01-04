package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.PermissionDao;
import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.service.PermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Permission> pageQuery(Map<String, Object> map) {
        int pageno = (Integer) map.get("pageno");
        int pagesize = (Integer) map.get("pagesize");

        String queryText = null;
        if (map.containsKey("queryText")){
            queryText = map.get("queryText").toString();
        }

        PageHelper.startPage(pageno,pagesize);
        return permissionDao.pageQuery(queryText);
    }

    @Override
    public Permission queryById(Integer permissionId) {
        return permissionDao.queryById(permissionId);
    }

    @Override
    public void updatePermission(Permission permission) {
        permissionDao.updatePermission(permission);
    }
}
