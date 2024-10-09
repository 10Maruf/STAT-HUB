package StatTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chisqr_Table extends StatTable {

    // Read the numbers from the file and store them in a 2D array
    @Override
    public double[][] readTable(String filename) {
        return super.readTable(filename);
    }

    public int column(String significanceLevel) {
        if (significanceLevel.equals("99.5"))
            return 0;
        else if (significanceLevel.equals("99"))
            return 1;
        else if (significanceLevel.equals("97.5"))
            return 2;
        else if (significanceLevel.equals("95"))
            return 3;
        else if (significanceLevel.equals("90"))
            return 4;
        else if (significanceLevel.equals("10"))
            return 5;
        else if (significanceLevel.equals("5"))
            return 6;
        else if (significanceLevel.equals("2.5"))
            return 7;
        else if (significanceLevel.equals("1"))
            return 8;
        else if (significanceLevel.equals("0.5"))
            return 9;
        else
            return -1; // Return -1 if the significance level is invalid
    }
}
