package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.DataReaders;
import helpers.Drivers;
import helpers.Wait;
import pom.CategoryPOM;
import pom.ProductPOM;

public class Product {

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
	
	//Adds the selected product to users wishlist & compareto
	@Test(enabled = true)
	public void test001() {
		CategoryPOM laptops = new CategoryPOM(driver);
		laptops.showAllLaptops();
		laptops.clickProduct("Air");
		ProductPOM macbookAir = new ProductPOM(driver);
		macbookAir.addToWishlist();
		macbookAir.addToComparelist();
	}
	
	//Navigates to all desktops section and selects apple cinema 30' and adds to cart
	@Test(enabled = true)
	public void test002() {
		CategoryPOM laptops = new CategoryPOM(driver);
		laptops.showAllDesktops();
		laptops.clickProduct("Apple Cinema 30\"");
		ProductPOM appleCinema = new ProductPOM(driver);
		appleCinema.clickSpecification();
		Wait.sleep(2);
		appleCinema.clickReview();
		Wait.sleep(2);
		appleCinema.addToCart();
		Wait.sleep(2);
		appleCinema.clickCart();
		Wait.sleep(2);
	}
	
//	@AfterMethod
//	public void cleanUpMethod() {
//		driver.close();
//	}
}
