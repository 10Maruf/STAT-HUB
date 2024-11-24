package StatHub;

public class PolynomialRegression {
    private int degree;
    private double[] coefficients;

    public PolynomialRegression(int degree) {
        this.degree = degree;
    }

    public void fit(double[] x, double[] y) {
        int n = x.length;
        double[][] X = new double[degree + 1][degree + 1];
        double[] Y = new double[degree + 1];

        for (int i = 0; i <= degree; i++) {
            for (int j = 0; j <= degree; j++) {
                X[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    X[i][j] += Math.pow(x[k], i + j);
                }
            }
        }

        for (int i = 0; i <= degree; i++) {
            Y[i] = 0;
            for (int k = 0; k < n; k++) {
                Y[i] += y[k] * Math.pow(x[k], i);
            }
        }

        coefficients = gaussianElimination(X, Y);
    }

    public double predict(double x) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    public void displayEquation() {
        System.out.print("y = ");
        for (int i = coefficients.length - 1; i >= 0; i--) {
            System.out.printf("%.4f", coefficients[i]);
            if (i > 0)
                System.out.print("x^" + i + " + ");
        }
        System.out.println();
    }

    private double[] gaussianElimination(double[][] A, double[] b) {
        int n = b.length;

        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > Math.abs(A[max][i]))
                    max = j;
            }
            double[] temp = A[i];
            A[i] = A[max];
            A[max] = temp;

            double t = b[i];
            b[i] = b[max];
            b[max] = t;

            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                b[j] -= factor * b[i];
                for (int k = i; k < n; k++) {
                    A[j][k] -= factor * A[i][k];
                }
            }
        }

        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }

        return x;
    }

    public void displayResults(double[] x, double[] y) {
        System.out.println("+--------------------------------------+");
        System.out.println("|         Polynomial Regression        |");
        System.out.println("+--------------------------------------+");

        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0) {
                System.out.printf("| Intercept (B0): %-22.4f |%n", coefficients[i]);
            } else {
                System.out.printf("| Coefficient (B%d): %-18.4f |%n", i, coefficients[i]);
            }
        }

        double sst = 0, ssr = 0, sse = 0;
        double meanY = 0;
        for (double value : y)
            meanY += value;
        meanY /= y.length;

        for (int i = 0; i < y.length; i++) {
            double predicted = predict(x[i]);
            sst += Math.pow(y[i] - meanY, 2);
            ssr += Math.pow(predicted - meanY, 2);
            sse += Math.pow(y[i] - predicted, 2);
        }

        System.out.println("+--------------------------------------+");
        System.out.printf("| SST (Total Sum of Squares): %-8.4f |%n", sst);
        System.out.printf("| SSR (Regression Sum of Squares): %-8.4f |%n", ssr);
        System.out.printf("| SSE (Error Sum of Squares): %-8.4f |%n", sse);
        System.out.println("+--------------------------------------+");
    }
}