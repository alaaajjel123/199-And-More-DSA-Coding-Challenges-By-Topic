import java.util.Arrays;

public class RotateArray {
    public static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] rotateArray(int[] array, int k) {
        if (array.length == 0) return array;
        
        k = k % array.length;

        reverse(array, 0, array.length - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, array.length - 1);

        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotateArray(arr, 3)));
    }
}
