package com;

import com.bom.Apply;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhiwei.liu003
 * @date 2020/2/211:50
 */
public class TestReflect01 {


    public static void main (String args[]) throws Exception {
//        MyFK myFK = new MyFK();
//        myFK.setName("1111");
//        myFK.setPassword("2222");
//        test(myFK);

        Apply apply = new Apply();
        test(apply);
    }
    /**
     * 通过反射遍历对象得到对象的值
     * @param myFK
     * @throws Exception
     */
    public static void test(MyFK myFK)throws Exception{
        Field[] field = myFK.getClass().getDeclaredFields();
        for(int i=0;i<field.length;i++){
            //字段名称
            String fieldName = field[i].getName();
            //将属性的首字符大写，方便构造get，set方法
            String methname = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method m = myFK.getClass().getMethod("get" + methname);
            String value = (String)m.invoke(myFK);
            System.out.println(value);
        }
    }

    /**
     * 通过反射遍历对象得到对象的值
     * @param apply
     * @throws Exception
     */
    public static void test(Apply apply)throws Exception{
        Field[] field = apply.getClass().getDeclaredFields();
        for(int i=0;i<field.length;i++){
            //字段名称
            String fieldName = field[i].getName();
            //将属性的首字符大写，方便构造get，set方法
            String methname = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
            Method m = apply.getClass().getMethod("get" + methname);
            String value = (String)m.invoke(apply);
            System.out.println(value);
        }
    }
}
