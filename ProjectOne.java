import javax.swing.*;
import java.util.Scanner;

public class ProjectOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Initialize high and low scores.
        double highestPScore = 0;
        double lowestPScore = 0;


        // Collects number of computer fo which to input information
        int numberOfComputers = 0;
        while (numberOfComputers <= 0) {
            System.out.print("How many computers will you enter information for? ");
            numberOfComputers = scan.nextInt();
        }

        // Prints title of program.
        displayTitle();


        // Gather user input and output recommended settings.
        for (int i = 0; i < numberOfComputers; i++) {
            int gpuClockSpeed = 0;
            int cpuClockSpeed = 0;
            int cpuCores = 0;

            // Collects Computer information
            while (!(gpuClockSpeed > 800 && gpuClockSpeed < 2000)) {
                System.out.print("What is the clock speed of your GPU in MHz? ");
                gpuClockSpeed = scan.nextInt();
            }
            while (!(cpuClockSpeed > 1000 && cpuClockSpeed < 5500)) {
                System.out.print("What is the clock speed of your CPU in MHz? ");
                cpuClockSpeed = scan.nextInt();
            }
            while (!(cpuCores > 1 && cpuCores <= 16)) {
                System.out.print("How many core CPU? ");
                cpuCores = scan.nextInt();
            }

            // Collect screen resolution.
            String resolutionInput = JOptionPane.showInputDialog(null, "Screen Resolution:\n" +
                    "\t\t 1. 1280 x 720\n" +
                    "\t\t 2. 1920 x 1080\n" +
                    "\t\t 3. 2560 x 1440\n" +
                    "\t\t 4. 3840 x 2160");
            int resolutionValue = Integer.parseInt(resolutionInput);
            String resolution = getResolutionString(resolutionValue);


            // Calculation of performance score
            double multiplier = getMultiplierValue(resolutionValue);
            double performanceScore = calculatePerformanceScore(gpuClockSpeed, cpuClockSpeed, cpuCores, multiplier);
            String graphicSetting = getRecommendedQuality(performanceScore);


            // Output of  results
            displayInformation(gpuClockSpeed, cpuClockSpeed, cpuCores, resolution, performanceScore, graphicSetting);

            // Determine highest and lowest performance scores.
            if (i == 1) {
                highestPScore = performanceScore;
                lowestPScore = performanceScore;
            } else {
                if (performanceScore > highestPScore)
                    highestPScore = performanceScore;
                else if (performanceScore < lowestPScore)
                    lowestPScore = performanceScore;
                else
                    continue;
            }
        }
        System.out.println("\n");
        System.out.printf("The highest performance score was: %,.3f", highestPScore);
        System.out.print("\n");
        System.out.printf("The lowest performance score was: %,.3f", lowestPScore);

    }

    private static void displayTitle() {
        // Prints title of program.
        String title = "Computer Hardware Graphics Quality Recommendation Tool";
        System.out.println("\n");
        System.out.println(title);
        System.out.println("\n");
    }

    private static String getResolutionString(int value) {
        // Stores resolution as a string.
        String[] resolution = {"1280 x 720", "1920 x 1080", "2560 x 1440", "3840 x 2160"};
        return resolution[value];
    }

    private static double getMultiplierValue(int value) {
        double[] multiplier = {0, 1, .75, .55, .35};
        return multiplier[value];
    }

    private static double calculatePerformanceScore(int gpuClockSpeed, int cpuClockSpeed, int cpuCores, double multiplier) {
        // Calculation of performance score
        double performanceScore;
        performanceScore = ((5 * gpuClockSpeed) + (cpuCores * cpuClockSpeed))
                * multiplier;
        return performanceScore;
    }

    private static String getRecommendedQuality(double performanceScore) {
        // Determine graphic setting recommendation based on performance score.
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
        return  graphicSetting;
    }

    private static void displayInformation(int gpuClockSpeed, int cpuClockSpeed, int cpuCores, String resolution, double performanceScore, String graphicSetting) {
        // Output of  results
        System.out.println("\n");
        System.out.println(String.format("GPU Clock Speed:\t\t %sMHz", gpuClockSpeed));
        System.out.println(String.format("CPU Clock Speed:\t\t %sMHz", cpuClockSpeed));
        System.out.println(String.format("Number of cores:\t\t %s", cpuCores));
        System.out.println(String.format("Monitor Resolution:\t\t %s", resolution));
        System.out.println(String.format("Performance Score:\t\t %,.3f", performanceScore));
        System.out.println(String.format("Recommended Settings:\t %s", graphicSetting));
        System.out.println("\n");
    }
}
