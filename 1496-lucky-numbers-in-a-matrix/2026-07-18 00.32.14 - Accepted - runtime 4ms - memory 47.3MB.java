class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i =0; i<rows; i++){
            for (int j =0; j<cols; j++) {
                boolean isRowMinimum = true;
                for (int k =0; k<cols; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        isRowMinimum = false;
                        break;
                    }
                }
                boolean isColumnMaximum = true;
                for (int k =0; k<rows; k++) {
                    if (matrix[k][j] >matrix[i][j]) {
                        isColumnMaximum = false;
                        break;
                    }
                }
                if (isRowMinimum && isColumnMaximum) {
                    answer.add(matrix[i][j]);
                }
            }
        }
        return answer;
    }
}