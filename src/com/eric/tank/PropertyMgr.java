package com.eric.tank;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

//TODO: 改为单例模式 在内存中，如果需要某个类的对象，在程序上保证有且只有一个该类的对象
public class PropertyMgr {
    static Properties props=new Properties();

    static{
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if(props==null) return null;
        return props.get(key);
    }
    @Test
    public void test(){
        System.out.println(props.get("initTankCount"));
    }
}
