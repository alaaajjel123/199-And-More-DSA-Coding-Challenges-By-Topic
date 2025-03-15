public class MatrixSearch {

    public boolean searchInMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        while (top <= bottom) {
            int middle = (top + bottom) / 2;
            if (target < matrix[middle][0]) {
                bottom = middle - 1;
            } else if (target > matrix[middle][columns - 1]) {
                top = middle + 1;
            } else {
                break;
            }
        }

        if (top > bottom) {
            return false;
        }

        int middle = (top + bottom) / 2;
        int left = 0;
        int right = columns - 1;

        while (left <= right) {
            int middleVal = (left + right) / 2;
            if (target == matrix[middle][middleVal]) {
                return true;
            } else if (target < matrix[middle][middleVal]) {
                right = middleVal - 1;
            } else {
                left = middleVal + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MatrixSearch search = new MatrixSearch();
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };
        System.out.println(search.searchInMatrix(matrix, 5));  // Output: true
        System.out.println(search.searchInMatrix(matrix, 20)); // Output: false
    }
}
