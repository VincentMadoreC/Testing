package com.example.vincent.testing;

import android.widget.EditText;

public class FormatInput {

    public static String formatPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\D+",""); // Keep only the digits
        if (phoneNumber.length() == 10) { // as it should
            // Apply the following format to phoneNumber: 000-000-0000
            phoneNumber = phoneNumber.substring(0,3) + "-"
                    + phoneNumber.substring(3,6) + "-"
                    + phoneNumber.substring(6);
        } // else, do not format it
        return phoneNumber;
    }

    public static String formatPostalCode(String postalCode) {
        String letters = postalCode.replaceAll("[^\\p{Alpha}]+", "");
        String digits = postalCode.replaceAll("\\D+", "");

        postalCode = "" + Character.toUpperCase(letters.charAt(0)) + digits.charAt(0)
                + Character.toUpperCase(letters.charAt(1)) + " " + digits.charAt(1)
                + Character.toUpperCase(letters.charAt(2)) + digits.charAt(2);

        return postalCode;
    }

    public static String formatAddress() {
        return "ehy";
    }


    /**
     * Format the string to follow the format YYYY-MM-DD by adding a leading zero to the month or day
     *  if they are smaller than 10
     * @param dateString
     * @return the formatted string
     */
    public static String dateYMD(String dateString) {
        // Find the index of the two dashes in the String
        int firstDash = 0; // Index of the first dash (-) in dateString
        int lastDash = 0; // Index of the last dash (-) in dateString
        for (int i = 0; i < dateString.length(); i++) {
            if (dateString.charAt(i) == '-') {
                if (firstDash == 0) {
                    firstDash = i;
                } else {
                    lastDash = i;
                    break;
                }
            }
        }

        String year = dateString.substring(0, firstDash);
        String month = dateString.substring(firstDash + 1, lastDash);
        String day = dateString.substring(lastDash + 1);
        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }
        if (Integer.parseInt(day) < 10) {
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;
    }
}
