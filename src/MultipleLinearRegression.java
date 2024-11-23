package StatHub;

public class MultipleLinearRegression {
    private final int n;
    private final int p;
    private final double[][] X;
    private final double[] Y;
    private double[] coefficients;
    private double sst;
    private double ssr;
    private double sse;

    public MultipleLinearRegression(double[][] predictors, double[] response) {
        this.n = response.length;
        this.p = predictors[0].length;
        this.X = new double[n][p + 1];
        this.Y = response;
        this.coefficients = new double[p + 1];

        for (int i = 0; i < n; i++) {
            X[i][0] = 1.0;
            System.arraycopy(predictors[i], 0, X[i], 1, p);
        }

        calculateCoefficients();
        calculateSST_SSR_SSE();
    }

    private void calculateCoefficients() {

        double[][] XtX = multiply(transpose(X), X);

        double[] XtY = multiply(transpose(X), Y);

        coefficients = gaussianElimination(XtX, XtY);
    }

    private void calculateSST_SSR_SSE() {
        double yMean = 0.0;
        for (double y : Y) {
            yMean += y;
        }
        yMean /= n;

        double[] predictedY = new double[n];
        for (int i = 0; i < n; i++) {
            predictedY[i] = coefficients[0];
            for (int j = 1; j <= p; j++) {
                predictedY[i] += coefficients[j] * X[i][j];
            }
        }

        sst = 0.0;
        ssr = 0.0;
        sse = 0.0;

        for (int i = 0; i < n; i++) {
            sst += Math.pow(Y[i] - yMean, 2);
            ssr += Math.pow(predictedY[i] - yMean, 2);
            sse += Math.pow(Y[i] - predictedY[i], 2);
        }
    }

    private double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] transposed = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    private double[][] multiply(double[][] A, double[][] B) {
        int rows = A.length;
        int cols = B[0].length;
        int common = B.length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < common; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    private double[] multiply(double[][] A, double[] B) {
        int rows = A.length;
        int cols = A[0].length;
        double[] result = new double[rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i] += A[i][j] * B[j];
            }
        }
        return result;
    }

    private double[] gaussianElimination(double[][] A, double[] B) {
        int n = B.length;
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {

            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > Math.abs(A[max][i])) {
                    max = j;
                }
            }

            double[] temp = A[i];
            A[i] = A[max];
            A[max] = temp;

            double t = B[i];
            B[i] = B[max];
            B[max] = t;

            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                B[j] -= factor * B[i];
                for (int k = i; k < n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * result[j];
            }
            result[i] = (B[i] - sum) / A[i][i];
        }

        return result;
    }

    public void displayResults() {
        System.out.println("+--------------------------------------+");
        System.out.println("|     Multiple Linear Regression       |");
        System.out.println("+--------------------------------------+");

        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0) {
                System.out.printf("| Intercept (B0): %-22.4f |%n", coefficients[i]);
            } else {
                System.out.printf("| Coefficient (B%d): %-18.4f |%n", i, coefficients[i]);
            }
        }
        System.out.println("+--------------------------------------+");
        System.out.printf("| SST (Total Sum of Squares): %-8.4f |%n", sst);
        System.out.printf("| SSR (Regression Sum of Squares): %-8.4f |%n", ssr);
        System.out.printf("| SSE (Error Sum of Squares): %-8.4f |%n", sse);
        System.out.println("+--------------------------------------+");
    }

    public double[] getCoefficients() {
        return coefficients;
    }

    public double getSST() {
        return sst;
    }

    public double getSSR() {
        return ssr;
    }

    public double getSSE() {
        return sse;
    }
}
