package com.util;


import com.constant.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    //创建properties
    private static Properties prop=new Properties();
    //创建静态代码块用于导入
    static {
        try {
            InputStream inStream = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建获取properties文件的方法String类型
    public static String getProperties(String key){
        return prop.getProperty(key);
    }
    //返回boolean型
    public static Boolean getBooleanProperties(String key){
        boolean b=false;
        String prop= getProperties(key);
        try {
         b = Boolean.parseBoolean(prop);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return b;
        }
    }



    public static void main(String[] args) {
        System.out.println(getBooleanProperties(Constants.IS_LOCAL));
    }
}
