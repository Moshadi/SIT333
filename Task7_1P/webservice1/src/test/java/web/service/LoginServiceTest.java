package web.service; 
 
import org.junit.Assert; 
import org.junit.Test; 
import org.openqa.selenium.By; 
import org.openqa.selenium.JavascriptExecutor; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver; 
 
public class LoginServiceTest { 
 
    private final String DRIVER_PATH = "C:\\chromedriver\\chromedriver-win64"; 
    private final String LOGIN_PAGE = "file:///C:/Users/DELL/Downloads/7.1P-resources%20(1)/pages/login.html"; 
 
    private WebDriver setupDriver() { 
//        System.setProperty("webdriver.chrome.driver", DRIVER_PATH); 
        WebDriver driver = new ChromeDriver(); 
        driver.navigate().to(LOGIN_PAGE); 
        sleep(2); 
        return driver; 
    } 
 
    private void sleep(long sec) { 
        try {
        	 Thread.sleep(sec * 1000); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
    } 
 
    private void performLogin(WebDriver driver, String username, String password, String 
dob) { 
        driver.findElement(By.id("username")).clear(); 
        driver.findElement(By.id("username")).sendKeys(username); 
 
        driver.findElement(By.id("passwd")).clear(); 
        driver.findElement(By.id("passwd")).sendKeys(password); 
 
        // Use JavaScript to set the date value directly 
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("document.getElementById('dob').value='" + dob + "';"); 
 
        // Verify the date value is set correctly 
        String enteredDob = (String) js.executeScript("return document.getElementById('dob').value;"); 
        System.out.println("DOB entered: " + enteredDob);  // Debugging output 
 
        driver.findElement(By.cssSelector("[type=submit]")).submit(); 
        sleep(2); 
    }
    @Test 
    public void testValidLogin() { 
        WebDriver driver = setupDriver(); 
        performLogin(driver, "moshi", "moshi12", "08/02/2000"); 
        Assert.assertEquals("success", driver.getTitle()); 
        driver.quit(); 
    } 
 
    @Test 
    public void testInvalidUsername() { 
        WebDriver driver = setupDriver(); 
        performLogin(driver, "wrong", "moshi12", "08/02/2000"); 
        Assert.assertEquals("fail", driver.getTitle()); 
        driver.quit(); 
    } 
 
    @Test 
    public void testInvalidPassword() { 
        WebDriver driver = setupDriver(); 
        performLogin(driver, "moshi", "wrongpass", "08/02/2000"); 
        Assert.assertEquals("fail", driver.getTitle()); 
        driver.quit(); 
    } 
 
    @Test
    public void testInvalidDOB() { 
        WebDriver driver = setupDriver(); 
        performLogin(driver, "moshi", "moshi12", "08/02/2000"); 
        Assert.assertEquals("fail", driver.getTitle()); 
        driver.quit(); 
    } 
 
    @Test 
    public void testEmptyFields() { 
        WebDriver driver = setupDriver(); 
        performLogin(driver, "", "", ""); 
        Assert.assertEquals("fail", driver.getTitle()); 
        driver.quit(); 
    } 
} 

    
        