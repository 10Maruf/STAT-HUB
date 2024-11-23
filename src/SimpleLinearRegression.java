package StatHub;
public class SimpleLinearRegression {

    private double[][] data;
    private double a;
    private double b;
    private double sst;
    private double ssr;
    private double sse;

    public SimpleLinearRegression(double[][] data) {
        this.data = data;
        calculateRegression();
    }

    private void calculateRegression() {
        int n = data.length;

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;

        for (double[] row : data) {
            double x = row[0];
            double y = row[1];
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumY2 += y * y;
        }

        double meanX = sumX / n;
        double meanY = sumY / n;

        b = (sumXY - n * meanX * meanY) / (sumX2 - n * meanX * meanX);
        a = meanY - b * meanX;

        sst = 0;
        ssr = 0;
        sse = 0;
        for (double[] row : data) {
            double x = row[0];
            double y = row[1];
            double yPred = a + b * x; // Predicted value
            sst += (y - meanY) * (y - meanY);
            ssr += (yPred - meanY) * (yPred - meanY);
            sse += (y - yPred) * (y - yPred);
        }
    }

    public double getIntercept() {
        return a;
    }

    public double getSlope() {
        return b;
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

    public void displayResults() {
        System.out.println("======================================");
        System.out.println("Simple Linear Regression Results:");
        System.out.printf("Intercept (A): %.4f%n", a);
        System.out.printf("Slope (B): %.4f%n", b);
        System.out.println("--------------------------------------");
        System.out.printf("SST (Total Sum of Squares): %.4f%n", sst);
        System.out.printf("SSR (Regression Sum of Squares): %.4f%n", ssr);
        System.out.printf("SSE (Error Sum of Squares): %.4f%n", sse);
        System.out.println("======================================");
    }
}