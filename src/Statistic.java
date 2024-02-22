// Statistic.java
package stat_hub;
import java.util.Arrays;
 class Statistic {
    private double[] data;

    public Statistic(double[] data) {
        this.data = data;
    }

    // Getters and setters for data array
    public double[] getData() {
        return data;
    }

    // Method to calculate sum of array elements
    public double arraySum() {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum;
    }
}
  