import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), output);
        return output;
    }

    private static void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> output) {
        if (i == nums.length) {
            output.add(new ArrayList<>(subset));
            return;
        }
        helper(nums, i + 1, subset, output);
        subset.add(nums[i]);
        helper(nums, i + 1, subset, output);
        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = powerSet(nums);
        System.out.println(result);
    }
}
