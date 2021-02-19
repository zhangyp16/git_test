package array;

import java.util.*;

public class TopKDemo {

    public static void main(String[] args) {
        // smallestK2(new int[]{1,3,5,7,2,4,6,8}, 4);

        kWeakestRows(new int[][]{
                {1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}}, 3);
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

    //
    public static int[] smallestK2(int[] arr, int k) {
        // 堆排序
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i = 0; i < arr.length; i++){
            if(queue.size() == k){
                if (queue.peek() > arr[i]){
                    // 获取并删除
                    queue.poll();
                    queue.offer(arr[i]);
                }
            } else {
                queue.offer(arr[i]);
            }
        }

        int[] ret = new int[k];
        for (int i = k - 1; i >= 0; i--){
            ret[i] = queue.poll();
        }
        return ret;
    }


    public static int[] kWeakestRows(int[][] mat, int k) {
        int[][] ret = new int[mat.length][2];

        for (int i = 0; i < mat.length; i++){
            int count = 0;
            for (int j = 0; j < mat[i].length; j++){
                count += mat[i][j];
            }
            ret[i][0] = i;
            ret[i][1] = count;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] > o1[1]){
                    return 1;
                }
                if (o2[1] < o1[1]){
                    return -1;
                }
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < mat.length; i++){
            if(queue.size() == k){
                if (queue.peek()[1] > ret[i][1]){
                    // 获取并删除
                    queue.poll();
                    queue.offer(ret[i]);
                }
            } else {
                queue.offer(ret[i]);
            }
        }
        int[] r = new int[k];
        for (int i = k - 1; i >= 0; i--){
            r[i] = queue.poll()[0];
        }
        return r;
    }


}
