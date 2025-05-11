package sit707_week4;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BunningsLoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bunnings.com.au/login");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        emailField.clear();
        emailField.sendKeys("wijesooriyamoshadi@gmail.com");   //valid email
        passwordField.clear();
        passwordField.sendKeys("Moshadi@12");            //valid password      
        loginButton.click();

        Thread.sleep(3000);  
        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to be redirected to homepage after successful login",
                   currentUrl.equals("https://www.bunnings.com.au/"));
    }

    @Test
    public void testInvalidPassword() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        emailField.clear();
        emailField.sendKeys("wijesooriyamoshadi@gmail.com");  // Valid email
        passwordField.clear();
        passwordField.sendKeys("wrong_password");              // ❌ Invalid password
        loginButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to stay on login page after wrong password",
                   currentUrl.contains("/login"));
    }

    @Test
    public void testInvalidUsername() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        emailField.clear();
        emailField.sendKeys("wrong_user@example.com");         // ❌ Invalid email
        passwordField.clear();
        passwordField.sendKeys("Moshadi@12");                  // Valid password
        loginButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to stay on login page after wrong email",
                   currentUrl.contains("/login"));
    }

    @Test
    public void testInvalidUsernameAndPassword() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-submit"));

        emailField.clear();
        emailField.sendKeys("wrong_user@example.com");
        passwordField.clear();
        passwordField.sendKeys("wrong_password");
        loginButton.click();

        Thread.sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        assertTrue("Expected to stay on login page after wrong credentials",
                   currentUrl.contains("/login"));
    }
}
