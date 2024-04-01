package matrix;

public class leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        int x = 0, y = column - 1;
        while (x < row && y >= 0){
            if(matrix[x][y] == target) return true;
            if(matrix[x][y] > target) --y;
            else ++x;
        }
        return false;
    }
}
