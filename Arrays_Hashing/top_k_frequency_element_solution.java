import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class top_k_frequency_element_solution {
    // min-heap sort
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequent.put(nums[i], frequent.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : frequent.entrySet()) {
            heap.offer(new int[] { entry.getValue(), entry.getKey() });
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }

        return res;
    }

    // bucket sort
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> frequent = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : nums) {
            frequent.put(num, frequent.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> pair : frequent.entrySet()) {
            buckets[pair.getValue()].add(pair.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) {
            for (int n : buckets[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        top_k_frequency_element_solution sol = new top_k_frequency_element_solution();
        int[] testArray = { 1, 2, 2, 3, 3, 3 };

        System.out.println(sol.topKFrequentBucketSort(testArray, 2));
    }
}
