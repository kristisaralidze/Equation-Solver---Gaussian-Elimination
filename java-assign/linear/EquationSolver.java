package linear;

import linear.algebra.GaussianElimination;

public class EquationSolver {
    public static void main(String[] args) {
        int numOfRows = args.length;
        String[] oneLine = args[0].split(",");
        int numOfColumns = oneLine.length;
        double[][] matrix = new double[numOfRows][numOfColumns];

        for (int i = 0; i < numOfRows; i++) {
            String[] nums = args[i].split(",");
            double[] row = stringsToDoubles(nums);
            matrix[i] = row;
        }

        GaussianElimination gaussianElimination = new GaussianElimination(numOfRows, numOfColumns, matrix);
        gaussianElimination.print();
        gaussianElimination.rowEchelonForm();
        gaussianElimination.print();
        gaussianElimination.backSubstitution();
        gaussianElimination.print();
    }

    private static double[] stringsToDoubles(String[] nums) {
        double[] parsed = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            parsed[i] = Double.parseDouble(nums[i]);
        }
        return parsed;
    }
}

