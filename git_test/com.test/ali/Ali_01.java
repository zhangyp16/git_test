package ali;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ali_01 {

    public static void main(String[] args) {
        // thread_print();
        area_print();
    }
    /**
     * 【问题1】使用4个线程交替打印：“阿”，“里”，“巴”，“巴！”，
     * 每打印一个汉字，计数器加1，每4个字一行，当打印102个汉字时，程序结束。
     */
    public static void thread_print(){
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        Condition c4 = lock.newCondition();
        AtomicInteger ai = new AtomicInteger();

        new Thread(() -> {
            try {
                lock.lock();
                while (ai.get() < 102){
                    System.out.print("阿");
                    ai.incrementAndGet();
                    c2.signal();
                    c1.await();
                }
            } catch (Exception e){

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (ai.get() < 102){
                    System.out.print("里");
                    ai.incrementAndGet();
                    c3.signal();
                    c2.await();
                }
            } catch (Exception e){

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (ai.get() < 102){
                    System.out.print("巴");
                    ai.incrementAndGet();
                    c4.signal();
                    c3.await();
                }
                c4.signalAll();
            } catch (Exception e){

            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (ai.get() < 102){
                    System.out.println("巴");
                    ai.incrementAndGet();
                    c1.signal();
                    c4.await();
                }
            } catch (Exception e){

            } finally {
                lock.unlock();
            }
        }).start();
    }

    /**
     * 【问题2】
     * 已知一个文本文件中存储着中国省市县（区）的关系对，顺序无规律，如：
     *
     * 196:廊坊市-199:固安县
     * 222:上海市-227:普陀区
     * 464:济南市-469:历城区
     * 360:浙江省-361:杭州市
     * 616:滨州市-619:惠民县
     * 361:杭州市-369:余杭区
     * 443:台州市-451:临海市
     * 222:上海市-230:闵行区
     * 116:保定市-126:高阳县
     *
     * https://github.com/craney/area/blob/master/area.txt
     * 即：一级-二级 或 二级-三级 关系对，直辖市只有两级关系，一般省三级关系，区可能重名。
     *
     *
     * 读取文件生成一个以“中国”为根节点的树型对象，体现这些关系并打印如下，每层顺序按照编号升序排列。
     * -1:中国
     *   -2:北京市
     *     -3:东城区
     *     -4:西城区
     *     -5:朝阳区
     *     -6:丰台区
     *     -7:石景山区
     *     -100:xxx
     *   -19:河北省
     *     -20:石家庄市
     *       -21:长安区
     *       -22:桥西区
     *       -23:新华区
     *       -24:井陉矿区
     *       -25:裕华区
     *       -26:藁城区
     *       -27:鹿泉区
     *       -28:栾城区
     */

    public static void area_print(){
        List<String> areaList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("git_test/com.test/ali/area.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                String[] atrArr = str.split("-");
            }
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class AreaNode {
        AreaNode parent;
        List<AreaNode> childList;

        public AreaNode(AreaNode parent, List<AreaNode> childList) {
            this.parent = parent;
            this.childList = childList;
        }

        public AreaNode getParent() {
            return parent;
        }

        public void setParent(AreaNode parent) {
            this.parent = parent;
        }

        public List<AreaNode> getChildList() {
            return childList;
        }

        public void setChildList(List<AreaNode> childList) {
            this.childList = childList;
        }
    }



}
