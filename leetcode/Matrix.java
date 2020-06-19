class Matrix {

    public static class RecurseSol {
        public int[][] updateMatrix(int[][] matrix) {
            int[][] output = new int[matrix[0].length][matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        output[i][j] = 0;
                    } else {
                        output[i][j] = recurse(i, j, matrix, 0, matrix[0].length, matrix.length);
                    }
                }
            }
            return output;
        }

        public int recurse(int i, int j, int[][] matrix, int step, int rowsize, int columnsize) {

            int min = 10001;
            if (i < 0 || j < 0 || i == rowsize || j == columnsize) {
                return 10001;
            }

            if (matrix[i][j] == 0) {
                return step;
            }

            int stepleft = recurse(i, j - 1, matrix, step + 1, rowsize, columnsize);
            if (stepleft < min) {
                min = stepleft;
            }
            int stepup = recurse(i - 1, j, matrix, step + 1, rowsize, columnsize);
            if (stepup < min) {
                min = stepup;
            }
            int stepdown = recurse(i + 1, j, matrix, step + 1, rowsize, columnsize);
            if (stepdown < min) {
                min = stepdown;
            }
            int stepright = recurse(i + 1, j, matrix, step + 1, rowsize, columnsize);
            if (stepright < min) {
                min = stepright;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        RecurseSol recurseSol = new RecurseSol();
        recurseSol.updateMatrix(matrix);
    }
}
