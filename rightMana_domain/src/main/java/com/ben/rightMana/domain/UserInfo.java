package com.ben.rightMana.domain;

import lombok.Data;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 19:16
 */
@Data
public class UserInfo {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;

    public String getStatusStr() {
        if (status == 1){
            statusStr = "启用";
        }else {
            statusStr = "禁用";
        }
        return statusStr;
    }
}
