package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
	private static WebDriver driver;
	
	private Drivers() {
	}
	
	public static void setChrome() {
		System.setProperty("webdriver.chrome.driver", "./src/helpers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
}
