package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import helpers.DataReaders;
import helpers.Drivers;


//This class is used for setting up driver globally for testng test.
//Currently not being used, replaced by per method setup<14-12-18>
public class SetUp {
	WebDriver driver;
	private SetUp() {
	}
	
	@Parameters({ "driver" })//this annotation is used to get parameter, we pass name it will bind that parameter to the method, one parameter one argument 
	@BeforeTest
	public void setUp(String driverParam) {//you can access that parameter using this String argument passed here
		switch(driverParam){
		case "chrome" :
			Drivers.setChrome();
			break;
		case "firefox" :
			//firefox driver maine firefox driver setup nhi kiya h but in future its easy for me to do so because of this implementation

			break;
		case "edge" :
			//ie driver
			
		}
		driver = Drivers.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		DataReaders.projectProperty("baseURL", "https://demo.opencart.com");
	}
	
	@AfterTest
	public void testFinalize() {
		driver.close();
	}
	
//	@AfterMethod
//	public void cleanUpMethod() {
//		driver.close();
//	}
}
