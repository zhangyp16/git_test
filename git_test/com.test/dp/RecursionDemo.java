package dp;

import java.math.BigDecimal;
import java.util.*;

public class RecursionDemo {

    public static void main(String[] args) {
        // System.out.println(fib(4));
        System.out.println(myPow(2, -3));
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

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0){
            return new int[0];
        }
        if (shorter == longer){
            return new int[]{shorter * k};
        }
        int[] len = new int[k + 1];
        for (int i = 0; i <= k; i++){
            len[i] = i * shorter + (k - i) * longer;
        }
        return len;
    }

    private void divingBoard2(int shorter, int longer, int k, List<Integer> list){
        if (k == 0){
            return;
        }
        if (k == 1){

        }
    }


    public List<String> letterCombinations(String digits) {
        String[][] dict = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };
        String[][] digitArr = new String[digits.length()][];
        for (int i = 0; i < digits.length(); i++){
            digitArr[i] = dict[(int)digits.charAt(i) - 2];
        }
        return null;
    }

    public void letterCombinations(String[][] strs, List<String> res, int idx) {
        String[] idxArr = strs[idx];


    }
    // x 的 幂次方  位运算
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }


    public static double myPow3(double x, int n, double[] r) {
        if (r[n] != 0){
            return r[n];
        }
        if (n % 2 == 0){
            r[n] = myPow3(x, n / 2, r) * myPow3(x, n / 2, r);
        } else {
            r[n] = myPow3(x, n / 2, r) * myPow3(x, n / 2, r) * x;
        }
        return r[n];
    }
}
