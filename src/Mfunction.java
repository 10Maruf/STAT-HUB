package StatMfunction;
//all important fuction for calcule p-value

import java.util.function.Function;

public class Mfunction {

    private static final int N = 100000;
    private static final double GAMMA_INTEGRATION_LIMIT = 100.0;// for infinity

    // integration using the Trapezoidal Rule
    public double integrate(double a, double b, Function f) {
        double h = (b - a) / N;
        double sum = 0.5 * (f.apply(a) + f.apply(b));

        for (int i = 1; i < N; i++) {
            double x = a + i * h;
            sum += f.apply(x);
        }

        return sum * h;
    }

    public double erf(double x) {// Error Function
        return (2 / Math.sqrt(Math.PI)) * integrate(0, x, t -> Math.exp(-t * t));
    }

    public double erfc(double x) {
        return 1 - erf(x); // erfc(x) = 1 - erf(x)
    }

    // cumulative distribution function for hypothesis testing
    public double hypo_CDF(double z_score) {
        double x = z_score / Math.sqrt(2);
        return (1 + erf(x)) / 2;
    }

    // CDF of the F-distribution
    public double F_dis_CDF(double F, double d1, double d2) {// F= F distribution value
        double a = d1 / 2;// Numerator degree of freedom
        double b = d2 / 2;// Denominator degree of freedom
        double x = (d1 * F) / (d1 * F + d2);
        return incompleteBeta(x, a, b);
    }

    // incomplete beta function I(x,a,b)
    public double incompleteBeta(double x, double a, double b) {
        double B_x_ab = integrate(0, x, t -> Math.pow(t, a - 1) * Math.pow(1 - t, b - 1));
        double B_ab = integrate(0, 1, t -> Math.pow(t, a - 1) * Math.pow(1 - t, b - 1));
        return B_x_ab / B_ab;
    }

    // CDF for Chi-Square distribution
    public double chisqr_CDF(double chi_square, double k) {// k is Degree of freedom
        if (k == 1) {
            // Special handling for 1 degree of freedom (related to normal distribution)
            return 1 - erfc(Math.sqrt(chi_square) / Math.sqrt(2));
        }

        double s = k / 2.0;
        return lowerIncompleteGamma(s, chi_square / 2.0) / gamma(s);
    }

    // Gamma function Γ(s) with truncation at a large value//also called upper gamma
    // function
    public double gamma(double s) {
        return integrate(0, GAMMA_INTEGRATION_LIMIT, t -> Math.pow(t, s - 1) * Math.exp(-t));
    }

    // Lower incomplete gamma function γ(s, x)
    public double lowerIncompleteGamma(double s, double x) {
        return integrate(0, x, t -> Math.pow(t, s - 1) * Math.exp(-t));
    }

    // Functional interface for passing a function
    @FunctionalInterface
    public interface Function {
        double apply(double x);
    }

}
