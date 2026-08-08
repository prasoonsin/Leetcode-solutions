class Solution {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int row = mat.length;
        int col = mat[0].length;

        if (row * col != r * c) {
            return mat;
        }

        int[][] answer = new int[r][c];

        int newRow = 0;
        int newCol = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                answer[newRow][newCol] = mat[i][j];

                newCol++;

                if (newCol == c) {
                    newRow++;
                    newCol = 0;
                }
            }
        }

        return answer;
    }
}