import java.util.Arrays;
import java.util.Scanner;
import StatHub.DescriptiveStat;
import StatHub.Statistic;
import StatGraphics.Welcome;
import StatGraphics.Loading;
import StatHub.HypothesisTesting;
import StatTable.T_Table;

public class Main {
    public static void goBack() {
        System.out.println();
        System.out.println("Press 0 for go back");
        Scanner g = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            choice = g.nextInt();

        }
    }

    public static void main(String[] args) {
        // Inside the main method of your Main class
        Welcome welcomeGraphics = new Welcome();
        Loading loadingGraphics = new Loading();
        // welcomeGraphics.art();
        welcomeGraphics.art();
        System.out.println();
        System.out.println();
        loadingGraphics.art();// loading in console
        Scanner scanner = new Scanner(System.in);
        Statistic cls = new Statistic(null);
        boolean exitProgram = false;
        System.out.println();
        cls.cls();
        // System.out.println();
        while (!exitProgram) {
            // Display Main Menu
            welcomeGraphics.art();// stat hub welcome logo
            System.out.println();
            System.out.println();
            System.out.println("Main Menu");
            System.out.println("1. Descriptive statistics");
            System.out.println("2. Hypothesis testing");
            System.out.println("3. ANOVA");
            System.out.println("4. Exit");

            // Read user input for main menu
            System.out.println("Enter Choice: ");
            int mainMenuChoice = scanner.nextInt();
            cls.cls();

            switch (mainMenuChoice) {
                case 1:
                    // input sample
                    System.out.println("Enter the sample size: ");
                    int n = scanner.nextInt();
                    double data[] = new double[n];
                    cls.cls();
                    System.out.println("Enter the elements: ");
                    data = cls.arrayInput(n);
                    DescriptiveStat stat = new DescriptiveStat(data);
                    boolean backToMain = false;
                    // Display Descriptive Stat menu
                    while (!backToMain) {
                        cls.cls();
                        System.out.println("Descriptive Stat");
                        System.out.println("1. Mean");
                        System.out.println("2. Median");
                        System.out.println("3. Mode");
                        System.out.println("4. Range");
                        System.out.println("5. Variance");
                        System.out.println("6. Standard Deviation");
                        System.out.println("7. Descriptive Statistics Table");
                        System.out.println("8. Back to Main Menu");

                        // Read user input for descriptive stat menu
                        int descriptiveStatChoice = scanner.nextInt();
                        cls.cls();
                        switch (descriptiveStatChoice) {
                            case 1:
                                // Calculate and display mean
                                System.out.println("Mean: " + stat.mean());

                                goBack();
                                break;
                            case 2:
                                // Calculate and display median
                                System.out.println("Median: " + stat.median());

                                // stat.median();
                                goBack();
                                break;
                            case 3:
                                // Calculate and display mode
                                System.out.println("Mode: " + stat.mode());

                                // stat.mode();
                                goBack();
                                break;
                            case 4:
                                // Calculate and display range
                                System.out.println("Range: " + stat.range());

                                // stat.range();
                                goBack();
                                break;
                            case 5:
                                // Display Variance submenu
                                boolean backToDescriptiveStat = false;
                                while (!backToDescriptiveStat) {
                                    cls.cls();
                                    System.out.println("Variance");
                                    System.out.println("1. Population");
                                    System.out.println("2. Sample");
                                    System.out.println("3. Back to Descriptive Stat Menu");

                                    // Read user input for variance submenu
                                    int varianceChoice = scanner.nextInt();
                                    cls.cls();
                                    switch (varianceChoice) {
                                        case 1:
                                            // Calculate and display population variance
                                            System.out.println("Population Variance: " + stat.populationVariance());

                                            // stat.populationVariance();
                                            goBack();
                                            break;
                                        case 2:
                                            // Calculate and display sample variance
                                            System.out.println("Sample Variance: " + stat.sampleVariance());

                                            // stat.sampleVariance();
                                            goBack();
                                            break;
                                        case 3:
                                            // Go back to descriptive stat menu
                                            backToDescriptiveStat = true;
                                            break;
                                        default:
                                            // Invalid choice
                                            System.out.println("Invalid Choice!!");
                                            goBack();
                                            break;
                                    }
                                }
                                break;
                            case 6:
                                // Display Standard Deviation submenu
                                backToDescriptiveStat = false;
                                while (!backToDescriptiveStat) {
                                    cls.cls();
                                    System.out.println("Standard Deviation");
                                    System.out.println("1. Population");
                                    System.out.println("2. Sample");
                                    System.out.println("3. Back to Descriptive Stat Menu");

                                    // Read user input for Standard Deviation submenu
                                    int StandardDeviationChoice = scanner.nextInt();
                                    cls.cls();
                                    switch (StandardDeviationChoice) {
                                        case 1:
                                            // Calculate and display population Standard Deviation
                                            System.out.println("Population Standard Deviation: "
                                                    + stat.populationStandardDeviation());

                                            // stat.populationStandardDeviation();
                                            goBack();
                                            break;
                                        case 2:
                                            // Calculate and display sample Standard Deviation
                                            System.out.println(
                                                    "Sample Standard Deviation" + stat.sampleStandardDeviation());

                                            // stat.sampleStandardDeviation();
                                            goBack();
                                            break;
                                        case 3:
                                            // Go back to descriptive stat menu
                                            backToDescriptiveStat = true;
                                            break;
                                        default:
                                            // Invalid choice
                                            System.out.println("Invalid Choice!!");
                                            goBack();
                                            break;
                                    }
                                }
                                break;
                            case 7:
                                // Display the descriptive statistics table
                                System.out.println("Descriptive Statistics Table:");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("|      Data Size        |     " + String.format("%-21d", n) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("|      Data Elements    | "
                                        + String.format("%-21s", Arrays.toString(stat.getData())) + " |");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println(
                                        "|        Mean           |     " + String.format("%-21.2f", stat.mean()) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("|       Median          |     "
                                        + String.format("%-21.2f", stat.median()) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println(
                                        "|        Mode           |     " + String.format("%-21.2f", stat.mode()) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("|        Range          |     "
                                        + String.format("%-21.2f", stat.range()) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("| Population Variance   |     "
                                        + String.format("%-21.2f", stat.populationVariance()) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("|   Sample Variance     |     "
                                        + String.format("%-21.2f", stat.sampleVariance()) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("|   Population SD       |     "
                                        + String.format("%-21.2f", stat.populationStandardDeviation()) + "|");
                                System.out.println("+-----------------------+-----------------------+");
                                System.out.println("|      Sample SD        |     "
                                        + String.format("%-21.2f", stat.sampleStandardDeviation()) + "|");
                                System.out.println("+-----------------------+-----------------------+");

                                goBack();
                                break;
                            case 8:
                                // Go back to main menu
                                backToMain = true;
                                break;
                            default:
                                // Invalid choice
                                System.out.println("Invalid Choice!!");
                                goBack();
                                break;
                        }
                    }
                    break;
                case 2:// Hypothesis Testing
                       // input sample
                    String tTableFile = "E:\\.Programming\\STAT HUB\\src\\t_table.txt"; // T- table file location

                    T_Table table = new T_Table();
                    double[][] tTabel = table.readTable(tTableFile);
                    // DescriptiveStat stat = new DescriptiveStat(data);
                    backToMain = false;
                    // Display Hypothesis testing menu
                    while (!backToMain) {
                        cls.cls();
                        System.out.println("Hypothesis Testing");
                        System.out.println("1. Population Standard Deviation Given");
                        System.out.println("2. Not Given");
                        System.out.println("3. Display T-table");
                        System.out.println("4. Back to Main Menu");

                        // Read user input for descriptive stat menu
                        int HypothesisChoice = scanner.nextInt();
                        cls.cls();
                        switch (HypothesisChoice) {
                            case 1:

                                System.out.println("Enter Null Hypothesis: ");
                                double nullHypothesis = scanner.nextDouble();
                                cls.cls();
                                System.out.println("Enter Population Mean: ");
                                double populationMean = scanner.nextDouble();
                                cls.cls();
                                System.out.println("Enter Population Standard Deviation: ");
                                double populationStandardDeviation = scanner.nextDouble();
                                cls.cls();
                                System.out.println("Enter Sample Size: ");
                                int size = scanner.nextInt();
                                System.out.println("Enter Significance Level in %: ");
                                String sLevel = scanner.nextLine();
                                cls.cls();
                                double[] data2 = new double[size];
                                HypothesisTesting hypo = new HypothesisTesting(data2, populationMean, nullHypothesis,
                                        populationStandardDeviation, size);
                                double zScore = hypo.zTest();
                                if (tTabel[30][table.column(sLevel)] < zScore) {
                                    System.out.println("Fail to reject Null Hypothesis.");

                                } else
                                    System.out.println("Reject Null Hypothesis");
                                goBack();
                                break;
                            case 2:

                                break;
                            case 3:
                                table.displayTable(tTabel);
                                goBack();
                                break;
                            case 4:
                                backToMain = true;
                                break;
                            default:
                                break;
                        }
                        // Display Hypothesis Testing menu

                        // Similar implementation as Descriptive Stat menu
                        // break;
                    }
                    break;
                    // case 3:
                    // // Display ANOVA menu
                    // // Similar implementation as Descriptive Stat menu
                    // break;
                case 4:
                    // Exit program
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }
        }

    }
}
