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
import pom.LoginPOM;

public class Login {

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
		String filename = "Login.xlsx";
		String sheetname = "test001";
		return DataReaders.excelReader(filepath, filename, sheetname);
	}
	
	@Test(enabled = true, dataProvider = "test001")
	public void test001(Object email, Object password) {
		LoginPOM login = new LoginPOM(driver);
		login.goToLogin();
		login.signIn(email.toString(), password.toString());
		Wait.sleep(4);
	}
	
	@AfterMethod
	public void cleanUpMethod() {
		driver.close();
	}
}
