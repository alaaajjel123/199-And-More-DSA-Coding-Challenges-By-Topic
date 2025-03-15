public class RadixSort {

    private void countingSort(int[] array, int place) {
        int[] output = new int[array.length];
        int[] temp = new int[10];
        int digitPlace = (int) Math.pow(10, place);

        for (int num : array) {
            int digit = (num / digitPlace) % 10;
            temp[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            temp[i] += temp[i - 1];
        }

        for (int j = array.length - 1; j >= 0; j--) {
            int currDigit = (array[j] / digitPlace) % 10;
            temp[currDigit]--;
            int insertPosition = temp[currDigit];
            output[insertPosition] = array[j];
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }

    public int[] radixSort(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        int greatestNumber = array[0];
        for (int num : array) {
            greatestNumber = Math.max(greatestNumber, num);
        }

        int numberOfDigits = String.valueOf(greatestNumber).length();

        for (int i = 0; i < numberOfDigits; i++) {
            countingSort(array, i);
        }

        return array;
    }

    public static void main(String[] args) {
        RadixSort sorter = new RadixSort();
        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        array = sorter.radixSort(array);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
