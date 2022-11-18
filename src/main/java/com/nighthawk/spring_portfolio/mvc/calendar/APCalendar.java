package com.nighthawk.spring_portfolio.mvc.calendar;
import java.util.*;
import java.time.YearMonth;

public class APCalendar {

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0) && (year % 400 == 0 || !(year % 100 == 0))) {
            return true;
        }
        else {
            return false;
        }
        }
        
    public static int firstDayOfYear(int year) {
        Date date = new Date(year, 0, 0);
        return date.getDay();
        }

    public static int dayOfYear(int month, int day, int year) {
        // initializes dayValue as 0
        int dayVal = 0;
        for (int i = 1; i < month; i++) {
            // Creates a yearmonth object for each month in the year
            int monthDays = YearMonth.of(year, i).lengthOfMonth();
            dayVal += monthDays;
        }
        //Adds the day of the incomplete month to dayVal
        dayVal += day;
        return dayVal;
        }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
        // initializes leapYearCount as 0
        int leapYearCount = 0;

        // iterates through every year to find if it is a leap year
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                leapYearCount++;
            }
        }

        return leapYearCount;
        }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        //initializes date object, gets day value of that week of initialized date
        Date date = new Date(year, month - 1, day);
        // fix for date.getDay being inacurate to the format we originally had, requires if statement
        if (date.getDay() == 0) {
            return 6;
        }
        else {
            return date.getDay() - 1;
        }
        }


    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2022));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 1, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
    }

}