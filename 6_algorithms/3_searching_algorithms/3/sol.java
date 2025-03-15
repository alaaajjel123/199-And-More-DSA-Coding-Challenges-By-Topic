public class RangeSearch {

    public int findLeftExtreme(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                if (middle == 0 || array[middle - 1] != target) {
                    return middle;
                }
                right = middle - 1;
            } else if (target < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public int findRightExtreme(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                if (middle == array.length - 1 || array[middle + 1] != target) {
                    return middle;
                }
                left = middle + 1;
            } else if (target < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public int[] searchForRangeIterative(int[] array, int target) {
        int leftExtreme = findLeftExtreme(array, target);
        int rightExtreme = findRightExtreme(array, target);
        return new int[] {leftExtreme, rightExtreme};
    }

    public static void main(String[] args) {
        RangeSearch rangeSearch = new RangeSearch();
        int[] result = rangeSearch.searchForRangeIterative(new int[] {1, 1, 2, 2, 2, 3, 4}, 1);
        System.out.println(result[0] + ", " + result[1]);
    }
}
