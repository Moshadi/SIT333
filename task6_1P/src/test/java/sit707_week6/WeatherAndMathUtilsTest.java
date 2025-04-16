package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "224783796";  
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "W.A.D. Moshadi Hansamali";  // Update with your full name
        Assert.assertNotNull("Student name is null", studentName);
    }

    // Test for False Even Number
    @Test
    public void testFalseNumberIsEven() {
        Assert.assertFalse("Expected false for odd number", WeatherAndMathUtils.isEven(3));  
    }

    // Test for Cancel Weather Advice
    @Test
    public void testCancelWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));  // Dangerous wind speed
    }

    // Test for Dangerous Weather Advice
    @Test
    public void testDangerousWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(75.0, 2.0));  // High wind speed
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 7.0));  // High precipitation
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(50.0, 5.0));  // Both conditions
    }

    // Test for Warning Weather Advice
    @Test
    public void testWarningWeatherAdvice() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(50.0, 2.0));  // High wind speed
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(30.0, 5.0));  // High precipitation
    }

    // Test for All-Clear Weather Advice
    @Test
    public void testClearWeatherAdvice() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 1.0));  // Safe conditions
    }

    // Test for Prime Numbers
    @Test
    public void testPrimeNumbers() {
        Assert.assertTrue("Expected prime", WeatherAndMathUtils.isPrime(2));  // Prime number
        Assert.assertTrue("Expected prime", WeatherAndMathUtils.isPrime(3));  // Prime number
        Assert.assertTrue("Expected prime", WeatherAndMathUtils.isPrime(5));  // Prime number
    }

    // Test for Non-Prime Numbers
    @Test
    public void testNonPrimeNumbers() {
        Assert.assertFalse("Expected non-prime", WeatherAndMathUtils.isPrime(1));  // 1 is not prime
        Assert.assertFalse("Expected non-prime", WeatherAndMathUtils.isPrime(4));  // 4 is not prime
    }

    // Test for Negative Numbers
    @Test
    public void testNegativeNumbers() {
        Assert.assertFalse("Expected non-prime", WeatherAndMathUtils.isPrime(-5));  // Negative number
    }

    // Test for Even Numbers
    @Test
    public void testEvenNumbers() {
        Assert.assertTrue("Expected true for even number", WeatherAndMathUtils.isEven(2));   // Even number
        Assert.assertTrue("Expected true for even number", WeatherAndMathUtils.isEven(4));   // Even number
    }

    // Test for Odd Numbers
    @Test
    public void testOddNumbers() {
        Assert.assertFalse("Expected false for odd number", WeatherAndMathUtils.isEven(1));  // Odd number
        Assert.assertFalse("Expected false for odd number", WeatherAndMathUtils.isEven(3));  // Odd number
    }

    // Test for large even number
    @Test
    public void testLargeEvenNumber() {
        Assert.assertTrue("Expected true for large even number", WeatherAndMathUtils.isEven(1000000));
    }

    // Test for large odd number
    @Test
    public void testLargeOddNumber() {
        Assert.assertFalse("Expected false for large odd number", WeatherAndMathUtils.isEven(1000001));
    }

    // Test for edge case of 0 in isEven
    @Test
    public void testZeroIsEven() {
        Assert.assertTrue("Expected true for zero", WeatherAndMathUtils.isEven(0));  // 0 is even
    }

    // Test for edge case of 0 in isPrime (0 is not prime)
    @Test
    public void testZeroIsNotPrime() {
        Assert.assertFalse("Expected false for 0", WeatherAndMathUtils.isPrime(0));  // 0 is not prime
    }

    // Test for large prime number
    @Test
    public void testLargePrimeNumber() {
        Assert.assertTrue("Expected prime", WeatherAndMathUtils.isPrime(104729));  // A known large prime
    }

    // Test for large non-prime number
    @Test
    public void testLargeNonPrimeNumber() {
        Assert.assertFalse("Expected non-prime", WeatherAndMathUtils.isPrime(1000000));  // Large non-prime number
    }

    // Test for negative even number
    @Test
    public void testNegativeEvenNumber() {
        Assert.assertTrue("Expected true for negative even number", WeatherAndMathUtils.isEven(-4));  // Negative even number
    }

    // Test for negative odd number
    @Test
    public void testNegativeOddNumber() {
        Assert.assertFalse("Expected false for negative odd number", WeatherAndMathUtils.isEven(-3));  // Negative odd number
    }

    // Test for boundary case: Just below the danger threshold for weather advice
    @Test
    public void testBoundaryWeatherAdvice() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(45.0, 4.0));  // Just below the dangerous threshold
    }

    // Test for extreme high values in weather advice
    @Test
    public void testExtremeWeatherAdvice() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(200.0, 50.0));  // Extreme values
    }

    // Additional test for a wide range of edge cases and conditions
    @Test
    public void testAllConditions() {
        Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(10.0, 1.0));  // Clear conditions
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(100.0, 0.0));  // Extreme wind speed
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(0.0, 10.0));  // Extreme precipitation
    }

    // Test for exact threshold cases for Dangerous Advice
    @Test
    public void testExactDangerousThresholds() {
        Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.0, 6.0));  // Exact dangerous wind speed and precipitation
    }

    // Test for boundary case with wind speed just below the danger threshold
    @Test
    public void testJustBelowDangerWindSpeed() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(69.9, 6.0));  // Just below dangerous wind speed
    }

    // Test for boundary case with precipitation just below the danger threshold
    @Test
    public void testJustBelowDangerPrecipitation() {
        Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(70.0, 5.9));  // Just below dangerous precipitation
    }

    // Test for invalid (negative) wind speed and precipitation
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidWeatherInputs() {
        WeatherAndMathUtils.weatherAdvice(-1.0, -1.0);  // Negative wind speed and precipitation
    }
}
