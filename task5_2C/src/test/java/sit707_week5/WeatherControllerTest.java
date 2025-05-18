package sit707_week5;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WeatherControllerTest {

    @BeforeClass
    public static void setUpBeforeClass() {
        
        WeatherController.setTestMode(true);
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "224783796";  
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "W.A.D.Moshadi Hansamali";  
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        System.out.println("+++ testTemperatureMin +++");
        
        WeatherController wController = WeatherController.getInstance();
        
        int nHours = wController.getTotalHours();
        double minTemperature = 1000;
        for (int i=0; i<nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i+1); 
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
        }
        
        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);
        
        wController.close();        
    }
    
    @Test
    public void testTemperatureMax() {
        System.out.println("+++ testTemperatureMax +++");
        
        WeatherController wController = WeatherController.getInstance();
        
        int nHours = wController.getTotalHours();
        double maxTemperature = -1;
        for (int i=0; i<nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i+1); 
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
        }
        
        Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
        
        wController.close();
    }

    @Test
    public void testTemperatureAverage() {
        System.out.println("+++ testTemperatureAverage +++");
        
        WeatherController wController = WeatherController.getInstance();
        
        int nHours = wController.getTotalHours();
        double sumTemp = 0;
        for (int i=0; i<nHours; i++) {
            double temperatureVal = wController.getTemperatureForHour(i+1); 
            sumTemp += temperatureVal;
        }
        double averageTemp = sumTemp / nHours;
        
        Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
        
        wController.close();
    }
    
    @Test
    public void testTemperaturePersist() {
        System.out.println("+++ testTemperaturePersist +++");

        WeatherController wController = WeatherController.getInstance();

        String persistTime = wController.persistTemperature(10, 19.5);

        // Compare only hours and minutes (ignore seconds)
        String persistTimeShort = persistTime.substring(0, persistTime.lastIndexOf(":"));
        String now = new SimpleDateFormat("H:m").format(new Date());

        System.out.println("Persist time (short): " + persistTimeShort + ", now: " + now);

        Assert.assertEquals(persistTimeShort, now);

        wController.close();
    }
}
