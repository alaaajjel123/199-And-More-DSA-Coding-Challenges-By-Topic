import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private static void subsets(int[] nums, int index, List<Integer> curr, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        subsets(nums, index + 1, curr, res);
        curr.remove(curr.size() - 1);
        
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        subsets(nums, index + 1, curr, res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }
}