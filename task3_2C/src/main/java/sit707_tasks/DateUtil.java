package sit707_tasks;

public class DateUtil {

    private int day;
    private int month;
    private int year;

    public DateUtil(int day, int month, int year) {
        if (day < 1 || day > 31)
            throw new IllegalArgumentException("Invalid day: " + day);
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month: " + month);
        if (year < 1700 || year > 2024)
            throw new IllegalArgumentException("Invalid year: " + year);
        if (day > getDaysInMonth(month, year))
            throw new IllegalArgumentException("Invalid day: " + day + ", max allowed: " + getDaysInMonth(month, year));

        this.day = day;
        this.month = month;
        this.year = year;
    }

    /** Accessor methods */
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Increments the date by one day.
     */
    public void increment() {
        if (day < getDaysInMonth(month, year)) {
            day++;
        } else {
            day = 1;
            if (month < 12) {
                month++;
            } else {
                month = 1;
                year++;
            }
        }
    }

    /**
     * Decrements the date by one day.
     */
    public void decrement() {
        if (day > 1) {
            day--;
        } else {
            if (month > 1) {
                month--;
            } else {
                month = 12;
                year--;
            }
            day = getDaysInMonth(month, year);
        }
    }

    /**
     * Returns the number of days in a given month of a given year.
     */
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    /**
     * Determines if a year is a leap year.
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Returns a string representation of the date (formatted as dd/MM/yyyy).
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
