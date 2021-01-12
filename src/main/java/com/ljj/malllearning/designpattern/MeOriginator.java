package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/12
 */
public class MeOriginator {

    public String status;

    public MeOriginator(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //存档
    public Memento saveMemento() {
        return new Memento(this.status);
    }

    //恢复存档
    public void restoreMemento(Memento memento) {
        this.status = memento.status;
    }
}
