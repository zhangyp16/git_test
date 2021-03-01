import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class MapDemo {
    public static void main(String[] args) {
        mapTree();

        // System.out.println(hammingDistance(1, 4));
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

    /*public int singleNumber(int[] nums) {
        int[] s = new int[2];
        s[0] = 0;
        s[1] = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == s){
                i++;
                s = nums[i];
            }
        }
        return s;
    }*/

    // map 树化 过程
    private static void mapTree(){
        Map<MapKey,String> map = new HashMap<MapKey, String>();
        //第一阶段
        for (int i = 0; i < 6; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第二阶段
        for (int i = 0; i < 10; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第三阶段
        for (int i = 0; i < 50; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第四阶段
        map.put(new MapKey("X"), "B");
        map.put(new MapKey("Y"), "B");
        map.put(new MapKey("Z"), "B");
        System.out.println(map);
    }
    public static class MapKey {

        private static final String REG = "[0-9]+";

        private final String key;

        public MapKey(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MapKey mapKey = (MapKey) o;

            return !(key != null ? !key.equals(mapKey.key) : mapKey.key != null);

        }

        @Override
        public int hashCode() {
            if (key == null)
                return 0;
            Pattern pattern = Pattern.compile(REG);
            if (pattern.matcher(key).matches())
                return 1;
            else
                return 2;
        }

        @Override
        public String toString() {
            return key;
        }
    }
}
