package array;

import java.math.BigDecimal;
import java.util.*;

/**
 * 排序
 */
public class SortDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        System.out.println(intersection(new int[]{1,2,2,1},
new int[]{2,2}));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            map.putIfAbsent(value, 0);
        }
        int count = 0;
        for (int i : nums2) {
            if (map.get(i) == null){
                continue;
            }
            if (map.get(i) == 0){
                count++;
            }
            map.put(i, map.get(i) + 1);

        }
        int[] ret = new int[count];
        int m = 0;
        for (int k : map.keySet()){
            if (map.get(k) > 0){
                ret[m++] = map.get(k);
            }
        }
        return ret;
    }

    // 1491. 去掉最低工资和最高工资后的工资平均值
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count = 0;
        for (int i = 0; i < salary.length; i++){
            count += salary[i];
            max = Math.max(salary[i], max);
            min = Math.min(salary[i], min);
        }
        return new BigDecimal(count - max - min)
                .divide(new BigDecimal(salary.length - 2), 5, 5).doubleValue();
    }

    // 1710. 卡车上的最大单元数
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        for (int i = 0; i < boxTypes.length - 1; i++){
            for (int j = i + 1; j < boxTypes.length; j++){
                if (boxTypes[i][1] < boxTypes[j][1]){
                    int[] tmp = boxTypes[i];
                    boxTypes[i] = boxTypes[j];
                    boxTypes[j] = tmp;
                }
            }
        }
        /*Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });*/

        int max = 0;
        for (int i = 0; i < boxTypes.length; i++){
            if (boxTypes[i][0] > truckSize){
                max += truckSize * boxTypes[i][1];
                break;
            } else {
                truckSize -= boxTypes[i][0];
                max += boxTypes[i][0] * boxTypes[i][1];
            }
        }
        return max;
    }
}
