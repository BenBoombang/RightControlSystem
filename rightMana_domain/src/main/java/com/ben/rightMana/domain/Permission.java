package com.ben.rightMana.domain;

import lombok.Data;

import java.util.List;

/**
 * @AUTHOR Ben
 * @time 19:22
 */
@Data
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
