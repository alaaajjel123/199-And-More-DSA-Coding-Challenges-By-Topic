import java.util.ArrayList;
import java.util.List;

public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private static void helper(int n, int k, int start, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int j = start; j <= n; j++) {
            curr.add(j);
            helper(n, k, j + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> result = combine(n, k);
        System.out.println(result);
    }
}