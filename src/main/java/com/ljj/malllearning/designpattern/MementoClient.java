package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class MementoClient {
    public static void main(String[] args) {
        MeOriginator meOriginator = new MeOriginator("高中");
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(meOriginator.saveMemento());

        meOriginator.setStatus("工作没学历优势");

        meOriginator.restoreMemento(caretaker.getMemento());
        System.out.println(meOriginator.getStatus());
    }
}
