package ba.pehli.cinema.test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

public class HtmlAdminLoginTest {
	
	static WebDriver driver;
	
	public void adminLogin(){
		driver.get("http://localhost:8080/Cinema/movies");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
	}
	
	@BeforeClass
	public static void initialize(){
		System.setProperty("webdriver.gecko.driver", "C:\\selenium-java-3.4.0\\geckodriver.exe");
		driver =new FirefoxDriver();
	
	}
	
	@Test
	public void testAdminLogin(){
		//driver.findElement(By.id("username")).sendKeys("admin");
		//driver.findElement(By.id("password")).sendKeys("admin");
		//driver.findElement(By.name("submit")).click();
		this.adminLogin();
		assertTrue(driver.getCurrentUrl().endsWith("/Cinema/movies"));
	}
	
	//@Test
	//public void testAdminLogout(){
		//this.adminLogin();
		//driver.findElement(By.linkText("Logout")).click();	
	//	assertTrue(driver.getCurrentUrl().endsWith("/Cinema/movies"));
	//}
		
	@AfterClass
	public static void AfterClass(){
		driver.quit();
	}
	
	
	
}