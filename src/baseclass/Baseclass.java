package baseclass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {

	public static WebDriver driver;

	public static WebDriver getBrowser(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\rocsa_000\\eclipse-workspace\\SeliniumModel4\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "/firefoxpath");
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("")) {

			} else {
				throw new Exception("not a valid browser name");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsEnabled(WebElement element) throws Exception {
		try {
			boolean enabled = element.isEnabled();
			return enabled;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static boolean elementIsSelected(WebElement element) throws Exception {
		try {
			boolean selected = element.isSelected();
			return selected;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void waitforVisibility(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 40);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void inputValuestoWebelement(WebElement element, String value) throws Exception {
		try {
			boolean displayed = elementIsDisplayed(element);
			boolean enabled = elementIsEnabled(element);
			if (displayed && enabled) {
				element.sendKeys(value);
			} else {
				throw new Exception("Element not displayed/enabled");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void elementClick(WebElement element) throws Exception {
		try {
			boolean elementIsDisplayed = elementIsDisplayed(element);
			if (elementIsDisplayed) {
				element.click();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void elementClear(WebElement element) throws Exception {
		try {
			element.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void mouseHovertoElement(WebElement element) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void doubleClickOnElement(WebElement element) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}
	}

	public static void contextClickonElement(WebElement element) throws Exception {
		try {
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();

		}

	}

	public static void sendKeysUsingActions(WebElement element, String value) {

		try {
			Actions ac = new Actions(driver);
			ac.sendKeys(element, value).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dragAndDrop(WebElement src, WebElement tar) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(src, tar).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void clickUsingActions(WebElement element) {
		try {
			Actions ac = new Actions(driver);
			ac.click(element).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollUpandDownUsingElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView()", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrollUpandDownusingPixels(int width, int height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + width + "," + height + ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void scrolltoPage(String options) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			if (options.equalsIgnoreCase("bottom")) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			} else if (options.equalsIgnoreCase("top")) {
				js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			} else {

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void selectDDusingIndex(WebElement element, int index) {
		try {
			Select sc = new Select(element);
			sc.selectByIndex(index);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void selectDDusingValue(WebElement element, String value) {
		try {
			Select sc = new Select(element);
			sc.selectByValue(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void selectDDusingVisibleText(WebElement element, String value) {
		try {
			Select sc = new Select(element);
			sc.selectByVisibleText(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void takeScreenShot(String fileName) throws IOException {
		try {
			File f = new File("c:path//" + fileName + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs, f);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void switchToWindows(int index) {
		try {
			String cid = driver.getWindowHandle();
			Set<String> pid = driver.getWindowHandles();
			List<String> li = new ArrayList<>();
			li.addAll(pid);
			String string = li.get(index);

			driver.switchTo().window(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void switchtoFrames(Object value, String options) {
		try {
			if (options.equalsIgnoreCase("index")) {
				Integer i = (Integer) value;
				driver.switchTo().frame(i);
			}else if (options.equals("name")) {
				String s = (String) value ; 
				driver.switchTo().frame(s);
			}else if (options.equals("webelement")) {
				WebElement w = (WebElement) value;
				driver.switchTo().frame(w);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void switchtoAlert(String options, String type) {
		try {
			Alert alert = driver.switchTo().alert();

			if (type.equals("simple")) {
				if (options.equals("OK")) {
					alert.accept();
				}
			}else if (type.equals("confirm")) {
				if (options.equals("OK")) {
					alert.accept();
				}else if(options.equals("Cancel")) {
					alert.dismiss();
				}
			}else if (type.equals("prompt")) {
				if (!options.equals("Cancel")) {
					alert.sendKeys(options);
					alert.accept();
				}else {
					alert.dismiss();
				}
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

