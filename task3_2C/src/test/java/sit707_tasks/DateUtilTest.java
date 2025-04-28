package sit707_tasks;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateUtilTest {

    // Test for Student Information
    @Test
    public void testStudentIdentity() {
        String studentId = "224783796";
        assertNotNull("Student ID is null", studentId);
        System.out.println("TestStudentIdentity passed - " + studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "W.A.D. Moshadi Hansamali";
        assertNotNull("Student name is null", studentName);
        System.out.println("TestStudentName passed - " + studentName);
    }

    // Valid Date Tests
    @Test
    public void testValidDateTypical() {
        DateUtil date = new DateUtil(15, 6, 2020);
        assertEquals("15/06/2020", date.toString());
    }

    @Test
    public void testValidLeapYearFeb29() {
        DateUtil date = new DateUtil(29, 2, 2020);
        assertEquals("29/02/2020", date.toString());
    }

    @Test
    public void testValidDay30For30DayMonth() {
        DateUtil date = new DateUtil(30, 4, 2020);
        assertEquals("30/04/2020", date.toString());
    }

    @Test
    public void testValidDay31For31DayMonth() {
        DateUtil date = new DateUtil(31, 1, 2020);
        assertEquals("31/01/2020", date.toString());
    }

    @Test
    public void testValidFebruaryNonLeap() {
        DateUtil date = new DateUtil(28, 2, 2023);
        assertEquals("28/02/2023", date.toString());
    }

    @Test
    public void testLowestYear() {
        DateUtil date = new DateUtil(1, 1, 1700);
        assertEquals("01/01/1700", date.toString());
    }

    @Test
    public void testHighestYear() {
        DateUtil date = new DateUtil(31, 12, 2024);
        assertEquals("31/12/2024", date.toString());
    }

    // Invalid Date Tests
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayTooLow() {
        new DateUtil(0, 3, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayTooHigh() {
        new DateUtil(32, 1, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDay31In30DayMonth() {
        new DateUtil(31, 4, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayInFebNonLeapYear() {
        new DateUtil(29, 2, 2023);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonthTooLow() {
        new DateUtil(10, 0, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonthTooHigh() {
        new DateUtil(10, 13, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYearTooLow() {
        new DateUtil(10, 5, 1699);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidYearTooHigh() {
        new DateUtil(10, 5, 2025);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidApril31() {
        new DateUtil(31, 4, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFeb30() {
        new DateUtil(30, 2, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFeb31() {
        new DateUtil(31, 2, 2020);
    }

    // Increment Tests
    @Test
    public void testIncrementFromEndOfMonth() {
        DateUtil date = new DateUtil(31, 1, 2020);
        date.increment();
        assertEquals("01/02/2020", date.toString());
    }

    @Test
    public void testIncrementFromEndOfYear() {
        DateUtil date = new DateUtil(31, 12, 2023);
        date.increment();
        assertEquals("01/01/2024", date.toString());
    }

    @Test
    public void testFeb28NonLeapToMarch1() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        assertEquals("01/03/2023", date.toString());
    }

    @Test
    public void testFeb28LeapYearIncrement() {
        DateUtil date = new DateUtil(28, 2, 2020);
        date.increment();
        assertEquals("29/02/2020", date.toString());
    }

    @Test
    public void testFeb29LeapYearIncrement() {
        DateUtil date = new DateUtil(29, 2, 2020);
        date.increment();
        assertEquals("01/03/2020", date.toString());
    }

    @Test
    public void testJan31ToFeb1() {
        DateUtil date = new DateUtil(31, 1, 2020);
        date.increment();
        assertEquals("01/02/2020", date.toString());
    }

    // Decrement Tests
    @Test
    public void testDecrementFromStartOfMonth() {
        DateUtil date = new DateUtil(1, 3, 2020);
        date.decrement();
        assertEquals("29/02/2020", date.toString());
    }

    @Test
    public void testDecrementFromStartOfYear() {
        DateUtil date = new DateUtil(1, 1, 2020);
        date.decrement();
        assertEquals("31/12/2019", date.toString());
    }

    @Test
    public void testFeb1DecrementToJan31() {
        DateUtil date = new DateUtil(1, 2, 2020);
        date.decrement();
        assertEquals("31/01/2020", date.toString());
    }
}
