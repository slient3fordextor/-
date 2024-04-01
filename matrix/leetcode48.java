package matrix;

public class leetcode48 {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int [][] matrix_new = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix_new[j][row - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}
