public class QuickSort {

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int partition(int[] array, int start, int end) {
        int middle = (start + end) / 2;
        swap(array, start, middle);
        
        int pivot = array[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= j && array[i] <= pivot) {
                i++;
            }
            while (i <= j && array[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }

        swap(array, start, j);
        return j;
    }

    public void quickSort(int[] array, int start, int end) {
        if (end == -1) {
            end = array.length - 1;
        }

        while (start < end) {
            int pivotIdx = partition(array, start, end);

            if (pivotIdx - start < end - pivotIdx) {
                quickSort(array, start, pivotIdx - 1);
                start = pivotIdx + 1;
            } else {
                quickSort(array, pivotIdx + 1, end);
                end = pivotIdx - 1;
            }
        }
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] array = {5, 4, 3, 2, 1};
        sorter.quickSort(array, 0, -1);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
