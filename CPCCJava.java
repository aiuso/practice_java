import java.util.Scanner;

public class CPCCJava {

    public static void main(String[] args) {
        double distance; // How far (the distance) the sound traveled.

        //create a Scanner object for reading in keyboard input
        Scanner keyboard = new Scanner(System.in);

1
        //get the amount of distance (in feet) traveled
        System.out.print("Enter the distance sound traveled through air; in feet. ");
        distance = keyboard.nextDouble();

        //If the distance is less than 0, there would have been no movement.
        if (distance < 0)
            System.out.println("That's less than 0, " + "meaning no distance was obtained.");
        else
            System.out.println( "Sound traveled in approximately " + (distance / 1100) + " seconds in air.");

        //for Water: get the amount of distance (in feet) traveled
        System.out.print("Enter the distance sound traveled through water; in feet. ");
        distance = keyboard.nextDouble();

        //If the distance is less than 0, there would have been no movement.
        if (distance < 0)
        {
            System.out.println("That's less than 0, " + "meaning no distance was obtained.");
        }


        //for Water: enter the distance in feet into the time equation (t=d/4900).
        if (distance >= 0)
        {
            System.out.println( "Sound traveled in approximately  " + (distance / 4900) + " seconds in water.");
        }

        //for Steel: get the amount of distance (in feet) traveled
        System.out.print("Enter the distance sound traveled through steel; in feet. ");
        distance = keyboard.nextDouble();

        //If the distance is less than 0, there would have been no movement.
        if (distance < 0)
        {
            System.out.println("That's less than 0, " + "meaning no distance was obtained.");
        }


        //for Steel: enter the distance in feet into the time equation (t=d/16,400).
        if (distance >= 0)
        {
            System.out.println( "Sound traveled in approximately " + (distance / 16400) + " seconds in steel.");
        }
    }
}