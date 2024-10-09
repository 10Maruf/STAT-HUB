import java.util.Scanner;
// import org.apache.commons.math3.distribution.ChiSquaredDistribution;

public class ChiSquareTest {

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
        double chiSquare = 0.0;
        for (int i = 0; i < observed.length; i++) {
            for (int j = 0; j < observed[0].length; j++) {
                if (expected[i][j] > 0) { // Avoid division by zero
                    chiSquare += Math.pow(observed[i][j] - expected[i][j], 2) / expected[i][j];
                }
            }
        }
        return chiSquare; // Return Chi-Square statistic
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChiSquareTest chiSquareTest = new ChiSquareTest();

        // Input table dimensions
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        // Initialize observed frequency array
        double[][] observed = new double[rows][cols];

        // Input observed frequencies
        System.out.println("Enter the observed frequencies:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // System.out.printf("Observed[%d][%d]: ", i + 1, j + 1);
                observed[i][j] = scanner.nextDouble();
            }
        }

        // Calculate totals
        int[] totalRows = new int[rows];
        int[] totalCols = new int[cols];
        int grandTotal = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalRows[i] += observed[i][j];
                totalCols[j] += observed[i][j];
                grandTotal += observed[i][j];
            }
        }

        // Calculate expected frequencies
        double[][] expected = chiSquareTest.calculateExpected(observed, totalRows, totalCols, grandTotal);

        // Perform the Chi-Square Test
        double chiSquareValue = chiSquareTest.testOfIndependence(observed, expected);
        System.out.println(chiSquareValue);
      

        scanner.close();
    }
}
