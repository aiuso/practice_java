import java.util.Scanner;

public class Exam1Iuso {

    public static void main(String[] args) {

        // Scanner Class for User Input
        Scanner scan = new Scanner(System.in);


        // String Variables
        final String RISK_ASSESSMENT_TEXT = "COVID-19 Risk Assessment Utility";
        final String CANNOT_RETURN_TO_WORK = "Based on your current risk tier, " +
                "it is not possible for you to return to work in person." +
                "\n\nPlease remind all employees to guard again COVID-19 spread by following all CDC guidelines.";
        final String RETURN_TO_WORK = "Based on your current risk tier, " +
                "it is possible for you to return to work in person. " +
                "\n\nEmployees returning to work in person are required to submit to a " +
                "temperature check before being allowed to enter the workplace. " +
                "\nEmployees must wear masks at all times, remain at least 6 feet apart, and wash their hands frequently.";
        String divider = "________________________________________";
        String county, riskTier;
        String returnToWorkMessage = CANNOT_RETURN_TO_WORK;


        // Integer Variables
        final int HUNDRED_THOUSAND = 100_000;
        final int HIGH_RISK = 200;
        final int LOW_RISK = 100;
        int cases, population, casesPerPopulation;


        // Display Menu - Gathering User Input for Survey
        System.out.println(divider);
        System.out.println("Welcome to the State Government COVID-19 Survey \n");
        System.out.print("In which county do you currently reside? ");
        county = scan.nextLine();
        System.out.println("\nFor the next questions, please exclude any commas.");
        System.out.print("How many COVID-19 cases has there been in the past 14 days? ");
        cases = scan.nextInt();
        System.out.printf("What is the population of %s: ", county);
        population = scan.nextInt();
        System.out.println("\nThank you for completing the survery. Have a great day.");
        System.out.println(divider + "\n\n");


        // Evaluating Risk Assessment - Cases per 100K
        casesPerPopulation = ((cases * HUNDRED_THOUSAND) / population);

        if (casesPerPopulation > HIGH_RISK) {
            riskTier = "Red";
        } else if (casesPerPopulation > LOW_RISK && casesPerPopulation <= HIGH_RISK) {
            riskTier = "Orange";
        } else {
            riskTier = "Yellow";
            returnToWorkMessage = RETURN_TO_WORK;
        }


        // Formatting Output for Console
        System.out.println(divider);
        System.out.println(RISK_ASSESSMENT_TEXT + "\n");
        System.out.printf("County: %s " +
                "\nCases per 100,000 Residents (last 14 days): %,d " +
                "\nRisk Tier: %s \n\n",
                county, casesPerPopulation, riskTier);
        System.out.println(returnToWorkMessage);
        System.out.println(divider);

    }

}
