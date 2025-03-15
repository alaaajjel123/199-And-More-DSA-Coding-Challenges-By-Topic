public class InsertionSort {

    public int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
        int[] sortedArray = sorter.insertionSort(new int[]{5, 4, 3, 2, 1});
        
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}
