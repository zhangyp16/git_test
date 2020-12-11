package ali;

import java.util.Map;

public class AliTest {
    public static void main(String[] args) {
        String s1 = "qwqeq";
        // System.out.println(s1.substring(1, 2));
        System.out.println(maxSubStr(s1));
    }

    private static int maxSubStr(String s1){
        int max = 0;
        for (int i = 0; i < s1.length(); i++){
            for (int j = i + 1; j < s1.length(); j++){
                if (s1.substring(i, j).contains(s1.substring(j, j + 1))){
                    max = Math.max(j - i, max);
                    break;
                }
                max = Math.max(j - i, max);
            }
        }
        return max;
    }

    //评测题目:
    //1. 给定一个字符串，输出不含有重复字符的最长子串的长度。
    //例如： 输入: "abcabcbb"  输出: 3； 输入："aaaaa" 输出：1

    //2、评测题目:java策略模式的实现
    //场景：为实现校验，需要生成一个8位长度的token，有随机策略、时间戳策略两种


    //3､共计9个香蕉，有2只猴子，一个猴子每次拿2个香蕉，一个猴子每次拿3个香蕉，
    //如果剩余的香蕉不够猴子每次拿的数量，则2只猴子停止拿香蕉，
    //请用java多线程模拟上面的描述并打印出过程

}
