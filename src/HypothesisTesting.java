// HypothesisTesting.java
package StatHub;


import StatHub.DescriptiveStat;
import StatHub.Statistic;
import java.lang.Math;

public class HypothesisTesting extends DescriptiveStat {
    private double[] sampleData;
    private double nullHypothesis;
    private double populationMean;
    private double populationStandardDeviation;
    private int size;
    // private double significanceLevel;

    public HypothesisTesting(double sampleData[], double populationMean, double nullHypothesis,
            double populationStandardDeviation,
            int size) {
        super(sampleData);
        this.populationMean = populationMean;
        this.nullHypothesis=nullHypothesis;
        this.populationStandardDeviation = populationStandardDeviation;
        // this.significanceLevel = significanceLevel;
        this.size = size;
    }

    public double zTest() {
        double standardError = populationStandardDeviation / Math.sqrt(size);
        double zScore =  ((populationMean - nullHypothesis) / standardError);
        // System.out.println("!!!");
        return zScore;
    }
    
    
}
