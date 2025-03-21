import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), 0, res);
        return res;
    }

    private static void backtrack(int k, int n, int number, List<Integer> curr, int currSum, List<List<Integer>> res) {
        if (currSum == n && curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > n || curr.size() == k) {
            return;
        }
        for (int x = number; x < 10; x++) {
            curr.add(x);
            backtrack(k, n, x + 1, curr, currSum + x, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3, n = 7;
        List<List<Integer>> result = combinationSum3(k, n);
        System.out.println(result);
    }
}
