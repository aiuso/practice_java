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
}
