package tests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import helpers.DataReaders;
import helpers.Drivers;
import pom.SearchPOM;

public class Search {

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
		String filename = "Search.xlsx";
		String sheetname = "test001";
		return DataReaders.excelReader(filepath, filename, sheetname);
	}
	
	//Searches query with specified parameters and selects matched product
	@Test(enabled = true, dataProvider = "test001")
	public void test001(Object query,Object category, Object description) {
		SearchPOM obj = new SearchPOM(driver);
		obj.searchText(query.toString());
		obj.selectCategory(category.toString());
		if(Boolean.getBoolean(description.toString())) {
			obj.clickDescription();
		}
		obj.clickSearch();
		HashMap<String,WebElement> prod = obj.getProduct(query.toString());
		prod.get("name").click();
	}
	
	@AfterMethod
	public void cleanUpMethod() {
		driver.close();
	}
}
