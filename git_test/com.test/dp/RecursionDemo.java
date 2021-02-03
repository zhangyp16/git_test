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
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
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
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
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

    /**
     * 0
     * 0 1
     * 01 10
     * 0110 1001
     * 01101001 10010110
     * 01101001 10010110 10010110
     */
    public int kthGrammar(int N, int K) {
        StringBuffer sb = new StringBuffer();
        sb.append("0");
        double len = Math.pow(2, N - 1);
        double idx = len - K;
        while(N > 1){

            N--;
        }
        return sb.toString().charAt((int) idx);
    }
}
