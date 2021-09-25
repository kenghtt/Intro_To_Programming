package com;

import java.util.Scanner;

public class Assignment4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter a month between 1-12: ");
        int month = scanner.nextInt();
        do {
            if (month < 1 || month > 12) {
                System.out.println("Invalid Input, Month must be between 1-12, Please try again: ");
                month = scanner.nextInt();
            }
        } while (month < 1 || month > 12);

        System.out.println("Please enter a year: ");
        int year = scanner.nextInt();
        System.out.println("\n");
        printMonthCalendar(month, year);
        System.out.println("\n");

    }

    static void printMonthCalendar(int m, int y) {
        printMonthHeader(m, y);
        printMonthBody(m, y);
    }

    static void printMonthHeader(int m, int y) {
        System.out.println("\t\t\t" + getMonthName(m) + "\t" + y);
        System.out.println("-----------------------------------");
        System.out.print("\tSun\tMon\tTue\tWed\tThu\tFri\tSat");
    }


    static void printMonthBody(int m, int y) {
        int startDay = getStartDay(m, 1, y); // Monday-Sunday (1-7)
        int numOfDays = getNumDaysInMonth(m, y);
        int dayOfMonth = 1;
        int currDay = 0;

        while (true) {

            if (dayOfMonth > numOfDays) {
                break;
            }
            if (currDay % 7 == 0) {
                System.out.println("\n");
            }
            if (currDay < startDay && startDay != 7) {
                System.out.print("\t ");
            } else {
                System.out.print("\t" + dayOfMonth);
                dayOfMonth++;
            }
            currDay++;
        }
    }


    static String getMonthName(int m) {
        String month = "";
        switch (m) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }

        return month;
    }


    static int getNumDaysInMonth(int m, int y) {
        int days;

        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            days = 31;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            days = 30;
        } else {
            if (isLeapYear(y)) {
                days = 29;
            } else {
                days = 28;
            }
        }
        return days;
    }

    static boolean isLeapYear(int y) {
        boolean isLeapYear = false;

        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0)
                    isLeapYear = true;
            } else
                isLeapYear = true;
        }
        return isLeapYear;
    }


    static int getStartDay(int m, int d, int y) {

        // Adjust month number & year to fit Zeller's numbering system
        if (m < 3) {
            m = m + 12;
            y = y - 1;
        }

        int k = y % 100;      // Calculate year within century
        int j = y / 100;      // Calculate century term
        int h = 0;            // Day number of first day in month 'm'

        h = (d + (13 * (m + 1) / 5) + k + (k / 4) + (j / 4) +
                (5 * j)) % 7;

        // Convert Zeller's value to ISO value (1 = Mon, ... , 7 = Sun )
        int dayNum = ((h + 5) % 7) + 1;

        return dayNum;
    }

}
