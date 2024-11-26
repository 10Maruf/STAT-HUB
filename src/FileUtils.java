package StatFile;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    private int rows = 0;
    private int cols = 0;

    public Object readDataFromFile(String filePath) {
        ArrayList<double[]> dataList = new ArrayList<>();
        rows = 0;
        cols = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split("[,\\s]+");
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

        if (rows == 1) {
            return dataList.get(0);
        }

        double[][] dataArray = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            dataArray[i] = dataList.get(i);
        }

        return dataArray;
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return cols;
    }
}
