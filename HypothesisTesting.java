// HypothesisTesting.java
package stat_hub;

public class HypothesisTesting {
    private double[] sampleData;
    private double populationMean;
    private double populationStandardDeviation;
    private double significanceLevel;

    public HypothesisTesting(double[] sampleData, double populationMean, double populationStandardDeviation, double significanceLevel) {
        this.sampleData = sampleData;
        this.populationMean = populationMean;
        this.populationStandardDeviation = populationStandardDeviation;
        this.significanceLevel = significanceLevel;
    }

    // Method to perform the hypothesis test
    public String performTest() {
        double sampleMean = calculateMean(sampleData);
        double standardError = populationStandardDeviation / Math.sqrt(sampleData.length);
        double zScore = (sampleMean - populationMean) / standardError;

        // Calculate critical value based on significance level
        // For simplicity, assuming a two-tailed test
        double criticalValue = ZDistribution.inverseCumulativeProbability(1 - significanceLevel / 2);

        // Compare Z-score with critical value
        if (Math.abs(zScore) > criticalValue) {
            return "Reject null hypothesis";
        } else {
            return "Fail to reject null hypothesis";
        }
    }

    // Method to calculate the mean of an array
    private double calculateMean(double[] data) {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.length;
    }
}
