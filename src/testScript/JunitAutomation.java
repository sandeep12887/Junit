package testScript;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseclass.Baseclass;





public class JunitAutomation extends Baseclass {
	public static WebDriver driver;

	@BeforeClass
	public static void beforeclass() throws Exception {

		driver = getBrowser("chrome");
		driver.get("http://automationpractice.com/index.php");

	}

	@Before
	public void beforeMethod() throws Exception {
		elementClick(driver.findElement(By.xpath("//a[@class='login']")));
		inputValuestoWebelement(driver.findElement(By.name("email")), "pp@08.com");
		inputValuestoWebelement(driver.findElement(By.id("passwd")), "greenstech");

	}

	@Test
	public void test1() throws Exception {

		inputValuestoWebelement(driver.findElement(By.xpath("//input[@placeholder='Search']")), "dress");
		elementClick(driver.findElement(By.xpath("(//button[@type='submit'])[1]")));

	}

	@Test
	public void test2() throws Exception {
		elementClick(driver.findElement(By.xpath("//div[@class='cat-title']")));

	}

	@After
	public void afterMethod() throws Exception {
		elementClick(driver.findElement(By.xpath("//a[@class='logout']")));

	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}

}
