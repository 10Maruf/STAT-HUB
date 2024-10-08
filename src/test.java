// package StatMfunction;

import java.util.function.Function;

public class Mfunction {

    private static final int N = 100000; // Fixed number of subintervals for integration

    // Integration using the Trapezoidal Rule
    public double integrate(double a, double b, Function f) {
        double h = (b - a) / N;
        double sum = 0.5 * (f.apply(a) + f.apply(b));

        for (int i = 1; i < N; i++) {
            double x = a + i * h;
            sum += f.apply(x);
        }

        return sum * h;
    }

    // Error Function (ERF)
    public double erf(double x) {
        return (2 / Math.sqrt(Math.PI)) * integrate(0, x, t -> Math.exp(-t * t));
    }

    // Cumulative distribution function for hypothesis Mfunctioning
    public double hypo_CDF(double z_score) {
        double x = z_score / Math.sqrt(2);
        return (1 + erf(x)) / 2;
    }

    // CDF of the F-distribution with degrees of freedom d1 and d2
    public double F_dis_CDF(double F, double d1, double d2) {
        double a = d1 / 2;
        double b = d2 / 2;
        double x = (d1 * F) / (d1 * F + d2);
        return incompleteBeta(x, a, b);
    }

    // Method to calculate the incomplete beta function ratio I_x(a,b)
    public double incompleteBeta(double x, double a, double b) {
        double B_x_ab = integrate(0, x, t -> Math.pow(t, a - 1) * Math.pow(1 - t, b - 1));
        double B_ab = integrate(0, 1, t -> Math.pow(t, a - 1) * Math.pow(1 - t, b - 1));
        return B_x_ab / B_ab;
    }

    // Functional interface for passing a function
    @FunctionalInterface
    public interface Function {
        double apply(double x);
    }

    public static void main(String[] args) {
        Mfunction m = new Mfunction();

        // Example usage of hypo_CDF (for normal distribution)
        // double z_score = 1.0;
        // double result = m.hypo_CDF(z_score);
        // System.out.println("CDF for z_score = " + z_score + " is: " + result);

        // Example usage of F_dis_CDF (for F-distribution)
        double F_value = 34.48;
        double d1 = 4;  // Degrees of freedom 1
        double d2 = 15; // Degrees of freedom 2
        double f_cdf_result = m.F_dis_CDF(F_value, d1, d2);
        System.out.println("F-distribution CDF for F-value = " + F_value + " is: " + (1-f_cdf_result));
    }
}
