package niuke;

public class Xiechen {

    public static void main(String[] args) {
        System.out.println(sqrt4(1518991037));
        System.out.println(Math.sqrt(1518991037));
        // System.out.println(sqrt2(6));

        // System.out.println(sqrt3(1518991037));
    }

    public static int sqrt2 (int x) {
        // write code here
        for (int i = (x % 2 == 0 ? x / 2 : (x / 2) + 1); i >= 1; i--){
            if (i <= (x / i)){
                return i;
            }
        }
        return 0;
    }

    public static int sqrt3 (int x) {
        // write code here
        int start = 1, end = x;
        int mid = start + (end - start) / 2;
        while (start < end){
            if (mid == (x / mid)){
                return mid;
            } else if (mid > (x / mid)){
                end = mid;
            } else {
                start = mid;
            }
            mid = start + (end - start) / 2;
        }
        return start;
    }

    // //牛顿法思路
    public static int sqrt4 (int x) {
        // write code here
        if (x == 0 || x == 1){
            return x;
        }
        int r = x;
        while (x / r < r){
            r = (r + x / r) / 2;
        }
        return r;
    }
}
