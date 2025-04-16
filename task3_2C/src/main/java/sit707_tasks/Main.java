package sit707_tasks;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing DateUtil Increment/Decrement Functionality ---");

        testScenario("January 31 to February 1", new DateUtil(31, 1, 2024), true);
        testScenario("January 31 to January 30", new DateUtil(31, 1, 2024), false);
        testScenario("January 1 to January 2", new DateUtil(1, 1, 2024), true);
        testScenario("January 1 to December 31 (prev year)", new DateUtil(1, 1, 2024), false);
        testScenario("Leap Year Feb 29 to March 1", new DateUtil(29, 2, 2024), true);
        testScenario("Non-Leap Year Feb 28 to March 1", new DateUtil(28, 2, 2023), true);
        testScenario("April 30 to May 1", new DateUtil(30, 4, 2024), true);
        testScenario("December 31 to January 1 (next year)", new DateUtil(31, 12, 2023), true);

        // Random day in January
        int randomDay = 1 + new Random().nextInt(31);
        DateUtil randomDate = new DateUtil(randomDay, 1, 2024);
        System.out.println("Random day in January before increment: " + randomDate);
        randomDate.increment();
        System.out.println("After increment: " + randomDate);
    }

    private static void testScenario(String description, DateUtil date, boolean increment) {
        System.out.println("\n" + description);
        System.out.println("Before: " + date);
        if (increment) {
            date.increment();
        } else {
            date.decrement();
        }
        System.out.println("After: " + date);
    }
}