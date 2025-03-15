public class BubbleSort {

    public int[] bubbleSort(int[] array) {
        boolean sorted = false;
        int counter = 0;
        
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
            counter++;
        }
        return array;
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int[] sortedArray = sorter.bubbleSort(new int[]{1, 2, 3, 4, 0});
        
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
    }
}
