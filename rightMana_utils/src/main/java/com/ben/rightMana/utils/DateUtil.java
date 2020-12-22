package com.ben.rightMana.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期与字符串之间的相互转换
 * @AUTHOR Ben
 * @time 20:39
 */
public class DateUtil {

    // 日期转字符串
    public static String DateToString(Date date,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    // 字符串转日期
    public static Date StringToDate(String str,String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;

    }
}
