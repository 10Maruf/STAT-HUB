package StatTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class StatTable {
    public double[][] readTable(String filename) {
        try {
            // Open the file
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            // Determine the number of rows and columns
            int rows = 0;
            int columns = 0;
            while (scanner.hasNextLine()) {
                rows++;
                String[] line = scanner.nextLine().trim().split("\\s+");
                columns = Math.max(columns, line.length);
            }

            // Create the 2D array
            double[][] numbers = new double[rows][columns];

            // Reset the scanner
            scanner = new Scanner(file);

            // Read the numbers from the file and store them in the array
            int row = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split("\\s+");
                for (int col = 0; col < line.length; col++) {
                    numbers[row][col] = Double.parseDouble(line[col]);
                }
                row++;
            }

            // Close the scanner
            scanner.close();

            return numbers;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing double from file: " + filename);
            return null;
        }
    }

    // double[][] array=new double[30][9];

    public void displayTable(double[][] array) {
        if (array == null) {
            System.out.println("Table is null");
            return;
        }
        for (double[] row : array) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/**
 * T_Table
 */
public class T_Table extends StatTable {

    // Read the numbers from the file and store them in a 2D array
    @Override
    public double[][] readTable(String filename) {

        return super.readTable(filename);
    }

    public int column(String significanceLevel) {
        if (significanceLevel == "50")
            return 0;
        else if (significanceLevel == "25")
            return 1;
        else if (significanceLevel == "20")
            return 2;
        else if (significanceLevel == "15")
            return 3;
        else if (significanceLevel == "10")
            return 4;
        else if (significanceLevel == "5")
            return 5;
        else if (significanceLevel == "2.5")
            return 6;
        else if (significanceLevel == "1")
            return 7;
        else if (significanceLevel == "0.5")
            return 8;
        else
            return 9;
        // return -1;
    }
}