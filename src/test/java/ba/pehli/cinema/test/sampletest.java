package ba.pehli.cinema.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class sampletest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public static void main(String args[]) {
	  JUnitCore junit = new JUnitCore();
	  junit.addListener(new TextListener(System.out));
	  Result result = junit.run(sampletest.class); // Replace "SampleTest" with the name of your class
	  if (result.getFailureCount() > 0) {
	    System.out.println("Test failed.");
	    System.exit(1);
	  } else {
	    System.out.println("Test finished successfully.");
	    System.exit(0);
	  }
  }
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8083/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSame() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Kliknite ovdje")).click();
    driver.findElement(By.cssSelector("img[alt=\"bos\"]")).click();
    driver.findElement(By.xpath("(//img[@alt='bos'])[2]")).click();
    driver.findElement(By.xpath("(//img[@alt='bos'])[3]")).click();
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Catalog")).click();
    driver.close();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
 
}