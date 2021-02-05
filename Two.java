import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Two {

    public static void predictTheOutput() {
        System.out.println("Predict the Output\n");
        System.out.println("___________\n\n");


        // QUESTION 1 #################################
        System.out.println("Question 1: What happends to value of variables that have been assigned and reassigned?\n");

        // Prompt
        int freeze = 32, boil = 212;
        freeze = 0;
        boil = 100;
        System.out.println(freeze + "\n" + boil + "\n");

        //Rationale
        System.out.println("Explaination: Initial assignments of variables freeze, boil (32; 212) were overwritten" +
                " by reassignments (0; 100).\n\n");
        System.out.println("___________\n\n");
        // ###########################################


        // QUESTION 2 #################################
        System.out.println("Question 2: What happends to value of variables that have been assigned and reassigned?\n");

        // Prompt
        int x = 0, y = 2;
        x = y * 4;
        System.out.println(x + "\n" + y + "\n");

        //Rationale
        System.out.println("Explaination: Initial assignment of variable 'x' (0) was overwritten" +
                " by reassignment (2*4).\n\n");
        System.out.println("___________\n\n");
        // ###########################################


        // QUESTION 3 #################################
        System.out.println("Question 3: What is the difference between .print(), .println() and \\n?\n");

        // Prompt
        System.out.print("I am the incredible");
        System.out.print("computing\nmachine");
        System.out.print("\nand I will\namaze\n)"); // Error, misplacement of ) before string closure. Added ) after.
        System.out.println("you.");

        //Rationale
        System.out.println("\nExplaination: .println() outputs a new line following passed argument;" +
                " .print() does not;" +
                " \\n adds new line.\n\n");
        System.out.println("___________\n\n");
        // ###########################################


        // QUESTION 4 #################################
        System.out.println("Question 4: What is the difference between .print(), .println() and \\n?\n");

        // Prompt
        System.out.print("Be careful\n)"); // Error, misplacement of ) before string closure. Added ) after.
        System.out.print("This might/n be a trick ");
        System.out.println("question.");

        //Rationale
        System.out.println("\nExplaination: .println() outputs a new line following passed argument;" +
                " .print() does not;" +
                " \\n adds new line.\n\n");
        System.out.println("___________\n\n");
        // ###########################################


        // QUESTION 5 #################################
        System.out.println("Question 5: Modulo operator.\n");

        // Prompt
        int a, b = 23;
        a = b % 2;
        System.out.println(b + "\n" + a);

        //Rationale
        System.out.println("\nExplaination: Modulo (%) yeilds reminder of division 23/2.\n\n");
        System.out.println("___________\n\n");
        // ###########################################

    }

    public static void stringManipulator(String city) {

        int strLength = city.length();
        String upper = city.toUpperCase();
        String lower = city.toLowerCase();
        char firstLetter = city.charAt(0);

        System.out.println(String.format("" +
                "This city has %s characters.\n" +
                "Uppercase: %s\n" +
                "Lowercase: %s\n" +
                "The first letter of %s is %s",
                strLength, upper, lower, city, firstLetter));
    }

    public static void resturantBill(double mealCost, double salesTax, double tipPercent) {

        double tax = mealCost * salesTax;           // 6.75% tax.
        double tip = (mealCost + tax) * tipPercent;   // 20% tip.
        double total = mealCost + tax + tip;

        NumberFormat dollars = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println(String.format("" +
                "Meal: \t%s \n" +
                "Tax: \t%s \n" +
                "Tip: \t%s \n" +
                "Total: \t%s" +
                "", dollars.format(mealCost), dollars.format(tax), dollars.format(tip), dollars.format(total)));

    }


    public static void  stockTransaction() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Number of shares purchased?");
        int sharesPurchased = scan.nextInt();
        System.out.println("Purchase price per share?");
        double purchasePrice = scan.nextDouble();
        System.out.println("Number of shares to sell?");
        int sharesSold = scan.nextInt();
        System.out.println("Sale price per share?");
        double sellPrice = scan.nextDouble();
        System.out.println("Broker Commission?");
        double commissionPercent = scan.nextDouble();;

        double costOfPurchase = sharesPurchased * purchasePrice;
        double costOfSale = sharesSold * sellPrice;
        double commissionPurchase = costOfPurchase * commissionPercent;
        double commissionSale = costOfSale * commissionPercent;
        double netProfit = (costOfSale) - costOfPurchase - commissionPurchase - commissionSale;

        NumberFormat dollars = NumberFormat.getCurrencyInstance(Locale.US);

        System.out.println(String.format("\n" +
                "Purchase Price: \t\t%s \n" +
                "Commission (Purchase): \t%s \n\n" +
                "Sell Price: \t\t%s \n" +
                "Commission (Sale): \t%s\n\n" +
                "Net Profit: \t\t%s",
                dollars.format(costOfPurchase), dollars.format(commissionPurchase),
                dollars.format(costOfSale), dollars.format(commissionSale),
                dollars.format(netProfit)));
    }
}
