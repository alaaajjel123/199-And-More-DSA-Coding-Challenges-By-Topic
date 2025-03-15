public class BinarySearch {

    public int binarySearchRecursive(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    private int helper(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return helper(nums, target, middle + 1, right);
        } else {
            return helper(nums, target, left, middle - 1);
        }
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {2, 3, 7, 9, 11, 23, 37, 81, 87, 89};
        System.out.println(bs.binarySearchRecursive(nums, 9));
    }
}
