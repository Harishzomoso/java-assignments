package JavaAssignment4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            Date signupDate = sdf.parse(parts[0]);
            Date currentDate = sdf.parse(parts[1]);

            printKYCWindow(signupDate, currentDate);
        }
    }

    public static void printKYCWindow(Date signupDate, Date currentDate) {
        Calendar signupCal = Calendar.getInstance();
        signupCal.setTime(signupDate);

        Calendar currCal = Calendar.getInstance();
        currCal.setTime(currentDate);

        int currYear = currCal.get(Calendar.YEAR);

        // Set anniversary for this year
        Calendar anniversary = Calendar.getInstance();
        anniversary.setTime(signupDate);
        anniversary.set(Calendar.YEAR, currYear);

        // If anniversary is after current date, move to previous year
        if (anniversary.after(currCal)) {
            anniversary.add(Calendar.YEAR, -1);
        }

        // Anniversary should not be before signup date year
        if (anniversary.get(Calendar.YEAR) < signupCal.get(Calendar.YEAR)) {
            System.out.println("No range");
            return;
        }

        // Calculate window: +/- 30 days
        Calendar startRange = (Calendar) anniversary.clone();
        startRange.add(Calendar.DAY_OF_MONTH, -30);

        Calendar endRange = (Calendar) anniversary.clone();
        endRange.add(Calendar.DAY_OF_MONTH, 30);

        // Cannot use future dates beyond current date
        if (endRange.after(currCal)) {
            endRange = (Calendar) currCal.clone();
        }

        // Check if range is valid
        if (startRange.after(currCal)) {
            System.out.println("No range");
        } else {
            System.out.println(sdf.format(startRange.getTime()) + " " + sdf.format(endRange.getTime()));
        }
    }
}
