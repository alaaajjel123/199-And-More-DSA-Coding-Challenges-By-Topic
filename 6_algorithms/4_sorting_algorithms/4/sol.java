public class MergeSort {

    public int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {
                mergedArray[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            mergedArray[k++] = array1[i++];
        }

        while (j < array2.length) {
            mergedArray[k++] = array2[j++];
        }

        return mergedArray;
    }

    public int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int middle = array.length / 2;
        int[] leftSide = mergeSort(java.util.Arrays.copyOfRange(array, 0, middle));
        int[] rightSide = mergeSort(java.util.Arrays.copyOfRange(array, middle, array.length));

        return mergeSortedArrays(leftSide, rightSide);
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] sortedArray = sorter.mergeSort(new int[]{5, 4, 3, 2, 1});
        
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}
