package StatHub;

import StatHub.*;
import java.util.*;

public class ANOVA extends Statistic {

    public ANOVA(double[][] data2D, int row, int column) {
        super(data2D, row, column);
    }

    public double sst() {// total sum of square
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

    public double ssb() {// between sum of square
        double[] meanArr = new double[column];
        // ArrayList meanArray = new ArrayList<>();
        for (int i = 0; i < meanArr.length; i++) {
            meanArr[i] = columnSum(i) / row;
        }
        Statistic temp = new Statistic(meanArr);
        // super(meanArr);
        double meanofmean = temp.arraySum() / column;
        double sumSquaredDifferences = 0;

        // Calculate sum of squared differences from the mean
        for (double num : meanArr) {
            sumSquaredDifferences += Math.pow(num - meanofmean, 2);
        }
        return sumSquaredDifferences * row;
    }

    public double ssw() {// sum of within square
        return sst() - ssb();

    }

    public double oneWay() {
        return (ssb() / (column - 1)) / (ssw() / (row * column - column));
    }
}