package com.xyw55.gof.protptype;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.*;
import java.util.Date;

/**
 * Created by xiayiwei on 12/4/16.
 */
public class Sheep implements Cloneable, Serializable{
    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
//        return obj;

        // 深克隆增加代码
        Sheep s = (Sheep) obj;
        // 对属性实现Cloneable接口的进行clone
        s.setBirthday((Date) birthday.clone());
        return s;
    }

    // 序列化实现深克隆
    public Sheep deepClone() throws IOException, ClassNotFoundException {
        //将对象写到流里
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //从流里读出来
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return  (Sheep) ois.readObject();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
