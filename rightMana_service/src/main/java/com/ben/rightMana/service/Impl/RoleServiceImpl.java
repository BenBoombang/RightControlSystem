package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.RoleDao;
import com.ben.rightMana.domain.Permission;
import com.ben.rightMana.domain.Role;
import com.ben.rightMana.service.RoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public Role queryDetailById(Integer roleId) {
        return roleDao.queryDetailById(roleId);
    }

    @Override
    public List<Permission> queryUnaddPermission(Integer roleId) {
        return roleDao.queryUnaddPermission(roleId);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] permissionIds) {
        for (int i = 0;i < permissionIds.length;i++){
            roleDao.addPermissionToRole(roleId,permissionIds[i]);
        }
    }

    @Override
    public List<Role> pageQuery(Map<String, Object> map) {
        int pageno =(Integer) map.get("pageno");
        int pagesize =(Integer) map.get("pagesize");

        String queryText = null;
        if (map.containsKey("queryText")){
            queryText = map.get("queryText").toString();
        }

        PageHelper.startPage(pageno,pagesize);
        return roleDao.pageQuery(queryText);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.updateRole(role);
    }
}
