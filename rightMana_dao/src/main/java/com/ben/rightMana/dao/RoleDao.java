package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 21:13
 */
public interface RoleDao {
    @Select("select * from role where id in (select roleId from user_role where userId = #{id})")
    List<Role> queryRoleByUserId(String id);
}
