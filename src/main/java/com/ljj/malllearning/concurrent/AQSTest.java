package com.ljj.malllearning.concurrent;

/**
 * @author ljj
 * @date 2021/1/15
 */
public class AQSTest {
    public static void main(String[] args) {
        //AQS应用 CountDownLatch Semaphore ThreadPoolExecutor ReentrantLock ReentrantReadWriteLock 都应用了抽象队列同步器

        //tryAcquire 实现类自己定义 尝试获取锁 能获取到则返回并修改锁状态 获取不到则 doAcquire
        //AQS doAcquire 非公平锁：添加node为tail 如果node.pre=head 则再次尝试获取锁  如果获取锁失败 修改Node的状态=-1 循环获取锁 如果第二次还是获取锁失败 则LockSupport.park 线程挂起 当有锁被释放时 被通知
        //如果node.pre!=head直接修改node的状态为-1
        //如果获取锁成功：节点置为null
        //很多并发操作通过CAS实现 修改state 设置 addWait
        //公平锁和非公平锁

        //tryRelease 实现类自己定义
        //AQS doRelease 等待队列竞争锁
    }
}
