package com.eric.tank;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;


public class PropertyMgr {
    static Properties props=new Properties();

    static{
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String get(String key){
        if(props==null) return null;
        return props.getProperty(key);
    }
}
