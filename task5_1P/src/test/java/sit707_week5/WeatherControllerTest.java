package sit707_week5;

import org.junit.*;
import java.util.Arrays;

public class WeatherControllerTest {

    private static WeatherController controller;
    private static double[] hourlyTemps;

    @BeforeClass
    public static void setUp() {
        controller = WeatherController.getInstance();
        int totalHours = controller.getTotalHours();
        hourlyTemps = new double[totalHours];

        for (int i = 0; i < totalHours; i++) {
            hourlyTemps[i] = controller.getTemperatureForHour(i + 1); // Hour range: 1 to n
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
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        // Arrange
        String studentName = "W.A.D. Moshadi Hansamali";

        // Act & Assert
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");

        // Arrange
        double expectedMin = Arrays.stream(hourlyTemps).min().getAsDouble();

        // Act
        double actualMin = controller.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(expectedMin, actualMin, 0.001);
    }

    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");

        // Arrange
        double expectedMax = Arrays.stream(hourlyTemps).max().getAsDouble();

        // Act
        double actualMax = controller.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(expectedMax, actualMax, 0.001);
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");

        // Arrange
        double expectedAverage = Arrays.stream(hourlyTemps).average().getAsDouble();

        // Act
        double actualAverage = controller.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(expectedAverage, actualAverage, 0.001);
    }

    @Test
    public void testTemperaturePersist() {
        // ✳️ Leave this commented out for Task 5.1P
        /*
        System.out.println("+++ testTemperaturePersist +++");

        WeatherController wController = WeatherController.getInstance();
        String persistTime = wController.persistTemperature(10, 19.5);
        String now = new SimpleDateFormat("H:m:s").format(new Date());

        System.out.println("Persist time: " + persistTime + ", now: " + now);
        Assert.assertTrue(persistTime.equals(now));

        wController.close();
        */
    }
}
