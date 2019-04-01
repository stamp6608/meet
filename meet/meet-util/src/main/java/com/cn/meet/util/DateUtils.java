package com.cn.meet.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: meet
 * @description: 时间工具类
 * @author: Stamp.M
 * @create: 2019-03-23 20:58
 **/
public class DateUtils {

    /** 
    * @Description: 获取精确到秒的时间戳
    * @Param: [date] 
    * @return: int 
    * @Author: Stamp.M 
    * @Date: 2019/3/23 
    */ 
    public static int getSecondTimestamp(Date date){
        if(null == date) return 0;
        String timestamp = String.valueOf(date.getTime()/1000);
        return Integer.valueOf(timestamp);
    }

    public static String getNowDateStr(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return  df.format(new Date().getTime());
    }

}
