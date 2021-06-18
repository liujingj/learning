package com.ljj.malllearning.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * @author ljj
 * @date 2021/5/14
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Son son = new Son();
        son.setName("son");
        //序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream("/Users/ljj/Desktop/son.text"));
        objectOutputStream.writeObject(son);
        objectOutputStream.close();
        //反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/ljj/Desktop/son.text"));
        Son sonInput = (Son)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("java反序列化输出---" + sonInput.getName());

        //hessian 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(byteArrayOutputStream);
        hessianOutput.writeObject(son);
        hessianOutput.close();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        //hessian反序列化
        HessianInput hessianInput = new HessianInput(new ByteArrayInputStream(bytes));
        Son son1 = (Son)hessianInput.readObject();
        hessianInput.close();
        System.out.println("hessian反序列化输出---" + son1.getName());
    }
}
