public class SelectionSort {

    public int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[smallest]) {
                    smallest = j;
                }
            }
            if (i != smallest) {
                int temp = nums[i];
                nums[i] = nums[smallest];
                nums[smallest] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        int[] sortedArray = sorter.selectionSort(new int[]{5, 4, 3, 2, 1});
        
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}
