package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.LogDao;
import com.ben.rightMana.domain.SysLog;
import com.ben.rightMana.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @AUTHOR Ben
 * @time 14:49
 */
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void saveLog(SysLog log) {
        logDao.saveLog(log);
    }
}
