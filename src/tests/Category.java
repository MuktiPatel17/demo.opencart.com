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
import pom.CategoryPOM;

public class Category {
	WebDriver driver;
	//abhi jo example dikhaya usme har method ke liye ek driver object create ho raha tha
	//mere project me maine per test ek driver object rakha h.test is not method here.
	//toh isme window close nhi hoti. ek hi window me sab methods execute hote h
	@BeforeClass
	public void setUpClass() {
		this.driver = Drivers.getDriver();
		//ye Drivers mera singleton class h. usse instance leke class me store ho raha h. just for convinience ok
		//
	}// ruk 2 min ready
	//ye testng report tha.ok?toh yeh report developer ko batane ka?kisiko bhi bata sakte h.developer, client etcok
	//mera mann nhi h
	//badme padhe?okaysorrymaatbol
	
	//sets up specified driver, initializes driver object and navigates to baseURL
	@BeforeMethod
	public void setUpMethod() {
//		Drivers.setChrome();
//		this.driver = Drivers.getDriver();
		driver.get(DataReaders.projectProperty("baseURL"));
	}
	//this annotation is used to declare a method as a dataProvider
	//now each row will be fetched for 1 execution
	//and if you have multiple rows itll execute that method for multiple times
	//so we have 2 dimentional array.
	//now make sure that mrthod returns a 2 dimensional array that is the signature of a data provider
	//doesn't matter what method name is but return type matters
	//understood?yes
	//finally how to bind this dataprovider with test method
	@DataProvider(name = "test003")
	public Object[][] test003_testData() throws IOException {
		String filepath = "./src/testdata";
		String filename = "Category.xlsx";
		String sheetname = "test003";
		return DataReaders.excelReader(filepath, filename, sheetname);//ye data provider bhi same cheez kar raha h wo method excel read karke 2d array return karti h
	}
	
	@DataProvider(name = "test004")
	public Object[][] test004_testData() throws IOException {
		String filepath = "./src/testdata";
		String filename = "Category.xlsx";
		String sheetname = "test004";
		return DataReaders.excelReader(filepath, filename, sheetname);
	}
	
	//Verify the change view button
	@Test(enabled = true)
	public void test001() {
		CategoryPOM laptops = new CategoryPOM(driver);
		laptops.showAllLaptops();
		laptops.changeView();
	}
	
	//Verifies product link
	@Test(enabled = true)
	public void test002() {
		CategoryPOM laptops = new CategoryPOM(driver);
		laptops.showAllLaptops();
		laptops.clickProduct("Air");
	}
	
	//Navigates to phones and PDA section and verifies change view, change sort, change limit controls
	//see this test annotations have various attributes , one of them is dataProvider we use that
	//now lets create a data provider
	@Test(enabled = true, dataProvider = "test003")
	public void test003(Object sortOrder, Object limit) {
		CategoryPOM phones = new CategoryPOM(driver);
		phones.showAllPhones();
		phones.changeView();
		phones.changeSort(sortOrder.toString());
		phones.changeLimit(limit.toString());
		Wait.sleep(3);
	}
	
	//Compares two products and opens comparison window
	@Test(enabled = true, dataProvider = "test004")
	public void test004(Object product1Name, Object product2Name) {
		CategoryPOM laptops = new CategoryPOM(driver);
		laptops.showAllLaptops();
		laptops.compareProduct(product1Name.toString());
		laptops.compareProduct(product2Name.toString());
		laptops.gotoProductComparison();
		Wait.sleep(3);
	}
	
//	@AfterMethod
//	public void cleanUpMethod() {
//		driver.close();
//	}
}
