package com.ben.rightMana.domain;

import lombok.Data;

/**
 * 会员类
 * @AUTHOR Ben
 * @time 19:56
 */
@Data
public class Member {
    private String id;
    private String name;
    private String nickname;
    private String phoneNum;
    private String email;

}
