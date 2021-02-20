import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);

        map.put(17, 2);
        map.get(17);
        map.put(33, 3);
        map.put(2, 1);
        map.put(18, 2);
        map.put(34, 3);

        System.out.println(hammingDistance(1, 4));
    }

    // 汉明距离
    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while (n > 0){
            if (1 == n % 2){
                count++;
            }
            n = n / 2;
        }
        return count;
    }
}
