package com.xyw55.gof.protptype;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Date;

/**
 * Created by xiayiwei on 12/4/16.
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Sheep s1 = new Sheep("duoli", new Date());

//        Sheep s2 = (Sheep) s1.clone();


        //将对象写到流里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        //从流里读出来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep s2 = (Sheep) ois.readObject();


        s1.setBirthday(new Date(1237485739L));

        System.out.println(JSONObject.toJSONString(s1));
        System.out.println(JSONObject.toJSONString(s2));

    }
}
