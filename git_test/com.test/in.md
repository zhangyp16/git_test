ThreadLocal的应用、内部实现、线程污染、对应key为何是虚拟引用、

什么时候会引起内存泄漏，对象头所占用的字节数、压缩指针（没答上）、
volatile关键字原理、指令重排序引发的DCL问题，

## java内存结构，
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

## GC、
### GC 算法
        标记清除
        复制
        标记整理

### GC 收集器

逃逸分析（没答上）、

## mysql
### mysql事务隔离级、

    读未提交
    读已提交
    可重复读
    串行

### MVCC结构、

聚簇索引和非聚簇索引的区别、sql优化、

springboot自定义插件、springboot启动过程（没答上）、

redis数据结构、跳跃表数据结构、分布式锁优化、钩子进程等
