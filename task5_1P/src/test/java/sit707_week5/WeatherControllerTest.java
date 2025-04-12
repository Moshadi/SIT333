package sit707_week5;

import org.junit.*;
import java.util.Arrays;

public class WeatherControllerTest {

    private static WeatherController controller;
    private static double[] hourlyTemps;

    //beforeclass
    @BeforeClass
    public static void setUp() {
        controller = WeatherController.getInstance(); // Reuse the instance across tests.
        int totalHours = controller.getTotalHours();
        hourlyTemps = new double[totalHours];

        // Initialize hourly temperature data once, avoiding redundant slow operations
        for (int i = 0; i < totalHours; i++) {
            hourlyTemps[i] = controller.getTemperatureForHour(i + 1); // Fetching hourly temps
        }
    }

    @AfterClass
    public static void tearDown() {
        controller.close();
    }

    @Test
    public void testStudentIdentity() {
        // Arrange
        String studentId = "224783796";

        // Act & Assert
        Assert.assertNotNull("Student ID is null", studentId); // Check that student ID is not null
    }

    @Test
    public void testStudentName() {
        // Arrange
        String studentName = "W.A.D. Moshadi Hansamali";

        // Act & Assert
        Assert.assertNotNull("Student name is null", studentName); // Check that student name is not null
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        double expectedMin = Arrays.stream(hourlyTemps).min().getAsDouble(); // Find minimum temperature from data

        // Act
        double actualMin = controller.getTemperatureMinFromCache(); // Get cached minimum temperature from controller

        // Assert
        Assert.assertEquals("The minimum temperature should match the expected value", expectedMin, actualMin, 0.001); // Validate
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        double expectedMax = Arrays.stream(hourlyTemps).max().getAsDouble(); // Find maximum temperature from data

        // Act
        double actualMax = controller.getTemperatureMaxFromCache(); // Get cached maximum temperature from controller

        // Assert
        Assert.assertEquals("The maximum temperature should match the expected value", expectedMax, actualMax, 0.001); 
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        double expectedAverage = Arrays.stream(hourlyTemps).average().getAsDouble(); // Find average temperature from data

        // Act
        double actualAverage = controller.getTemperatureAverageFromCache(); // Get cached average temperature from controller

        // Assert
        Assert.assertEquals("The average temperature should match the expected value", expectedAverage, actualAverage, 0.001); // Validate
    }

    @Test
    public void testTemperaturePersist() {
        // ✳️ Leave this commented out for Task 5.1P
        /*
        System.out.println("+++ testTemperaturePersist +++");

        WeatherController wController = WeatherController.getInstance(); // Reuse the controller instance
        String persistTime = wController.persistTemperature(10, 19.5); // Persist temperature for hour 10
        String now = new SimpleDateFormat("H:m:s").format(new Date()); // Get current time

        System.out.println("Persist time: " + persistTime + ", now: " + now);
        Assert.assertTrue("Persist time should match the current time", persistTime.equals(now)); // Validate persistence

        wController.close();
        */
    }
}
