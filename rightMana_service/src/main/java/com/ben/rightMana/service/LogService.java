package com.ben.rightMana.service;

import com.ben.rightMana.domain.SysLog;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR Ben
 * @time 14:49
 */
public interface LogService {

    void saveLog(SysLog log);

    List<SysLog> pageQuery(Map<String, Object> map);
}
