## ThreadLocal的应用
内部实现
    ThreadLocalMap 
线程污染
对应key为何是虚拟引用
    强
    软 --> 内存不够 GC 就会回收
    弱 --> 堆外内存管理 --> queue
    虚 --> GC 就会回收

什么时候会引起内存泄漏
对象头所占用的字节数
压缩指针

volatile关键字原理、指令重排序引发的DCL问题，

## java内存结构
    堆 - GC
        年轻代
           8 eden
           1 survivor + 1 survivor
        老年代
    栈
    本地方法栈
    本地方法区
    程序计数器

## 栈的组成结构  [https://blog.csdn.net/peanutwzk/article/details/107462027]
    栈帧
        局部变量表
        操作数栈
        动态链接
        返回地址

## GC
### GC 算法
        标记清除
        复制
        标记整理

### GC 收集器

### 逃逸分析
 .java 文件 -- javac --> .class 文件 -- JIT --> 机器指令
 
逃逸分析（Escape Analysis）简单来讲就是，Java Hotspot 虚拟机可以分析新创建对象的使用范围，并决定是否在 Java 堆上分配内存的一项技术
    1、全局逃逸（GlobalEscape）
        即一个对象的作用范围逃出了当前方法或者当前线程，有以下几种场景：

        对象是一个静态变量
        对象是一个已经发生逃逸的对象
        对象作为当前方法的返回值
    2、参数逃逸（ArgEscape）
        即一个对象被作为方法参数传递或者被参数引用，但在调用过程中不会发生全局逃逸，这个状态是通过被调方法的字节码确定的

开启逃逸分析：-XX:+DoEscapeAnalysis
关闭逃逸分析：-XX:-DoEscapeAnalysis
显示分析结果：-XX:+PrintEscapeAnalysis

逃逸分析优化 -- 没有逃逸
当一个对象没有逃逸时，可以得到以下几个虚拟机的优化。
1) 锁消除

我们知道线程同步锁是非常牺牲性能的，当编译器确定当前对象只有当前线程使用，那么就会移除该对象的同步锁。
例如，StringBuffer 和 Vector 都是用 synchronized 修饰线程安全的，但大部分情况下，
它们都只是在当前线程中用到，这样编译器就会优化移除掉这些锁操作。

锁消除的 JVM 参数如下：
开启锁消除：-XX:+EliminateLocks
关闭锁消除：-XX:-EliminateLocks
锁消除在 JDK8 中都是默认开启的，并且锁消除都要建立在逃逸分析的基础上。

2) 标量替换

首先要明白标量和聚合量，基础类型和对象的引用可以理解为标量，它们不能被进一步分解。而能被进一步分解的量就是聚合量，比如：对象。

对象是聚合量，它又可以被进一步分解成标量，将其成员变量分解为分散的变量，这就叫做标量替换。

这样，如果一个对象没有发生逃逸，那压根就不用创建它，只会在栈或者寄存器上创建它用到的成员标量，节省了内存空间，也提升了应用程序性能。

标量替换的 JVM 参数如下：
开启标量替换：-XX:+EliminateAllocations
关闭标量替换：-XX:-EliminateAllocations
显示标量替换详情：-XX:+PrintEliminateAllocations
标量替换同样在 JDK8 中都是默认开启的，并且都要建立在逃逸分析的基础上。

3) 栈上分配
当对象没有发生逃逸时，该对象就可以通过标量替换分解成成员标量分配在栈内存中，和方法的生命周期一致，
随着栈帧出栈时销毁，减少了 GC 压力，提高了应用程序性能


## mysql
### mysql事务隔离级

    读未提交
    读已提交
    可重复读
    串行

### MVCC结构 (多版本并发控制)  
  [https://blog.csdn.net/Waves___/article/details/105295060#1.2%E3%80%81Read%20View%20%E7%BB%93%E6%9E%84]

聚簇索引
非聚簇索引的区别

sql优化

springboot自定义插件
springboot启动过程

## redis
redis数据结构

    String
    List --> Queue
    Set
    Zset
    Hash
    
跳跃表数据结构

    skipList
    
分布式锁优化

钩子进程等
