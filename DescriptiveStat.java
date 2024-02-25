package StatHub;
import StatHub.*;
import java.util.*;

public class DescriptiveStat extends Statistic {

    public DescriptiveStat(double[] data) {
        super(data);
    }

    // Method to calculate the mean
    public double mean() {
        return arraySum() / getData().length;
    }

    // Method to calculate the median
    public double median() {
        double[] sortedData = Arrays.copyOf(getData(), getData().length);
        Arrays.sort(sortedData);
        int middle = sortedData.length / 2;
        if (sortedData.length % 2 == 0) {
            return (sortedData[middle - 1] + sortedData[middle]) / 2.0;
        } else {
            return sortedData[middle];
        }
    }

    // Method to calculate the mode
    public double mode() {
        double[] data = getData();
        Arrays.sort(data);
        double mode = data[0];
        int maxCount = 0;
        int currentCount = 1;

        for (int i = 1; i < data.length; i++) {
            if (data[i] == data[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mode = data[i - 1];
                }
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            mode = data[data.length - 1];
        }

        return mode;
    }

    public double range() { // calculate range
        double[] sortedData = Arrays.copyOf(getData(), getData().length);
        Arrays.sort(sortedData);
        return sortedData[sortedData.length - 1] - sortedData[0];
    }

    // Method to calculate sample variance
    public double sampleVariance() {
        double mean = arraySum() / getData().length;
        double sumSquaredDifferences = 0;

        // Calculate sum of squared differences from the mean
        for (double num : getData()) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }

        // Calculate sample variance
        return sumSquaredDifferences / (getData().length - 1);
    }
    // Method to calculate population variance
    public double populationVariance() {
        double mean = arraySum() / getData().length;
        double sumSquaredDifferences = 0;

        // Calculate sum of squared differences from the mean
        for (double num : getData()) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }

        // Calculate population variance
        return sumSquaredDifferences / getData().length;
    }
    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }
    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }
}