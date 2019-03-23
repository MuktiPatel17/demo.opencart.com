package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helpers.DataReaders;
import helpers.Drivers;
import helpers.Wait;
import pom.MasterPOM;

public class Master {
	WebDriver driver;

	@BeforeClass
	public void setUpClass() {
		this.driver = Drivers.getDriver();
	}
	
	//sets up specified driver, initializes driver object and navigates to baseURL
	@BeforeMethod
	public void setUpMethod() {
//		Drivers.setChrome();
//		this.driver = Drivers.getDriver();
		driver.get(DataReaders.projectProperty("baseURL"));
	}
	
	@DataProvider(name = "test001")
	public Object[][] test001_testData() throws IOException {
		String filepath = "./src/testdata";
		String filename = "Master.xlsx";
		String sheetname = "test001";
		return DataReaders.excelReader(filepath, filename, sheetname);
	}
	
	//Searches given parameter in main search bar at the top of the page
	@Test(enabled = true, dataProvider = "test001")
	public void test001(Object query) {
		MasterPOM obj = new MasterPOM(driver);
		obj.searchText(query.toString());
		obj.searchReverseText(query.toString());
		obj.searchRandomText(query.toString());
	}
	
	//Displays list of all products under laptops section
	@Test(enabled = true)
	public void test002() {
		MasterPOM obj = new MasterPOM(driver);
		obj.showAllLaptops();
	}
	
	//Verifies the company name logo for correctness
	@Test(enabled = true)
	public void test003() {
		MasterPOM obj = new MasterPOM(driver);
		obj.verifyCompanyName();
	}
	
	//Navigates to register page
	@Test(enabled = true)
	public void test004() {
		MasterPOM obj = new MasterPOM(driver);
		obj.goToRegister();
	}
	
	//Navigate to login page
	@Test(enabled = true)
	public void test005() {
		MasterPOM obj = new MasterPOM(driver);
		obj.goToLogin();
		Wait.sleep(2);
	}
	
	//Verifies the cart button
	@Test(enabled = true)
	public void test006() {
		MasterPOM obj = new MasterPOM(driver);
		obj.clickCart();
		Wait.sleep(3);
		obj.clickCart();
	}
	
//	@AfterMethod
//	public void cleanUpMethod() {
//		driver.close();
//	}
}
