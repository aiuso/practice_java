import java.util.Scanner;

public class Exam2Iuso {

    public static void main(String[] args) {
        // Scanner Class for User Input
        Scanner scan = new Scanner(System.in);

        //Constant Declaration.
        final double COST_OF_MASK = 0.25;
        final double COST_OF_FACESHIELD = 4.99;
        final double COST_OF_GLOVES = 0.15;
        final double COST_OF_N95 = 1.49;
        final double DISCOUNT_10PERCENT = 0.9;
        final double DISCOUNT_20PERCENT = 0.8;

        //Variable Declaration
        boolean placingOrder = true;
        double totalCost = 0;


        //Program. Loop until user exit.
        while (placingOrder) {
            //Variables for User Input. Clear with each iteration.
            int item = 0;
            int quantity = 0;
            double totalForItem = 0;
            String yesOrNo;


            //Display Menu & Gather User Input (item to order and number of units).
            System.out.println("What type of PPE do you need to purchase?");
            System.out.println( "\t" + "1. Mask" + "\n" +
                    "\t" + "2. Face Shield" + "\n" +
                    "\t" + "3. Glove" + "\n" +
                    "\t" + "4. N95 Respirator" + "");

            while (item < 1 || item > 4) {
                System.out.print("Please select the type of PPE from the menu: ");
                item = scan.nextInt();
            }

            while (quantity < 100) {
                System.out.print("How many units do you wish to purchase? ");
                quantity = scan.nextInt();
            }


            //Calculate total cost of unit and Add to running total.
            if (item == 1)
                totalForItem = quantity * COST_OF_MASK;
            else if (item == 2)
                totalForItem = quantity * COST_OF_FACESHIELD;
            else if (item == 3)
                totalForItem = quantity * COST_OF_GLOVES;
            else if (item == 4)
                totalForItem = quantity * COST_OF_N95;

            if (quantity >= 1000 && quantity <= 4000)
                totalForItem *= DISCOUNT_10PERCENT;
            else if (quantity > 4000)
                totalForItem *= DISCOUNT_20PERCENT;

            //Add Item cost to total.
            totalCost += totalForItem;
            //Display cost of item.
            System.out.printf("The cost of the purchase is: $%,.2f" + "\n", totalForItem);


            //Prompt to Purchase another item - Validate string input.
            while (true) {
                System.out.print("Do you wish to purchase another type of PPE (Y/N)? ");
                yesOrNo = scan.next();
                System.out.println("");

                if (yesOrNo.equalsIgnoreCase("y"))
                    break;
                else if (yesOrNo.equalsIgnoreCase("n")) {
                    placingOrder = false;
                    break;
                }
                else
                    continue;
            }
        }
        System.out.printf("The total cost of all PPE purchases is: $%,.2f", totalCost);
    }
}
