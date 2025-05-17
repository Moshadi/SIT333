package web.service; 
 import org.junit.After; 
 import org.junit.Assert; 
 import org.junit.Before; 
 import org.junit.Test; 
 import org.openqa.selenium.By; 
 import org.openqa.selenium.WebDriver; 
 import org.openqa.selenium.chrome.ChromeDriver; 
 import org.openqa.selenium.support.ui.ExpectedConditions; 
 import org.openqa.selenium.support.ui.WebDriverWait; 
 
public class FunctionalTestMathQuestions { 
 
 	private WebDriver driver;  
 	@	Before	 
 	public void setUp() { 
 	 	// Set path to chromedriver (adjust the path based on your local setup) 
 	 	System.setProperty("webdriver.chrome.driver", 
    "C:\\chromedriver\\chromedriver-win64\\chromedriver.exe"); 
 	 	driver = new ChromeDriver(); 
 	} 
 
 	// For Question1 
 
 	@Test 
 	public void testValidAnswerQ1() { 
 	 	driver.get("http://localhost:8080/q1"); 
 
 	 	driver.findElement(By.name("number1")).sendKeys("1");  	 	driver.findElement(By.name("number2")).sendKeys("3");  	 	driver.findElement(By.name("result")).sendKeys("4"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	Assert.assertEquals("http://localhost:8080/q2", driver.getCurrentUrl()); 
 	} 
 
 	@Test 
 	public void testMissingFieldsQ1() {  	 	driver.get("http://localhost:8080/q1"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	WebDriverWait wait = new WebDriverWait(driver, 10);  	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));  	String message = driver.findElement(By.className("alert")).getText(); 
 	Assert.assertEquals("Please fill in all fields.", message); } 
@Test 
public void testInvalidNumberFormatNumber1Q1() {  	driver.get("http://localhost:8080/q1"); 
 	driver.findElement(By.name("number1")).sendKeys("a");  	 	driver.findElement(By.name("number2")).sendKeys("3");  	 	driver.findElement(By.name("result")).sendKeys("4"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	String message = driver.findElement(By.className("alert")).getText(); 
 	 	Assert.assertEquals("Invalid number format for the first number.", message); 
 	} 
 
 	@Test 
 	public void testInvalidNumberFormatNumber2Q1() {  	 	driver.get("http://localhost:8080/q1"); 
 
 	 	driver.findElement(By.name("number1")).sendKeys("1");  	 	driver.findElement(By.name("number2")).sendKeys("a");  	 	driver.findElement(By.name("result")).sendKeys("4"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	String message = driver.findElement(By.className("alert")).getText(); 
 	 	Assert.assertEquals("Invalid number format for the second number.", message); 
 	} 
 
 	@Test 
 	public void testInvalidNumberFormatResultQ1() {  	 	driver.get("http://localhost:8080/q1"); 
 
 	 	driver.findElement(By.name("number1")).sendKeys("1");  	 	driver.findElement(By.name("number2")).sendKeys("3");  	 	driver.findElement(By.name("result")).sendKeys("a"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	String message = driver.findElement(By.className("alert")).getText(); 
 	 	Assert.assertEquals("Invalid number format for the result.", message); 
 	} 
 
 	@Test 
 	public void testWrongAnswerQ1() { 
 	 	driver.get("http://localhost:8080/q1"); 
 
 	 	driver.findElement(By.name("number1")).sendKeys("1");  	 	driver.findElement(By.name("number2")).sendKeys("3");  	 	driver.findElement(By.name("result")).sendKeys("5"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	String message = driver.findElement(By.className("alert")).getText();  	 	Assert.assertEquals("Wrong answer, try again.", message); 
 	} 
 
 	// For Question 2 
 
 	@Test 
 	public void testValidAnswerQ2() { 
	 	driver.get("http://localhost:8080/q2"); 
 	driver.findElement(By.name("number1")).sendKeys("5");  	driver.findElement(By.name("number2")).sendKeys("3");  	driver.findElement(By.name("result")).sendKeys("2");  	driver.findElement(By.name("submit")).click(); 
 Assert.assertEquals("http://localhost:8080/q3", driver.getCurrentUrl()); } 
 
 	@Test 
 	public void testMissingFieldsQ2() {  	 	driver.get("http://localhost:8080/q2"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	WebDriverWait wait = new WebDriverWait(driver, 10); 
 	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));  
 	 	String message = driver.findElement(By.className("alert")).getText();  
 	 	Assert.assertEquals("Please fill in all fields.", message); 
 	} 
 
 	@Test 
 	public void testInvalidNumberFormatNumber1Q2() {  	 	driver.get("http://localhost:8080/q2"); 
 
 	 	driver.findElement(By.name("number1")).sendKeys("a");  	 	driver.findElement(By.name("number2")).sendKeys("3");  	 	driver.findElement(By.name("result")).sendKeys("2"); 
 
 	 	driver.findElement(By.name("submit")).click();  
 	 	String message = driver.findElement(By.className("alert")).getText(); 
 	 	Assert.assertEquals("Invalid number format for the first number.", message); 
 	} 
 
 	@Test 
 	public void testInvalidNumberFormatNumber2Q2() {  	 	driver.get("http://localhost:8080/q2"); 
 
 	 	driver.findElement(By.name("number1")).sendKeys("5");  	 	driver.findElement(By.name("number2")).sendKeys("a");  	 	driver.findElement(By.name("result")).sendKeys("2"); 
  	 	driver.findElement(By.name("submit")).click();  
 	 	String message = driver.findElement(By.className("alert")).getText(); 
 	 	Assert.assertEquals("Invalid number format for the second number.", message); 
 	} 
 
 	@Test 
 	public void testInvalidNumberFormatResultQ2() {  	 	driver.get("http://localhost:8080/q2"); 
 
 	 	driver.findElement(By.name("number1")).sendKeys("5");  	 	driver.findElement(By.name("number2")).sendKeys("3");  	 	driver.findElement(By.name("result")).sendKeys("a"); 
  	 	driver.findElement(By.name("submit")).click();  
 	 	String message = driver.findElement(By.className("alert")).getText(); 
 	 	Assert.assertEquals("Invalid number format for the result.", message); 
} 
@Test 
public void testWrongAnswerQ2() {  	driver.get("http://localhost:8080/q2"); 
 	driver.findElement(By.name("number1")).sendKeys("5");  	driver.findElement(By.name("number2")).sendKeys("3");  	driver.findElement(By.name("result")).sendKeys("10"); 
 	 	driver.findElement(By.name("submit")).click(); 
 
 	 	String message = driver.findElement(By.className("alert")).getText();  	 	Assert.assertEquals("Wrong answer, try again.", message); 
 	} 
 
 	@After 
 	public void tearDown() { 
 	 	driver.quit(); 
 	} 
 
} 
 
