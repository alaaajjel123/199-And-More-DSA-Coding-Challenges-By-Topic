import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), 0, res);
        return res;
    }

    private static void combinationSum(int[] candidates, int target, int index, List<Integer> curr, int currSum, List<List<Integer>> res) {
        if (currSum > target) {
            return;
        }
        if (currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = index; j < candidates.length; j++) {
            curr.add(candidates[j]);
            combinationSum(candidates, target, j, curr, currSum + candidates[j], res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum(candidates, target);
        System.out.println(result);
    }
}
