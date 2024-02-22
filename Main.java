import java.util.Scanner;
import stat_hub.DescriptiveStat;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        double[] data = new double[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextDouble();
        }

        DescriptiveStat descriptiveStat = new DescriptiveStat(data);

        System.out.println("Choose the operation:");
        System.out.println("1. Mean");
        System.out.println("2. Median");
        System.out.println("3. Mode");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Mean: " + descriptiveStat.mean());
                break;
            case 2:
                System.out.println("Median: " + descriptiveStat.median());
                break;
            case 3:
                System.out.println("Mode: " + descriptiveStat.mode());
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}
