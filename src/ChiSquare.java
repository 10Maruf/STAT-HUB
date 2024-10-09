package StatHub;

public class ChiSquare {

    // Method to calculate the expected frequencies
    public double[][] calculateExpected(double[][] observed, int[] rowTotals, int[] colTotals, int grandTotal) {
        int rows = observed.length;
        int cols = observed[0].length;
        double[][] expected = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                expected[i][j] = (double) (rowTotals[i] * colTotals[j]) / grandTotal;
            }
        }
        return expected;
    }

    // Chi-Square Test of Independence
    public double testOfIndependence(double[][] observed, double[][] expected) {
        double chisqrValue = 0.0;
        for (int i = 0; i < observed.length; i++) {
            for (int j = 0; j < observed[0].length; j++) {
                if (expected[i][j] > 0) { // Avoid division by zero
                    chisqrValue += Math.pow(observed[i][j] - expected[i][j], 2) / expected[i][j];
                }
            }
        }
        return chisqrValue; // Return Chi-Square statistic
    }
}