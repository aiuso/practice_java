import javax.swing.*;
import java.util.Scanner;

public class ProjectOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfComputers = 0;
        String title = "Computer Hardware Graphics Quality Recommendation Tool";

        // Collects number of computer fo which to input information
        while (numberOfComputers <= 0) {
            System.out.println("How many computers will you enter information for?");
            numberOfComputers = scan.nextInt();
        }

        // Prints title of program.
        System.out.println("\n" + title + "\n");


        // Gather user input and output recommended settings.
        for (int i = 0; i <= numberOfComputers; i++) {
            // Collects Computer information
            System.out.println("What is the clock speed of your GPU in MHz?");
            int gpuClockSpeed = scan.nextInt();
            System.out.println("What is the clock speed of your CPU in MHz?");
            int cpuClockSpeed = scan.nextInt();
            System.out.println("How many core CPU?");
            int cpuCores = scan.nextInt();

            String resolution;
            resolution = JOptionPane.showInputDialog(null, "Screen Resolution:\n" +
                    "\t\t 1. 1280 x 720\n" +
                    "\t\t 2. 1920 x 1080\n" +
                    "\t\t 3. 2560 x 1440\n" +
                    "\t\t 4. 3840 x 2160");

            // Calculation of performance score
            double[] multipler = {0, 1, .75, .55, .35};
            double performanceScore;
            performanceScore = ((5 * gpuClockSpeed) + (cpuCores * cpuClockSpeed)) * multipler[Integer.parseInt(resolution)];
            String graphicSetting;

            if (performanceScore > 17_000)
                graphicSetting = "Ultra";
            else if (performanceScore > 15_000 && performanceScore <= 17_000)
                graphicSetting = "High";
            else if (performanceScore > 13_000 && performanceScore <= 15_000)
                graphicSetting = "Medium";
            else if (performanceScore > 11_000 && performanceScore <= 13_000)
                graphicSetting = "Low";
            else
                graphicSetting = "Unable to Play";

            // Output of  results
            System.out.println(String.format("GPU Clock Speed:\t %sMHz", gpuClockSpeed));
            System.out.println(String.format("CPU Clock Speed:\t %sMHz", cpuClockSpeed));
            System.out.println(String.format("Number of cores:\t %s", cpuCores));
            System.out.println(String.format("Performance Score:\t %s", performanceScore));
            System.out.println(String.format("Recommended Settings:\t %s", graphicSetting));
        }
    }
}
