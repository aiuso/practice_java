/*

 In some older homes that do not have a central heating and air conditioning system,
 smaller air conditioning units made to fit inside of a window and cool a single room
 are used as an alternative way to cool the home.

 Depending on the size of the room and the amount of shade that the room has,
 different sizes of air conditioning units must be used in order to be able to properly cool the room.
 The unit of measure for the amount of cooling that an air conditioner unit can provide is the
 BTU (British Thermal Unit) per hour.

 Code a program that will calculate the correct size of air conditioner for a specific room size.

 */


import java.util.Scanner;

public class PhaseOne {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String shadeDescription = "";
        double btu;


        // BTUs/hour Required to Different Room Sizes
        final int BTU_SMALL_ROOM = 5500;
        final int BTU_MEDIUM_ROOM = 10000;
        final int BTU_LARGE_ROOM = 17500;
        final int BTU_VERY_LARGE_ROOM = 24000;

        final double LIGHT_SHADE_ADJUSTMENT = .15;
        final double ABUNDANT_SHADE_ADJUSTMENT = .10;


        // Acquire Room Dimensions & Amount of Shade
        System.out.print("Enter length of the room in feet: ");
        double length = scan.nextDouble();
        System.out.print("Enter width of the room in feet: ");
        double width = scan.nextDouble();
        System.out.print("How much shade does the room get?\n" +
                "\t 1. Little Shade\n" +
                "\t 2. Moderate Shade\n" +
                "\t 3. Abundant Shade\n" +
                "Please select from the options above: ");
        int shade = scan.nextInt();


        //Determine BTUs required to Heat Room
        double area = length * width;
        if (area < 250) {
            btu = BTU_SMALL_ROOM;
        } else if (area >= 250 && area <= 500) {
            btu = BTU_MEDIUM_ROOM;
        } else if (area > 500 && area < 1000) {
            btu = BTU_LARGE_ROOM;
        } else {
            btu = BTU_VERY_LARGE_ROOM;
        }


        //Adjust BTU requirements based on Amount of Shade
        switch (shade) {
            case 1:
                btu += (btu * LIGHT_SHADE_ADJUSTMENT);
                shadeDescription = "Light";
                break;
            case 2:
                shadeDescription = "Moderate";
                break;
            case 3:
                btu -= (btu * ABUNDANT_SHADE_ADJUSTMENT);
                shadeDescription = "Abundant";
                break;
        }


        //Display Output
        System.out.println("Room Area (sqft: " + area + "\n" +
                "Amount of Shade: " + shadeDescription + "\n" +
                "BTU's Per Hour needed: " + Math.round(btu));

    }
}
