import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int[] candidates, int target, int index, int currSum, List<Integer> curr, List<List<Integer>> res) {
        if (currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target || index >= candidates.length) {
            return;
        }
        HashSet<Integer> seen = new HashSet<>();
        for (int j = index; j < candidates.length; j++) {
            if (!seen.contains(candidates[j])) {
                seen.add(candidates[j]);
                curr.add(candidates[j]);
                backtrack(candidates, target, j + 1, currSum + candidates[j], curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }
}
