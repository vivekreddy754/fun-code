import java.util.Arrays;
import java.util.HashMap;

public class TwoSumSorted {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] input = {2, 4, 5, 8, 11, 15};
        int target = 9;
        int[] result = twoSum(input, target);
        System.out.println(Arrays.toString(result));
    }
}
