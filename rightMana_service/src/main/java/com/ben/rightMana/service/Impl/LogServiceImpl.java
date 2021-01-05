package com.ben.rightMana.service.Impl;

import com.ben.rightMana.dao.LogDao;
import com.ben.rightMana.domain.SysLog;
import com.ben.rightMana.service.LogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<SysLog> pageQuery(Map<String, Object> map) {
        int pageno = Integer.valueOf(map.get("pageno").toString()) ;
        int pagesize = Integer.valueOf(map.get("pagesize").toString()) ;
        String queryText = null;
        if (map.containsKey("queryText")){
            queryText = map.get("queryText").toString();
        }

        PageHelper.startPage(pageno,pagesize);
        return logDao.pageQuery(queryText);
    }
}
