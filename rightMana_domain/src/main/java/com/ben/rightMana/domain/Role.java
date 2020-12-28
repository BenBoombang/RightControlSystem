package com.ben.rightMana.domain;

import lombok.Data;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 19:18
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<UserInfo> users;
}
