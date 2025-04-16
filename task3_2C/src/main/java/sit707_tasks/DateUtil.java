package sit707_tasks;

/**
 * DateUtil class represents a simple utility to handle date increment and decrement operations.
 * It validates day, month, and year on creation and handles month/year rollovers appropriately.
 * Year must be between 1700 and 2024.
 */
public class DateUtil {

    private static final String[] MONTHS = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    private int day;
    private int month;
    private int year;

    /**
     * Constructor with validation.
     */
    public DateUtil(int day, int month, int year) {
        if (day < 1 || day > 31)
            throw new RuntimeException("Invalid day: " + day);
        if (month < 1 || month > 12)
            throw new RuntimeException("Invalid month: " + month);
        if (year < 1700 || year > 2024)
            throw new RuntimeException("Invalid year: " + year);
        if (day > getDaysInMonth(month, year))
            throw new RuntimeException("Invalid day: " + day + ", max day: " + getDaysInMonth(month, year));

        this.day = day;
        this.month = month;
        this.year = year;
    }

    /** Accessor methods */
    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    /**
     * Increments the date by one day.
     */
    public void increment() {
        if (day < getDaysInMonth(month, year)) {
            day++;
        } else if (month < 12) {
            day = 1;
            month++;
        } else {
            day = 1;
            month = 1;
            year++;
        }
    }

    /**
     * Decrements the date by one day.
     */
    public void decrement() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = getDaysInMonth(month, year);
        } else {
            month = 12;
            year--;
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
     * Returns a string representation of the date.
     */
    @Override
    public String toString() {
        return day + " " + MONTHS[month - 1] + " " + year;
    }
}
