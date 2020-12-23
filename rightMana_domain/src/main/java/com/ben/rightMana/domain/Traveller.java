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

    public String getCredentialsTypeStr() {
        if (credentialsType == 0){
            credentialsTypeStr = "身份证";
        }else if (credentialsType == 1){
            credentialsTypeStr = "护照";
        }else if (credentialsType == 2){
            credentialsTypeStr = "军官证";
        }

        return credentialsTypeStr;
    }

    public String getTravellerTypeStr() {
        if (travellerType == 0){
            travellerTypeStr = "成人";
        }else if (travellerType == 1){
            travellerTypeStr = "儿童";
        }

        return travellerTypeStr;
    }
}
