// Statistic.java
package StatHub;

import java.util.Arrays;
import java.util.Scanner;

public class Statistic {
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

    public double[] arrayInput(int n) {
        data = new double[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextDouble();
        }
        return data;
    }

    public static void cls() {
        // ANSI escape code to clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
