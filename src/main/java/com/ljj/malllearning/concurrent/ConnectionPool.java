package com.ljj.malllearning.concurrent;

import java.util.LinkedList;

/**
 * 连接池
 *
 * @author ljj
 * @date 2021/2/1
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initCount) {
        //创建连接池时对连接进行初始化
        if (initCount > 0) {
            for (int i = 0; i < initCount; i++) {
                pool.addLast(ConnectionDriver.createConnction());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.addLast(connection);
                pool.notifyAll();//释放连接需要进行通知 使其他消费者能感知到连接池中已经归还了一个连接
            }
        }
    }

    public Connection getConnection(Long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills == 0) {
                while (pool.isEmpty()) {
                    pool.wait();//一直等待 wait返回后需要循环判断是否有连接
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long delay = mills;
                while (pool.isEmpty() && delay > 0) {
                    //进行超时等待
                    pool.wait(delay);
                    //被唤醒后delay进行修改
                    delay = future - System.currentTimeMillis();
                }
                return pool.isEmpty() ? null : pool.removeFirst();
            }
        }
    }

    public static void main(String[] args) {
        //初始化线程池
        ConnectionPool pool = new ConnectionPool(2);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                Connection connection = null;
                try {
                    connection = pool.getConnection(1000L);
                    Thread.sleep(900);
                } catch (InterruptedException e) {}
                System.out.println("获取到的连接connection=" + connection);
                pool.releaseConnection(connection);
            }).start();
        }
    }

}
