import java.util.Scanner;
import StatHub.DescriptiveStat;
import StatHub.Statistic;
import StatGraphics.Welcome;
import StatGraphics.Loading;

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
                        System.out.println("7. Back to Main Menu");

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
                // case 2:
                // // Display Hypothesis Testing menu
                // // Similar implementation as Descriptive Stat menu
                // break;
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
