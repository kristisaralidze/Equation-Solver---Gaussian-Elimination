package linear.algebra;


public class GaussianElimination {

        private int rows;
        private int cols;
        private double[][] matrix;

        public int getRows() {
            return rows;
        }

        public int getCols() {
            return cols;
        }

        public double[][] getMatrix() {
            return matrix;
        }

        public void setMatrix(double[][] mtrx) {
            for (int i = 0; i < mtrx.length; i++) {
                for (int j = 0; j < mtrx[0].length; j++) {
                    this.matrix[i][j] = mtrx[i][j];
                }
            }
        }

        public GaussianElimination(int rows, int cols, double[][] matrix) {
            this.rows = rows;
            this.cols = cols;
            this.matrix = matrix;
        }

        public void rowEchelonForm() {
            int h = 0;
            int k = 0;
            while (h < this.rows && k < this.cols) {
                int iMax = argMax(h, k);
                if (this.matrix[iMax][k] == 0) {
                    k++;
                } else {
                    swapRows(h, iMax);
                    for (int i = (h+1); i < this.rows; i++) {
                        multiplyAndAddRow(i, h, k);
                    }
                    multiplyRow(h, k);
                    h++;
                    k++;
                }
            }
        }

        private int argMax(int indRow, int indCol) {
            int iMax = indRow;
            double max = this.matrix[indRow][indCol];
            for (int i = (indRow + 1); i < this.rows; i++) {
                if (Math.abs(this.matrix[i][indCol]) > Math.abs(max)) {
                    iMax = i;
                    max = this.matrix[i][indCol];
                }
            }
            return iMax;
        }

        private void swapRows(int row1, int row2) {
            double[] aux = this.matrix[row1];
            this.matrix[row1] = this.matrix[row2];
            this.matrix[row2] = aux;
        }

        private void multiplyAndAddRow(int addRow, int mulRow, int colIndex) {
            double ratio = this.matrix[addRow][colIndex] / this.matrix[mulRow][colIndex];
            matrix[addRow][colIndex]=0.0;
            for (int i = (colIndex+1); i < this.cols; i++) {
                this.matrix[addRow][i] -= this.matrix[mulRow][i]  * ratio;
            }
        }

        private void multiplyRow(int rowInd, int colInd) {
            double x = this.matrix[rowInd][colInd];
            for (int j = 0; j < this.cols; j++) {
                this.matrix[rowInd][j] = this.matrix[rowInd][j] / x;
            }
        }

        public void backSubstitution() {
            for (int i = (this.rows - 1); i >= 0; i--) {
                if (this.matrix[i][i] == 0.0) {
                    throw new IllegalArgumentException("Matrix has no unique solution!");
                }
                for (int j = (i - 1); j >= 0; j--) {
                    multiplyAndAddRow(j, i, i);
                }
            }
        }

        public void print() {
        for (int i = 0; i < this.rows; i++) {
            StringBuilder str = new StringBuilder();

            if(this.matrix[i][0] > 0.0){
                str.append("+");
            }
            str.append(this.matrix[i][0]).append('x');
            if(this.matrix[i][1] > 0.0){
                str.append("+");
            }
            str.append(this.matrix[i][1]).append('y');
            if(this.matrix[i][2] > 0.0){
                str.append("+");
            }
            str.append(this.matrix[i][2]).append('z');
            str.append(" = ");
            if(this.matrix[i][3] > 0.0){
                str.append("+");
            }
            str.append(this.matrix[i][3]);
            System.out.println(str.toString());
            }
        }

        private void checkMatrixDimensions(double[][] mtrx){
            if ((mtrx.length != this.rows) || (mtrx[0].length != this.cols)) {
                throw new IllegalArgumentException("Can't set a new matrix with a different number of rows and columns!");
            }
        }
    
}


