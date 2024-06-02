// Two way implementation
package StatHub;

import StatHub.*;
import java.util.*;

public class TwoWayWithoutReplication extends Statistic {

    public TwoWayWithoutReplication(double[][] data2D, int row, int column) {
        super(data2D, row, column);
    }

    public double sst() {
        double mean = arraySum2D() / (row * column);
        double sst = 0;

        // Calculate sum of squared differences from the mean
        for (double[] num : getData2D()) {
            for (double d : num) {

                sst += Math.pow(d - mean, 2);
            }
        }
        return sst;
    }

    public double ssc() {

        double[] meanarb = new double[column];
        // ArrayList meanarbay = new ArrayList<>();
        for (int i = 0; i < meanarb.length; i++) {
            meanarb[i] = columnSum(i) / row;
        }
        Statistic temp$ = new Statistic(meanarb);
        // super(meanarb);
        double meanofmean = temp$.arraySum() / column;
        double sumSquaredDifferences = 0;

        // Calculate sum of squared differences from the mean
        for (double num : meanarb) {
            sumSquaredDifferences += Math.pow(num - meanofmean, 2);
        }
        return sumSquaredDifferences * row;
    }

    public double ssr() { // Row Sum of Squares
        double[] meanarc = new double[row];
        for (int i = 0; i < meanarc.length; i++) {
            meanarc[i] = rowSum(i) / column;
        }
        Statistic temp2 = new Statistic(meanarc);
        double meanOfMean = temp2.arraySum() / row;
        double sumSquaredDifferences = 0;

        // Calculate sum of squared differences from the mean
        for (double num : meanarc) {
            sumSquaredDifferences += Math.pow(num - meanOfMean, 2);
        }
        return sumSquaredDifferences * column;
    }

    public double sse() { // sum of square error
        return sst() - ssr() - ssc();
    }

    public double twoWayAlpha() { // for ssr
        return (ssr() / (row - 1)) / (sse() / ((row - 1) * (column - 1)));
    }

    public double twoWayBeta() { // for ssc
        return (ssc() / (column - 1)) / (sse() / ((row - 1) * (column - 1)));

    }
}