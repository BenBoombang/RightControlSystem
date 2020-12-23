package com.ben.rightMana.dao;

import com.ben.rightMana.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @AUTHOR Ben
 * @time 21:36
 */
public interface MemberDao {

    @Select("select * from member where id = #{id}")
    Member queryById(String id);
}
