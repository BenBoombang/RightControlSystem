package com.ben.rightMana.dao;

import com.ben.rightMana.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 14:50
 */
public interface LogDao {

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method)" +
            " values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void saveLog(SysLog log);

    List<SysLog> pageQuery(@Param("queryText") String queryText);
}
