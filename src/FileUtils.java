package StatFile;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    private int rows = 0;
    private int cols = 0;

    // Method to read data and determine 1D or 2D array
    public Object readDataFromFile(String filePath) {
        ArrayList<double[]> dataList = new ArrayList<>();
        rows = 0;
        cols = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split("[,\\s]+"); // Split by comma or space
                double[] row = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Double.parseDouble(values[i]);
                }
                dataList.add(row);
                rows++;
                cols = row.length;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }

        // Handle case for single-row data
        if (rows == 1) {
            return dataList.get(0); // Return 1D array for a single row
        }

        double[][] dataArray = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            dataArray[i] = dataList.get(i);
        }

        return dataArray; // Return 2D array for multiple rows
    }

    // Getter for row count
    public int getRowCount() {
        return rows;
    }

    // Getter for column count
    public int getColumnCount() {
        return cols;
    }
}
