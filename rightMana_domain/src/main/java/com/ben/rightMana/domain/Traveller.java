package com.ben.rightMana.domain;

import lombok.Data;

/**
 * 旅客类
 * @AUTHOR Ben
 * @time 19:56
 */
@Data
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;

}
