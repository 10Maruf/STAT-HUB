
import java.util.Arrays;
import java.util.Scanner;
import StatHub.DescriptiveStat;
import StatHub.Statistic;
import StatGraphics.Credits;
import StatGraphics.Loading;
import StatGraphics.Welcome;
import StatTable.Chisqr_Table;
import StatTable.F_Table;
import StatTable.T_Table;
import StatTable.Chisqr_Table;
import StatHub.HypothesisTesting;
import StatHub.ANOVA;
import StatHub.TwoWayWithoutReplication;
import StatMfunction.Mfunction;
import StatHub.ChiSquare;
import StatHub.SimpleLinearRegression;

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
        Credits creditsGraphics = new Credits();
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
            System.out.println();
            welcomeGraphics.art();// stat hub welcome logo
            System.out.println();
            System.out.println();
            System.out.println("Main Menu");
            System.out.println("1. Descriptive statistics");
            System.out.println("2. Hypothesis testing");
            System.out.println("3. ANOVA");
            System.out.println("4. Chi-Square");
            System.out.println("5. Regression Analysis");
            System.out.println("6. Credits");
            System.out.println("0. Exit");

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
                        System.out.println("Enter Choice: ");

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
                                    System.out.println("Enter Choice: ");

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
                                    System.out.println("Enter Choice: ");

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
                        System.out.println("1. One Tailed");
                        System.out.println("2. Two Tailed");
                        System.out.println("3. Display T-table");
                        System.out.println("4. Back to Main Menu");

                        // Read user input for descriptive stat menu
                        System.out.println("Enter Choice: ");

                        int HypothesisChoice = scanner.nextInt();
                        cls.cls();
                        switch (HypothesisChoice) {
                            case 1:// one tailed
                                boolean backToHypothesis = false;
                                // Display Hypothesis testing menu
                                while (!backToHypothesis) {
                                    cls.cls();
                                    System.out.println("One Tailed Test");
                                    System.out.println("1. Population Standard Deviation Given");
                                    System.out.println("2. Not Given");
                                    System.out.println("3. Back to Hypothesis Testing");

                                    // Read user input for descriptive stat menu
                                    System.out.println("Enter Choice: ");

                                    int HypothesisChoice1 = scanner.nextInt();
                                    cls.cls();
                                    switch (HypothesisChoice1) {
                                        // population SD given
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
                                            cls.cls();
                                            scanner.nextLine(); // Consume newline character
                                            System.out.println("Enter Significance Level in %: ");
                                            String sLevel = scanner.nextLine();
                                            double[] data2 = new double[size];
                                            HypothesisTesting hypo = new HypothesisTesting(data2, populationMean,
                                                    nullHypothesis,
                                                    populationStandardDeviation, size);
                                            double zScore = hypo.zTest();
                                            Mfunction m1 = new Mfunction();
                                            cls.cls();
                                            if (tTabel[30][table.column(sLevel)] > Math.abs(zScore)) {
                                                System.out.println("P-value: " + m1.hypo_CDF(zScore));
                                                System.out.println("Fail to reject Null Hypothesis.");
                                                System.out.println(zScore);

                                            } else {
                                                System.out.println("P-value: " + m1.hypo_CDF(zScore));
                                                System.out.println("Reject Null Hypothesis");
                                                System.out.println(zScore);
                                            }

                                            goBack();
                                            break;
                                        case 2:// population not given
                                            boolean backToHypo1 = false;
                                            while (!backToHypo1) {
                                                cls.cls();
                                                System.out.println("Population Standard Deviation Not Given");
                                                System.out.println("1. Samples are given");
                                                System.out.println("2. Samples are not given");
                                                System.out.println("3. back to One Tailed");
                                                System.out.println("Enter Choice: ");

                                                int notGivenChoice = scanner.nextInt();
                                                cls.cls();
                                                switch (notGivenChoice) {
                                                    case 1:// samples are given
                                                        System.out.println("Enter Null Hypothesis: ");
                                                        double nH = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter sample size: ");
                                                        int ssize = scanner.nextInt();
                                                        double hypoData[] = new double[ssize];
                                                        cls.cls();
                                                        System.out.println("Enter Sample elements: ");
                                                        DescriptiveStat inhypodata = new DescriptiveStat(hypoData);
                                                        hypoData = inhypodata.arrayInput(ssize);
                                                        scanner.nextLine(); // Consume newline character
                                                        HypothesisTesting hypodata = new HypothesisTesting(hypoData,
                                                                inhypodata.mean(), nH,
                                                                inhypodata.sampleStandardDeviation(), ssize);
                                                        cls.cls();
                                                        System.out.println("Enter Significance Level in % : ");
                                                        String sigLevel = scanner.nextLine();
                                                        double tTest = hypodata.zTest();
                                                        Mfunction m2 = new Mfunction();
                                                        cls.cls();
                                                        if (tTabel[ssize - 2][table.column(sigLevel)] > Math
                                                                .abs(tTest)) {
                                                            System.out.println("P-value: " + m2.hypo_CDF(tTest));
                                                            System.out.println("Fail to reject Null Hypothesis.");

                                                        } else {
                                                            System.out.println("P-value: " + m2.hypo_CDF(tTest));

                                                            System.out.println("Reject Null Hypothesis");
                                                        }
                                                        goBack();
                                                        break;
                                                    case 2:// not given
                                                        System.out.println("Enter Null Hypothesis: ");
                                                        double nullHypothesis2 = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter Population Mean: ");
                                                        double populationMean2 = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter Population Standard Deviation: ");
                                                        double populationStandardDeviation2 = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter Sample Size: ");
                                                        int size2 = scanner.nextInt();
                                                        cls.cls();
                                                        scanner.nextLine(); // Consume newline character
                                                        System.out.println("Enter Significance Level in %: ");
                                                        String sLevel2 = scanner.nextLine();
                                                        double[] data22 = new double[size2];
                                                        HypothesisTesting hypo2 = new HypothesisTesting(data22,
                                                                populationMean2,
                                                                nullHypothesis2,
                                                                populationStandardDeviation2, size2);
                                                        double zScore2 = hypo2.zTest();
                                                        Mfunction m12 = new Mfunction();
                                                        cls.cls();
                                                        if (tTabel[size2 - 2][table.column(sLevel2)] > Math
                                                                .abs(zScore2)) {
                                                            System.out.println("P-value: " + m12.hypo_CDF(zScore2));
                                                            System.out.println("Fail to reject Null Hypothesis.");

                                                        } else {
                                                            System.out.println("P-value: " + m12.hypo_CDF(zScore2));

                                                            System.out.println("Reject Null Hypothesis");
                                                        }
                                                        goBack();
                                                        break;
                                                    case 3:
                                                        backToHypo1 = true;
                                                        break;

                                                    default:
                                                        System.out.println("Invalid Choice!!");
                                                        goBack();
                                                        break;
                                                }
                                            }

                                            break;
                                        case 3:
                                            backToHypothesis = true;
                                            break;
                                    }
                                }
                                // goBack();
                                break;
                            case 2:// two tailed
                                boolean backToHypothesis2 = false;
                                // Display Hypothesis testing menu
                                while (!backToHypothesis2) {
                                    cls.cls();
                                    System.out.println("Two Tailed Test");
                                    System.out.println("1. Population Standard Deviation Given");
                                    System.out.println("2. Not Given");
                                    System.out.println("3. Back to Hypothesis Testing");

                                    // Read user input for descriptive stat menu
                                    System.out.println("Enter Choice: ");

                                    int HypothesisChoice2 = scanner.nextInt();
                                    cls.cls();
                                    switch (HypothesisChoice2) {
                                        // population SD given
                                        case 1:

                                            System.out.println("Enter Null Hypothesis: ");
                                            double nullHypothesis2 = scanner.nextDouble();
                                            cls.cls();
                                            System.out.println("Enter Population Mean: ");
                                            double populationMean2 = scanner.nextDouble();
                                            cls.cls();
                                            System.out.println("Enter Population Standard Deviation: ");
                                            double populationStandardDeviation2 = scanner.nextDouble();
                                            cls.cls();
                                            System.out.println("Enter Sample Size: ");
                                            int size2 = scanner.nextInt();
                                            cls.cls();
                                            scanner.nextLine(); // Consume newline character
                                            System.out.println("Enter Significance Level in %: ");
                                            String sLevel2 = scanner.nextLine();
                                            double[] data22 = new double[size2];
                                            HypothesisTesting hypo2 = new HypothesisTesting(data22, populationMean2,
                                                    nullHypothesis2,
                                                    populationStandardDeviation2, size2);
                                            double zScore2 = hypo2.zTest();
                                            Mfunction m22 = new Mfunction();
                                            cls.cls();
                                            double pValue;
                                            if (tTabel[30][table.column(sLevel2) + 1] < Math.abs(zScore2)) {
                                                if (zScore2 > 0) {
                                                    pValue = 2 * (1 - m22.hypo_CDF(zScore2));
                                                } else {
                                                    pValue = 2 * m22.hypo_CDF(zScore2);
                                                }

                                                System.out.println("P-value: " + pValue);
                                                System.out.println("Fail to reject Null Hypothesis.");

                                            } else {
                                                if (zScore2 > 0) {
                                                    pValue = 2 * (1 - m22.hypo_CDF(zScore2));
                                                } else {
                                                    pValue = 2 * m22.hypo_CDF(zScore2);
                                                }

                                                System.out.println("P-value: " + pValue);
                                                System.out.println("Reject Null Hypothesis");
                                            }
                                            goBack();
                                            break;
                                        case 2:// population not given
                                            boolean backToHypo2 = false;
                                            while (!backToHypo2) {
                                                cls.cls();
                                                System.out.println("Population Standard Deviation Not Given");
                                                System.out.println("1. Samples are given");
                                                System.out.println("2. Samples are not given");
                                                System.out.println("3. back to Two Tailed");
                                                System.out.println("Enter Choice: ");

                                                int notGivenChoice2 = scanner.nextInt();
                                                cls.cls();
                                                switch (notGivenChoice2) {
                                                    case 1:// samples are given
                                                        System.out.println("Enter Null Hypothesis: ");
                                                        double nH2 = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter sample size: ");
                                                        int ssize2 = scanner.nextInt();
                                                        double hypoData2[] = new double[ssize2];
                                                        cls.cls();
                                                        System.out.println("Enter Sample elements: ");
                                                        DescriptiveStat inhypodata2 = new DescriptiveStat(hypoData2);
                                                        hypoData2 = inhypodata2.arrayInput(ssize2);
                                                        scanner.nextLine(); // Consume newline character
                                                        HypothesisTesting hypodata2 = new HypothesisTesting(hypoData2,
                                                                inhypodata2.mean(), nH2,
                                                                inhypodata2.sampleStandardDeviation(), ssize2);
                                                        cls.cls();
                                                        System.out.println("Enter Significance Level in % : ");
                                                        String sigLevel2 = scanner.nextLine();
                                                        double tTest2 = hypodata2.zTest();
                                                        // double pValue;
                                                        Mfunction m23 = new Mfunction();
                                                        cls.cls();
                                                        if (tTabel[ssize2 - 2][table.column(sigLevel2) + 1] < Math
                                                                .abs(tTest2)) {
                                                            if (tTest2 > 0) {
                                                                pValue = 2 * (1 - m23.hypo_CDF(tTest2));
                                                            } else {
                                                                pValue = 2 * m23.hypo_CDF(tTest2);
                                                            }

                                                            System.out.println("P-value: " + pValue);
                                                            System.out.println("Fail to reject Null Hypothesis.");

                                                        } else {
                                                            if (tTest2 > 0) {
                                                                pValue = 2 * (1 - m23.hypo_CDF(tTest2));
                                                            } else {
                                                                pValue = 2 * m23.hypo_CDF(tTest2);
                                                            }

                                                            System.out.println("P-value: " + pValue);
                                                            System.out.println("Reject Null Hypothesis");
                                                        }
                                                        goBack();
                                                        break;
                                                    case 2:// not given
                                                        System.out.println("Enter Null Hypothesis: ");
                                                        double nullHypothesis22 = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter Population Mean: ");
                                                        double populationMean22 = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter Population Standard Deviation: ");
                                                        double populationStandardDeviation22 = scanner.nextDouble();
                                                        cls.cls();
                                                        System.out.println("Enter Sample Size: ");
                                                        int size22 = scanner.nextInt();
                                                        cls.cls();
                                                        scanner.nextLine(); // Consume newline character
                                                        System.out.println("Enter Significance Level in %: ");
                                                        String sLevel22 = scanner.nextLine();
                                                        double[] data222 = new double[size22];
                                                        HypothesisTesting hypo22 = new HypothesisTesting(data222,
                                                                populationMean22,
                                                                nullHypothesis22,
                                                                populationStandardDeviation22, size22);
                                                        double zScore22 = hypo22.zTest();
                                                        // double pValue;
                                                        Mfunction m24 = new Mfunction();
                                                        cls.cls();
                                                        if (tTabel[size22 - 2][table.column(sLevel22) + 1] < Math
                                                                .abs(zScore22)) {
                                                            if (zScore22 > 0) {
                                                                pValue = 2 * (1 - m24.hypo_CDF(zScore22));
                                                            } else {
                                                                pValue = 2 * m24.hypo_CDF(zScore22);
                                                            }

                                                            System.out.println("P-value: " + pValue);
                                                            System.out.println("Fail to reject Null Hypothesis.");

                                                        } else {
                                                            if (zScore22 > 0) {
                                                                pValue = 2 * (1 - m24.hypo_CDF(zScore22));
                                                            } else {
                                                                pValue = 2 * m24.hypo_CDF(zScore22);
                                                            }

                                                            System.out.println("P-value: " + pValue);
                                                            System.out.println("Reject Null Hypothesis");
                                                        }
                                                        goBack();
                                                        break;
                                                    case 3:
                                                        backToHypo2 = true;
                                                        break;

                                                    default:
                                                        System.out.println("Invalid Choice!!");
                                                        goBack();
                                                        break;
                                                }
                                            }

                                            break;
                                        case 3:
                                            backToHypothesis2 = true;
                                            break;
                                    }
                                }
                                // goBack();
                                break;
                            // break;
                            case 3:
                                table.displayTable(tTabel);
                                goBack();
                                break;
                            case 4:
                                backToMain = true;
                                break;
                            default:
                                System.out.println("Invalid Choice!!!");
                                goBack();
                                break;

                        }
                    }
                    break;
                case 3:
                    // Display ANOVA menu
                    String fTableFile = "E:\\.Programming\\STAT HUB\\src\\f_table.txt"; // F- table file location

                    F_Table table2 = new F_Table();
                    double[][] fTabel = table2.readTable(fTableFile);
                    backToMain = false;
                    while (!backToMain) {
                        cls.cls();
                        System.out.println("ANOVA");
                        System.out.println("1. One Way");
                        System.out.println("2. Two Way");
                        System.out.println("3. Display F-Table");
                        System.out.println("4. Back to main menu");
                        // Read user input for descriptive stat menu
                        System.out.println("Enter Choice: ");

                        int anovaChoice = scanner.nextInt();
                        cls.cls();
                        switch (anovaChoice) {
                            case 1:// one way
                                System.out.println("Enter Table Row size: ");
                                int nr = scanner.nextInt();
                                cls.cls();
                                System.out.println("Enter Table Column Size: ");
                                int m = scanner.nextInt();
                                cls.cls();
                                double[][] array2d = new double[nr][m];
                                System.out.println("Enter the table: ");
                                array2d = cls.arrayInput(nr, m);
                                cls.cls();
                                ANOVA anova = new ANOVA(array2d, nr, m);
                                double oneTS = anova.oneWay();
                                Mfunction am1 = new Mfunction();
                                double F_pValue = 1 - am1.F_dis_CDF(oneTS, m - 1, nr * m - m);

                                // ANOVA Table
                                System.out.println("ANOVA");
                                System.out.println(
                                        "+-----------------------+--------+------------+----------------+----------+");
                                System.out.println(
                                        "| Source of Variation   |   SS   |     df     |       F        |  F crit  |");
                                System.out.println(
                                        "+-----------------------+--------+------------+----------------+----------+");
                                System.out.println(String.format("| %-21s | %-6.2f | %-10d | %-14.8f | %-8.3f|",
                                        "Between Groups", anova.ssb(), m - 1, oneTS, fTabel[nr * m - m - 1][m - 2]));
                                System.out.println(String.format("| %-21s | %-6.2f | %-10d |", "Within Groups",
                                        anova.ssw(), nr * m - m));
                                System.out.println(
                                        String.format("| %-21s | %-6.2f | %-10d |", "Total", anova.sst(), m * nr - 1));
                                System.out.println(
                                        "+-----------------------+--------+------------+----------------+----------+");
                                System.out.println();
                                System.out.println("P-value: " + F_pValue);
                                // Output based on the condition
                                String hypothesisResult = (fTabel[nr * m - m - 1][m - 2] > oneTS)
                                        ? "Fail to reject Null Hypothesis."
                                        : "Reject Null Hypothesis.";
                                System.out.println(hypothesisResult);

                                goBack();
                                break;
                            case 2:// two way
                                   // System.out.println("Coming soon....");
                                   // System.out.println();
                                   // System.out.println("Wait for the next update!");
                                System.out.println("Enter Table Row size: ");
                                int nrr = scanner.nextInt();
                                cls.cls();
                                System.out.println("Enter Table Column Size: ");
                                int mm = scanner.nextInt();
                                cls.cls();
                                double[][] array2D = new double[nrr][mm];
                                System.out.println("Enter the table: ");
                                array2D = cls.arrayInput(nrr, mm);
                                cls.cls();
                                TwoWayWithoutReplication anova2 = new TwoWayWithoutReplication(array2D, nrr, mm);
                                double twoTSalpha = anova2.twoWayAlpha();
                                double twoTSbeta = anova2.twoWayBeta();
                                double fAlpha = anova2.ssr() / (nrr - 1);
                                double fBeta = anova2.ssc() / (mm - 1);
                                double fError = anova2.sse() / ((nrr - 1) * (mm - 1));
                                // F-values
                                double fValueAlpha = fAlpha / fError;
                                double fValueBeta = fBeta / fError;
                                // p-value
                                Mfunction am2 = new Mfunction();
                                double F_pValueAlpha = 1 - am2.F_dis_CDF(fValueAlpha, nrr - 1, (nrr - 1) * (mm - 1));
                                double F_pValueBeta = 1 - am2.F_dis_CDF(fValueBeta, mm - 1, (nrr - 1) * (mm - 1));

                                // Two way without RepliacationANOVA Table
                                System.out.println("Two way ANOVA Without Replication");
                                System.out.println(
                                        "+-----------------------+--------+------------+----------------+----------------+");
                                System.out.println(
                                        "| Source of Variation   |   SS   |     df     |       F        |     F crit     |");
                                System.out.println(
                                        "+-----------------------+--------+------------+----------------+----------------+");
                                System.out.println(String.format("| %-21s | %-6.2f | %-10d | %-14.8f | %-14.8f |",
                                        "Rows", anova2.ssr(), nrr - 1, fValueAlpha,
                                        fTabel[(nrr - 1) * (mm - 1) - 1][nrr - 2]));
                                System.out.println(String.format("| %-21s | %-6.2f | %-10d | %-14.8f | %-14.8f |",
                                        "Columns", anova2.ssc(), mm - 1, fValueBeta,
                                        fTabel[(nrr - 1) * (mm - 1) - 1][mm - 2]));
                                System.out.println(String.format("| %-21s | %-6.2f | %-10d |", "Error", anova2.sse(),
                                        (nrr - 1) * (mm - 1)));
                                System.out.println(String.format("| %-21s | %-6.2f | %-10d |", "Total", anova2.sst(),
                                        nrr * mm - 1));
                                System.out.println(
                                        "+-----------------------+--------+------------+----------------+----------------+");

                                String tAlpha = (fValueAlpha > fTabel[(nrr - 1) * (mm - 1) - 1][nrr - 2])
                                        ? "Reject Null Hypothesis for all alpha [row]."
                                        : "Fail to reject Null Hypothesis for all alpha [row].";
                                String tBeta = (fValueBeta > fTabel[(nrr - 1) * (mm - 1) - 1][mm - 2])
                                        ? "Reject Null Hypothesis for all beta [column]."
                                        : "Fail to reject Null Hypothesis for all beta [column].";
                                System.out.println();
                                System.out.println(tAlpha);
                                System.out.println("P-value(Alpha): " + F_pValueAlpha);
                                System.out.println();
                                System.out.println();
                                System.out.println(tBeta);
                                System.out.println("P-value(Beta): " + F_pValueBeta);

                                goBack();
                                break;
                            case 3:// display f-table
                                cls.cls();
                                table2.displayTable(fTabel);
                                goBack();
                                break;
                            case 4:
                                backToMain = true;
                                break;

                            default:
                                System.out.println("Invalid Choice!!");
                                goBack();
                                break;
                        }
                    }
                    break;
                case 4: // Chi-Square
                    // Chi-Square submenu logic
                    String chisqrTableFile = "E:\\.Programming\\STAT HUB\\src\\chisqr_table.txt"; // Chisqr- table file
                                                                                                  // location
                    Mfunction chisqrCDF = new Mfunction();
                    Chisqr_Table chisqrTable = new Chisqr_Table();
                    double[][] chiTable = chisqrTable.readTable(chisqrTableFile);
                    backToMain = false;
                    while (!backToMain) {
                        cls.cls(); // Clear screen
                        System.out.println("Chi-Square Menu");
                        System.out.println("1. Test of Independence");
                        System.out.println("2. Goodness-of-Fit");
                        System.out.println("3. Display Chi-Sqr Table");
                        System.out.println("4. Back to main menu");
                        System.out.println("Enter Choice: ");

                        int chiSquareChoice = scanner.nextInt(); // User input
                        cls.cls();

                        switch (chiSquareChoice) {
                            case 1: // Chi-Square Test of Independence
                                // Input table dimensions
                                System.out.print("Enter number of rows: ");
                                int rows = scanner.nextInt();
                                cls.cls();

                                System.out.print("Enter number of columns: ");
                                int cols = scanner.nextInt();
                                cls.cls();

                                double[][] observed = new double[rows][cols];

                                scanner.nextLine(); // Consume newline character
                                System.out.println("Enter the Significance Level in % : ");
                                String chisLevel = scanner.nextLine();
                                cls.cls();
                                // Input observed frequencies
                                System.out.println("Enter the observed frequencies Table: ");
                                for (int i = 0; i < rows; i++) {
                                    for (int j = 0; j < cols; j++) {
                                        observed[i][j] = scanner.nextDouble();
                                    }
                                }
                                cls.cls();

                                // Calculate totals
                                int[] totalRows = new int[rows];
                                int[] totalCols = new int[cols];
                                int grandTotal = 0;

                                for (int i = 0; i < rows; i++) {
                                    for (int j = 0; j < cols; j++) {
                                        totalRows[i] += observed[i][j];
                                        totalCols[j] += observed[i][j];
                                        grandTotal += observed[i][j];
                                    }
                                }

                                ChiSquare independenChiSquare = new ChiSquare();

                                // Calculate expected frequencies
                                double[][] expected = independenChiSquare.calculateExpected(observed, totalRows,
                                        totalCols, grandTotal);

                                double chiSquareValue = independenChiSquare.testOfIndependence(observed, expected);
                                cls.cls();

                                // Degrees of freedom
                                int df = (rows - 1) * (cols - 1);

                                if (df <= 0 || df >= chiTable.length) {
                                    System.out.println("Invalid degrees of freedom: " + df);
                                    goBack();
                                    break;
                                }

                                int colIndex = chisqrTable.column(chisLevel);

                                if (colIndex == -1 || colIndex >= chiTable[0].length) {
                                    System.out.println("Invalid significance level: " + chisLevel);
                                    goBack();
                                    break;
                                }

                                System.out.println("Chi-Square Value: " + chiSquareValue);

                                double criticalValue = chiTable[df - 1][colIndex];
                                if (criticalValue > chiSquareValue) {
                                    System.out.println("P-value: " + (1 - chisqrCDF.chisqr_CDF(chiSquareValue, df)));
                                    System.out.println("Critical Value: " + criticalValue);
                                    System.out.println("Fail to reject Null Hypothesis.");
                                } else {
                                    System.out.println("P-value: " + (1 - chisqrCDF.chisqr_CDF(chiSquareValue, df)));
                                    System.out.println("Critical Value: " + criticalValue);
                                    System.out.println("Reject Null Hypothesis");
                                }

                                goBack();
                                break;

                            case 2: // Goodness-of-Fit
                                // System.out.println("Goodness of Fit");
                                System.out.print("Enter the number of categories: ");
                                int numCategories = scanner.nextInt();
                                double[] observedGOF = new double[numCategories];
                                double[] expectedGOF = new double[numCategories];
                                cls.cls();
                                scanner.nextLine(); // Consume newline character
                                System.out.println("Enter the observed frequencies:");
                                for (int i = 0; i < numCategories; i++) {
                                    // System.out.print("Observed[" + (i + 1) + "]: ");
                                    observedGOF[i] = scanner.nextDouble();
                                }
                                cls.cls();
                                double grandTotalGOF = 0.0;// calculate grand total
                                for (int i = 0; i < observedGOF.length; i++) {
                                    grandTotalGOF += observedGOF[i];
                                }
                                System.out.println("Select the method for expected values:");
                                System.out.println("1. Know expected values");
                                System.out.println("2. Know proportions or probability");
                                System.out.println("3. All proportions are equal");
                                System.out.println("4. Calculate expected values using Poisson distribution");
                                System.out.println();
                                System.out.println("Enter Choice:");
                                int methodChoice = scanner.nextInt();
                                cls.cls();

                                ChiSquare chiSquare = new ChiSquare();
                                double chisqrValue;

                                switch (methodChoice) {
                                    case 1: // Known expected values
                                        System.out.println("Enter the expected values:");
                                        for (int i = 0; i < numCategories; i++) {
                                            // System.out.print("Expected[" + (i + 1) + "]: ");
                                            expectedGOF[i] = scanner.nextDouble();
                                        }
                                        chisqrValue = chiSquare.testOfGoodnessOfFit(observedGOF, expectedGOF);
                                        break;

                                    case 2: // Known proportions
                                        // System.out.println("Enter the total count:");
                                        // double total = scanner.nextDouble();
                                        System.out.println("Enter the proportions (space-separated):");
                                        double[] proportions = new double[numCategories];
                                        for (int i = 0; i < numCategories; i++) {
                                            // System.out.print("Proportion[" + (i + 1) + "]: ");
                                            proportions[i] = scanner.nextDouble();
                                        }
                                        expectedGOF = chiSquare.calculateExpectedFromProportions(observedGOF,
                                                grandTotalGOF,
                                                proportions);
                                        chisqrValue = chiSquare.testOfGoodnessOfFit(observedGOF, expectedGOF);
                                        break;

                                    case 3: // All proportions are equal
                                        expectedGOF = chiSquare.calculateExpectedEqualProportions(observedGOF);
                                        chisqrValue = chiSquare.testOfGoodnessOfFit(observedGOF, expectedGOF);
                                        break;

                                    case 4: // Using Poisson distribution
                                        System.out.println("Enter the mean (lambda) for Poisson distribution:");
                                        double lambda = scanner.nextDouble();
                                        expectedGOF = chiSquare.calculateExpectedFromPoisson(observedGOF, lambda,
                                                grandTotalGOF);
                                        chisqrValue = chiSquare.testOfGoodnessOfFit(observedGOF, expectedGOF);
                                        break;

                                    default:
                                        System.out.println("Invalid option selected.");
                                        continue;
                                }
                                cls.cls();
                                scanner.nextLine(); // Consume newline character
                                System.out.println("Enter the Significance Level in % : ");
                                String chisLevel2 = scanner.nextLine();
                                // cls.cls();
                                cls.cls();
                                // Degrees of freedom
                                int dfGoodness = numCategories - 1;

                                int colIndexGoodness = chisqrTable.column(chisLevel2);

                                if (colIndexGoodness == -1 || colIndexGoodness >= chiTable[0].length) {
                                    System.out.println("Invalid significance level: " + chisLevel2);
                                    goBack();
                                    break;
                                }
                                System.out.println("Chi-Square Value: " + chisqrValue);

                                double criticalValueGoodness = chiTable[dfGoodness][colIndexGoodness];
                                if (criticalValueGoodness > chisqrValue) {
                                    System.out
                                            .println("P-value: " + (1 - chisqrCDF.chisqr_CDF(chisqrValue, dfGoodness)));
                                    System.out.println("Critical Value: " + criticalValueGoodness);
                                    System.out.println("Fail to reject Null Hypothesis.");
                                } else {
                                    System.out
                                            .println("P-value: " + (1 - chisqrCDF.chisqr_CDF(chisqrValue, dfGoodness)));
                                    System.out.println("Critical Value: " + criticalValueGoodness);
                                    System.out.println("Reject Null Hypothesis.");
                                }
                                goBack();
                                break;
                            case 3:// display chisqr-table
                                cls.cls();
                                chisqrTable.displayTable(chiTable);
                                goBack();
                                break;
                            case 4: // Back to main menu
                                backToMain = true;
                                break;

                            default:
                                System.out.println("Invalid Choice!!");
                                goBack();
                                break;
                        }
                    }
                    break;

                case 5: // Regression Analysis
                    backToMain = false;
                    while (!backToMain) {
                        cls.cls(); // Clear screen
                        System.out.println("Regression Analysis Menu");
                        System.out.println("1. Linear Regression");
                        System.out.println("2. Polynomial Regression");
                        System.out.println("3. Back to main menu");
                        System.out.println("Enter Choice: ");

                        int regressionChoice = scanner.nextInt();
                        cls.cls();

                        switch (regressionChoice) {
                            case 1: // Linear Regression
                                boolean backToLinear = false;
                                while (!backToLinear) {
                                    cls.cls();
                                    System.out.println("Linear Regression Menu");
                                    System.out.println("1. Simple Linear Regression");
                                    System.out.println("2. Multiple Linear Regression");
                                    System.out.println("3. Back to Regression Analysis Menu");
                                    System.out.println("Enter Choice: ");

                                    int linearChoice = scanner.nextInt();
                                    cls.cls();

                                    switch (linearChoice) {
                                        case 1:
                                            System.out.println("Enter the number of data points: ");
                                            int nSLR = scanner.nextInt();
                                            cls.cls();
                                            double[][] tableSLR = new double[nSLR][2];

                                            System.out.println("Enter the data points tableSLR (x y):");
                                            for (int i = 0; i < nSLR; i++) {
                                                // System.out.printf("Data Point %d: ", i + 1);
                                                tableSLR[i][0] = scanner.nextDouble(); // x
                                                tableSLR[i][1] = scanner.nextDouble(); // y
                                            }
                                            cls.cls();
                                            SimpleLinearRegression slr = new SimpleLinearRegression(tableSLR);
                                            slr.displayResults();
                                            goBack();
                                            break;

                                        case 2: // Multiple Linear Regression
                                            System.out.println("Performing Multiple Linear Regression...");
                                            // Add logic for data input and calculation
                                            break;

                                        case 3: // Back to Regression Analysis Menu
                                            backToLinear = true;
                                            break;

                                        default:
                                            System.out.println("Invalid choice. Try again.");
                                    }
                                }
                                break;

                            case 2: // Polynomial Regression
                                System.out.println("Performing Polynomial Regression...");
                                // Add logic for data input and calculation
                                break;

                            case 3: // Back to Main Menu
                                backToMain = true;
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 6:// credits
                    creditsGraphics.art();
                    goBack();
                    cls.cls();
                    break;
                case 0:
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
