import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permutations(nums, 0, res);
        return res;
    }

    private static void permutations(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            res.add(current);
            return;
        }
        HashSet<Integer> hash = new HashSet<>();
        for (int j = index; j < nums.length; j++) {
            if (!hash.contains(nums[j])) {
                hash.add(nums[j]);
                swap(nums, index, j);
                permutations(nums, index + 1, res);
                swap(nums, index, j);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }
}