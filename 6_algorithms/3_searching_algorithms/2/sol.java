public class RotatedSortedArraySearch {

    public int searchRotatedSortedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int middle = (left + right) / 2;
            
            if (nums[middle] == target) {
                return middle;
            }
            
            if (nums[left] <= nums[middle]) {
                if (target >= nums[left] && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        RotatedSortedArraySearch search = new RotatedSortedArraySearch();
        int[] nums = {7, 8, 1, 2, 3, 4, 5, 6};
        System.out.println(search.searchRotatedSortedArray(nums, 3));
    }
}
