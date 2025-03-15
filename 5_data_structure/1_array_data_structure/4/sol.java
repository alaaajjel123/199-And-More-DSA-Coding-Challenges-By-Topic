public class MaxArea {
    public static int maxAreaOptimum(int[] array) {
        int left = 0, right = array.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(array[left], array[right]);
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);

            if (array[left] < array[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 5, 6, 8, 4};
        System.out.println(maxAreaOptimum(arr));
    }
}
