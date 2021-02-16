package com.ljj.malllearning.concurrent;

/**
 * AbstractQueuedSynchronizer 抽象队列同步器
 *
 * @author ljj
 * @date 2021/1/15
 */
public class AQSTest {
    public static void main(String[] args) {
        //构建锁和其他同步组件的基础架构 使用int成员变量state表示同步状态 通过内置的FIFO队列来完成线程的排队工作
        //子类通过继承同步器并实现抽象方法来管理同步状态，通过同步器的getState,setState,compareAndSetState方法进行操作
        //同步器支持独占式和共享式获取同步状态  共享式-可以多个线程同时获得同步状态
        //同步器实现的，需要子类自己实现的
        //锁是面向使用者的，同步器面向的是锁的实现者，屏蔽了同步状态管理，线程的排队，等待与唤醒等底层操作。
        //同步器的设计基于模板方法模式 同步器定义了很多final的方法不能被子类重写，
        //非final的protected可被子类重写的：独占式--tryAcquire，tryRelease，共享式--tryAcquireShared，tryReleaseShared
        //同步器提供的final 模板方法-独占式--acquire acquireInterruptibly tryAcquireNanos release    共享式--acquireShared
        //acquireSharedInterruptibly  tryAcquireSharedNanos releaseShared
        //getQueuedThread-获得等待在同步队列上的线程集合
        //AQS应用 CountDownLatch Semaphore ThreadPoolExecutor ReentrantLock ReentrantReadWriteLock 都应用了抽象队列同步器
        //1. 同步队列 2. 独占式同步状态获取与释放  3.共享式同步状态获取与释放 4.超时获取同步状态
        //1. 同步队列 FIFO的双向队列，当前线程获取同步状态失败时 同步器会将当前线程 同步状态
        // 前驱后继节点等信息构造成一个Node节点，并将其加入同步队列，同时会阻塞当前线程，当同步状态释放时，会把首节点中的线程唤醒，使其再次尝试获取同步状态
        //   Node 等待状态waitStatus：cancelled(1)-取消：同步队列中的线程可能等待超时或被中断，需要在同步队列中取消等待  signal(-1)
        //   -后继节点的线程处于等待状态？？当前节点的线程如果释放了同步状态或被取消，将会通知后继节点
        //   condition(-2)-节点在等待队列中(等待队列 同步队列) 节点线程等待在condition上 当其他线程对condition调用了signal方法后，该节点会从等待队列转移到同步队列中
        //   propagate(-3)下一次共享式同步状态获取将会被无条件的传播下去  initial(0)初始状态
        //   prev 前驱节点  next后继节点  nextWaiter等待队列中的后继节点 如果当前节点是共享的 那么这个字段将是一个shared常量？？ thread获取同步状态的线程
        //   节点是构成同步队列、等待队列的基础，同步器拥有首节点和尾节点 compareAndSetTail线程安全的添加节点到尾部
        //   首节点是获取同步状态成功的节点，首节点的线程在释放同步状态时，将会唤醒后继节点，而后继节点将会在获取同步状态成功后将自己设置成首节点。
        //   设置首节点是通过获取同步状态成功的线程来完成的，由于只有一个线程获取同步状态成功，所以设置头节点不需要使用cas，只需要将首节点设置成功原首节点的后继节点，并断开原首节点的next引用和当前首节点的prev
        //   引用即可。
        //2. 独占式同步状态获取与释放(未添加到队列直接获得锁 添加到队列后自旋获得锁或被唤醒获得锁)
        //   acquire 获取同步状态 如果tryAcquire获取同步状态失败则通过addWaiter进入同步队列(该方法对线程中断不敏感？？如果对线程进行中断操作，线程不会从同步队列中移除?)
        //   进入同步队列后，acquireQueued先自旋获取同步状态，如果失败则线程阻塞LockSupport.park，等待前驱节点的唤醒或者阻塞线程中断？？
        //   tryAcquire实现类自己实现  addWaiter：创建节点并通过compareAndSetTail线程安全的放到尾部，当cas失败时，自旋直到cas成功(并发添加到尾部)
        //   (创建node，如果head没初始化则初始化head(一个node节点),tail指向新创建的节点，prev指向前一个节点，前一个节点的next指向当前节点)
        //   acquireQueued被添加到尾部之后 通过自旋来tryAcquire获取同步状态，但是只有前驱节点是head！！的节点才能获取同步状态,如果获取同步状态成功(同步状态已被其他线程释放)
        //   则修改head为当前节点，并把当前节点的thread，prev都置为null(和被初始化的head一样)将原来head节点的next置为null(help GC) 如果线程被打断过
        //   (被打断的线程prev=head且获取锁成功返回状态为被打断过)(不是在阻塞wait状态被打断没有抛出打断异常线程状态不会被清空 此处被打断线程状态为被打断)则selfInterrupt
        //   (原因：1. 头结点是成功获取到同步状态的节点，头结点的线程释放了同步状态之后，将会唤醒其后继节点，后继节点被唤醒后需要检查其前驱节点是否是head节点 2. 维护队列的FIFO原则
        //   防止前驱结点非head节点的线程由于中断被唤醒)。如果获取失败则shouldParkAfterFailedAcquire
        //   (第一次自旋先将waitStatus修改为SIGNAL，第二次自旋线程阻塞LockSupport.park)
        //   head  设置head与拿到锁？？？ 移出队列
        //   release 如果head的waitStatus不为0(初始状态？？) 唤醒head节点的后继节点线程unparkSuccessor(将head的waitStatus改为0，获取head的next
        //   node，如果next node为null或者waitStatus为1被取消？？tail往前推？？)

        //3. 共享式获取同步状态与释放(读和写的关系 读是共享的 写是独占的)  是否支持多线程同时访问同一个资源 由子类自己实现
        //4. 独占式超时获取同步状态

        //tryAcquire 实现类自己定义 尝试获取锁 能获取到则返回并修改锁状态 获取不到则 doAcquire
        //AQS doAcquire 非公平锁：添加node为tail 如果node.pre=head 则再次尝试获取锁  如果获取锁失败 修改Node的状态=-1 循环获取锁 如果第二次还是获取锁失败
        // 则LockSupport.park 线程挂起 当有锁被释放时 被通知
        //如果node.pre!=head直接修改node的状态为-1
        //如果获取锁成功：节点置为null
        //很多并发操作通过CAS实现 修改state 设置 addWait
        //公平锁和非公平锁

        //tryRelease 实现类自己定义
        //AQS doRelease 等待队列竞争锁
    }
}
