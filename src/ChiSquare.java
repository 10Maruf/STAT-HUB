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

    public double[] calculateExpectedFromKnown(double[] observed, double[] expected) {// know exepected value
        return expected;
    }

    public double[] calculateExpectedFromProportions(double[] observed, double total, double[] proportions) {// expected
                                                                                                             // value
                                                                                                             // from
                                                                                                             // proportion
        double[] expected = new double[proportions.length];
        for (int i = 0; i < proportions.length; i++) {
            expected[i] = total * proportions[i];
        }
        return expected;
    }

    public double[] calculateExpectedEqualProportions(double[] observed) {// equal proportion
        double total = 0;
        for (double value : observed) {
            total += value;
        }
        double[] expected = new double[observed.length];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = total / expected.length;
        }
        return expected;
    }

    // expected frequencies using Poisson distribution
    public double[] calculateExpectedFromPoisson(double[] observed, double lambda, double total) {
        double[] expected = new double[observed.length];
        double cumulativeProbability = 0.0;

        for (int i = 0; i < expected.length - 1; i++) {
            double probability = (Math.pow(lambda, i) * Math.exp(-lambda)) / factorial(i); // Poisson formula
            expected[i] = probability * total;
            cumulativeProbability += probability;
        }

        // Last value: remaining probability mass
        double lastProbability = 1.0 - cumulativeProbability;
        expected[expected.length - 1] = lastProbability * total;

        return expected;
    }

    private double factorial(int n) {
        if (n == 0)
            return 1;
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public double testOfGoodnessOfFit(double[] observed, double[] expected) {
        double chisqrValue = 0.0;
        for (int i = 0; i < observed.length; i++) {
            if (expected[i] > 0) {
                chisqrValue += Math.pow(observed[i] - expected[i], 2) / expected[i];
            }
        }
        return chisqrValue; // Return Chi-Square statistic
    }
}
