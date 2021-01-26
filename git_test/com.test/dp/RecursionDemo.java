package dp;

import java.math.BigDecimal;

public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    // leetcode 斐波那契 结果取余
    public static int fib(int n) {
        if (n <= 1){
            return n;
        }
        int y = (int) (Math.pow(10, 9) + 7);
        int k = 0, m = 1, r = 0;
        for (int i = 2; i <= n; i++){
            r = (k + m) % y;
            k = m;
            m = r;
        }
        return r;
    }
}
