import javax.swing.*;
import java.io.PrintWriter;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Four {

    public static void sumOfNumbers() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a number. This code will sum all numbers" +
                " from 1 to the number you entered.");

        int input = scan.nextInt();
        int i = 1;
        int sum = 0;

        while (i <= input) {
            sum += i;
            i++;
        }

        System.out.println(sum);
    }

    public static void distanceTraveled() {
        String filename = JOptionPane.showInputDialog("Enter filename");
        //PrintWriter document = new PrintWriter(filename);


        System.out.println("This function will take " +
                "speed (MPH) and time traveled and " +
                "determine distance traveled for each hour travel.");
        int speed = 0;
        int time = 0;
        int distance = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Speed in MPH?");

        // Input validation
        while (true) {
            try {
                speed = scan.nextInt();

                if (speed > 0 ) {
                    System.out.println("How many hours were traveled?");
                    time = scan.nextInt();
                    break;

                } else {
                    System.out.println("Speed must be positive value");
                    distanceTraveled();
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                distanceTraveled();
            }
        }

        // Output
        System.out.println("Hour \tDistance Traveled \n" +
                "-------------------------");
        for (int hour = 1; hour <= time; hour++) {
            distance += (speed * hour);
            System.out.println(hour + "\t\t" + distance + " miles");
        }
    }

    public static void writeDistanceToFile() {
        distanceTraveled();
    }
}
