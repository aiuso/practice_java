import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Three {

    public static void romanNumerals() {
        Scanner scan = new Scanner(System.in);
        String romanNumerals[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int i;

        while (true) {
            System.out.println("Choose a number from 1 to 10.");

            try {
                i = scan.nextInt();
                if (i >= 1 && i <= 10) {
                    System.out.println(romanNumerals[i]);
                    break;
                }
            } catch (Exception e) {
                System.out.println("Your choice must be an integer.");
                Three.romanNumerals();

            }

        }

    }

    // ################################################################################################################


    public static void magicDates() {
        Scanner scan = new Scanner(System.in);
        String error = "Please use the correct format.";


        while (true) {
            System.out.println("Enter a date: MM/DD/YY");
            String input = scan.next();

            if (input.length() == 8) {
                try {
                    String split[] = input.split("/");
                    int result = Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
                    if (result == Integer.parseInt(split[2])) {
                        System.out.println("This date is MAGIC!");
                    } else {
                        System.out.println("Not very magical.");
                    }
                } catch (Exception e) {
                    System.out.println(error);
                    Three.magicDates();
                }

            } else {
                System.out.println(error);
            }
        }
    }

    // ################################################################################################################

    public static void testScoreGrader(){
        Scanner scan = new Scanner(System.in);
        String error = "One or more of your scores are invalid";
        int testScores[] = new int[3];
        int numberOfTests = 3;
        int avgScore = 0;
        int i = 0;

        while (true) {
            try {
                while (i < numberOfTests) {
                    System.out.println("Test score?");
                    avgScore += scan.nextInt();
                    i++;
                }
                avgScore /= numberOfTests;

                if (90 <= avgScore && avgScore <= 100){
                    System.out.println("Your grade is an 'A'");
                } else if (80 <= avgScore && avgScore <= 90){
                    System.out.println("Your grade is an 'B'");
                } else if (70 <= avgScore && avgScore <= 80) {
                    System.out.println("Your grade is an 'C'");
                } else if (60 <= avgScore && avgScore <= 70) {
                    System.out.println("Your grade is an 'D'");
                } else if (0 <= avgScore && avgScore <= 60) {
                    System.out.println("Your grade is an 'F'");
                } else {
                    System.out.println(error);
                    Three.testScoreGrader();
                }
            break;

            } catch (Exception e) {
                System.out.println(error);
                Three.testScoreGrader();
            }
        }
    }

    // ################################################################################################################

    public static void speedOfSoundAlt() {
        Scanner scan = new Scanner(System.in);
        String error = "Not a valid entry. Try again.";
        double distance;
        double seconds = 0;

        // Declare constants
        int AIR_FEETSEC = 1100;
        int WATER_FEETSEC = 4900;
        int STEEL_FEETSEC = 1640;


        System.out.println("Medium sound will travel through. (Air, Water, or Steel)");
        String medium = scan.next().strip().toLowerCase();

        // Check String for appropriate input.
        if (medium.equals("air") || medium.equals("water") || medium.equals("steel")) {
            System.out.println("Enter the distance (feet) needed to travel.");

            distance = scan.nextDouble();

            if (medium.equals("air")) {
                seconds = distance / AIR_FEETSEC;
            } else if (medium.equals("water")) {
                seconds = distance / WATER_FEETSEC;
            } else if (medium.equals("steel")) {
                seconds = distance / STEEL_FEETSEC;
            }

            System.out.println(String.format("Sound will take %.2f seconds " +
                            "to travel %s feet through %s.",
                    seconds, distance, medium));

        // If medium != air || water || steel, restart function.
        } else {
            System.out.println(error);
            speedOfSoundAlt();
        }
    }


    public static void speedOfSound() {
        Scanner scan = new Scanner(System.in);
        String error = "Not a valid entry. Try again.";
        double distance;
        double seconds;

        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        dict.put("air", 1100);      // sound velocity (ft/s) in air
        dict.put("water", 4900);    // sound velocity (ft/s) in water
        dict.put("steel", 16400);   // sound velocity (ft/s) in steel

        System.out.println("Medium sound will travel through. (Air, Water, or Steel)");
        String medium = scan.next().strip().toLowerCase();

        if (medium.equals("air") || medium.equals("water") || medium.equals("steel")) {
            System.out.println("Enter the distance (feet) needed to travel.");

            while (true) {
                try {
                    distance = scan.nextDouble();
                    seconds = distance / dict.get(medium);

                    System.out.println(String.format("Sound will take %.2f seconds " +
                                    "to travel %s feet through %s.",
                            seconds, distance, medium));
                    break;

                } catch (Exception e) {
                    System.out.println(error);
                    speedOfSound();
                }
            }

        } else {
            System.out.println(error);
            speedOfSound();
        }
    }

    // ################################################################################################################

    Scanner scan = new Scanner(System.in);
    int SEC_IN_MIN = 60;
    int SEC_IN_HOUR = 3600;
    int SEC_IN_DAY = 86400;

    public void timeCalculator() {
        HashMap<String, Integer> time;
        int timeSeconds = 0;
        int sec;
        int min;

        while (true) {

            try {
                System.out.println("Enter seconds.");
                String input = scan.next().strip();
                timeSeconds = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid.");
                timeCalculator();
            }


            if (timeSeconds >= SEC_IN_MIN && timeSeconds < SEC_IN_HOUR) {
                time = calcMin(timeSeconds);
                min = time.get("min");
                sec = time.get("sec");

                System.out.println(String.format("Minutes: %s\n" +
                        "Seconds: %s", min, sec));
                break;


            } else if (timeSeconds >= SEC_IN_HOUR && timeSeconds < SEC_IN_DAY) {
                time = calcHour(timeSeconds);
                int hours = time.get("hours");
                min = time.get("min");
                sec = time.get("sec");

                System.out.println(String.format("Hours: %s\n" +
                        "Minutes: %s\n" +
                        "Seconds: %s", hours, min, sec));
                break;


            } else if (timeSeconds >= SEC_IN_DAY) {
                time = calcDay(timeSeconds);
                int days = time.get("days");
                int hours = time.get("hours");
                min = time.get("min");
                sec = time.get("sec");

                System.out.println(String.format("Days %s\n" +
                        "Hours: %s\n" +
                        "Minutes: %s\n" +
                        "Seconds: %s", days, hours, min, sec));
                break;

            } else {
                System.out.println("Seconds: " + timeSeconds);
                break;
            }

        }
    }

    private HashMap calcMin(int timeSeconds) {
        int sec = timeSeconds % SEC_IN_MIN;
        int min = timeSeconds / SEC_IN_MIN;
        HashMap time = new HashMap();
        time.put("sec", sec);
        time.put("min", min);
        return time;
    }

    private HashMap calcHour(int timeSeconds) {
        int hours = timeSeconds / SEC_IN_HOUR;
        HashMap time = calcMin(timeSeconds - (hours * SEC_IN_HOUR));
        time.put("hours", hours);
        return time;
    }

    private HashMap calcDay(int timeSeconds) {
        int days = timeSeconds / SEC_IN_DAY;
        HashMap time = calcHour(timeSeconds - (days * SEC_IN_HOUR));
        time.put("days", days);
        return time;
    }

    // ################################################################################################################


}






