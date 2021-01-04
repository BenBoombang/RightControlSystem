package com.ben.rightMana.domain;

import lombok.Data;

import java.util.Date;

/**
 * AOP日志类
 * @AUTHOR Ben
 * @time 14:07
 */
@Data
public class SysLog {
    private Integer id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;
}
