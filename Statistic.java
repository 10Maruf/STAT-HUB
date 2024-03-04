// Statistic.java
package StatHub;

import java.util.Arrays;
import java.util.Scanner;

public class Statistic {
    private double[] data;
    private double[][] data2D;
    public int row, column;

    public Statistic(double[] data) {
        this.data = data;
    }

    public Statistic(double[][] data2D, int row, int column) {
        this.data2D = data2D;
        this.row = row;
        this.column = column;
    }

    // Getters and setters for data array
    public double[] getData() {
        return data;
    }
    // Getters and setters for data array

    public double[][] getData2D() {
        return data2D;
    }

    // Method to calculate sum of array elements
    public double arraySum() {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum;
    }

    // Method to calculate the sum of all elements in a 2D array
    public double arraySum2D() {
        double sum = 0;
        for (int i = 0; i < data2D.length; i++) {
            for (int j = 0; j < data2D[i].length; j++) {
                sum += data2D[i][j];
            }
        }
        return sum;
    }

    public double columnSum(int columnIndex) {
        double sum = 0;
        for (int i = 0; i < data2D.length; i++) {
            if (columnIndex >= 0 && columnIndex < data2D[i].length) {
                sum += data2D[i][columnIndex];
            } else {
                // Handle invalid column index
                System.out.println("Invalid column index.");
                return 0;
            }
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

    // Method to input data into a 2D array
    public double[][] arrayInput(int rows, int column) {
        this.row = row;
        this.column = column;
        data2D = new double[rows][column];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                data2D[i][j] = sc.nextDouble();
            }
        }
        return data2D;
    }

    public static void cls() {
        // ANSI escape code to clear screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
