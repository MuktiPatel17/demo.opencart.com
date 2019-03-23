package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helpers.DataReaders;
import helpers.Drivers;
import helpers.Wait;
import pom.RegisterPOM;

public class Register {

	WebDriver driver;

	@BeforeClass
	public void setUpClass() {
		//this.driver = Drivers.getDriver();
	}
	
	//sets up specified driver, initializes driver object and navigates to baseURL
	@BeforeMethod
	public void setUpMethod() {
		Drivers.setChrome();
		this.driver = Drivers.getDriver();
		driver.get(DataReaders.projectProperty("baseURL"));
	}
	
	@DataProvider(name = "test001")
	public Object[][] test001_testData() throws IOException {
		String filepath = "./src/testdata";
		String filename = "Register.xlsx";
		String sheetname = "test001";
		return DataReaders.excelReader(filepath, filename, sheetname);
	}
	
	@DataProvider(name = "test002")
	public Object[][] test002_testData() throws IOException {
		String filepath = "./src/testdata";
		String filename = "Register.xlsx";
		String sheetname = "test002";
		return DataReaders.excelReader(filepath, filename, sheetname);
	}
	
	//Registers user with given credentials
	@Test(enabled = true, dataProvider = "test001")
	public void test001(Object fName, Object lName, Object email, Object tel, Object pass, Object confirm, Object newsletter) {
		RegisterPOM register = new RegisterPOM(driver);
		register.goToRegister();
		register.register(fName.toString(),lName.toString(), email.toString(), tel.toString(), pass.toString(), confirm.toString(), Boolean.valueOf("true"));
		Wait.sleep(5);
	}
	
	//Verifies given user credentials and the error messages
	@Test(enabled = true, dataProvider = "test002")
	public void test002(Object fName, Object lName, Object email, Object tel, Object pass, Object confirm, Object newsletter) {
		RegisterPOM register = new RegisterPOM(driver);
		register.goToRegister();
		register.registerValidation(fName.toString(),lName.toString(), email.toString(), tel.toString(), pass.toString(), confirm.toString(), Boolean.valueOf("true"));
		Wait.sleep(5);
	}
	
	@AfterMethod
	public void cleanUpMethod() {
		driver.close();
	}

}
