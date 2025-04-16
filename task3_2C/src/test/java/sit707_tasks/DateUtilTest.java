package sit707_tasks;

import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
    	String studentId = "224783796";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
    	String studentName = "W.A.D. Moshadi Hansamali";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.decrement();
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testLeapYearFeb29ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidNonLeapYearFeb29() {
        new DateUtil(29, 2, 2023);
    }

    @Test
    public void testApril30ShouldIncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidApril31() {
        new DateUtil(31, 4, 2024);
    }

    @Test
    public void testDecember31ShouldIncrementToJanuary1NextYear() {
        DateUtil date = new DateUtil(31, 12, 2023);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testFebruary28NonLeapYearShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(28, 2, 2023);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }
}