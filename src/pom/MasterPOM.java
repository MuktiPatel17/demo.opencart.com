package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import helpers.Assignments;


public class MasterPOM {
	WebDriver driver;
	
	public MasterPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.driver,15), this);
	}
	
	@FindBy(css = "#top-links > ul > li:nth-child(1)")
	protected WebElement linkPhone;
	
	@FindBy(css = "#top-links > ul > li:nth-child(2)")
	protected WebElement dropdownAccount;
	
	@FindBy(css = "#top-links > ul > li.dropdown.open > ul > li")
	protected List<WebElement> listAccount;
	
	@FindBy(css = "#top-links > ul > li:nth-child(3)")
	protected WebElement linkWishlist;
	
	@FindBy(css = "#top-links > ul > li:nth-child(4)")
	protected WebElement linkCart;
	
	@FindBy(css = "#top-links > ul > li:nth-child(5)")
	protected WebElement linkCheckout;
	
	@FindBy(css ="#form-currency > div > button")
	protected WebElement dropdownCurrency;
	
	@FindBy(css ="#form-currency > div > ul > li")
	protected List<WebElement> listCurrency;
	
	@FindBy(id = "logo")
	protected WebElement logo;
	
	@FindBy(css = "#search > input")
	protected WebElement textboxMasterSearch;
	
	@FindBy(css = "#search > span")
	protected WebElement btnSearch;
	
	@FindBy(css = "#cart > button")
	protected WebElement btnCart;
	
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(1)")
	protected WebElement navDesktop;
	
	@FindBy(partialLinkText = "PC")
	protected WebElement pc;
	
	@FindBy(partialLinkText = "Mac")
	protected WebElement mac;
	
	@FindBy(linkText = "Show All Desktops")
	protected WebElement showAllDesktops;
	
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(2)")
	protected WebElement navLaptop;
	
	@FindBy(partialLinkText = "Macs")
	protected WebElement macs;
	
	@FindBy(partialLinkText = "Windows")
	protected WebElement windows;
	
	@FindBy(linkText = "Show All Laptops & Notebooks")
	protected WebElement showAllLaptops;
	
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(3)")
	protected WebElement navComponents;
	
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(4)")
	protected WebElement navTablets;
	
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(5)")
	protected WebElement navSoftware;
	
	@FindBy(css = "#menu > div.collapse.navbar-collapse.navbar-ex1-collapse > ul > li:nth-child(6)")
	protected WebElement navPhonePDA;
	
	public void verifyCompanyName() {
		Assert.assertEquals("Your Store", logo.getText());
	}
	
	public void searchText(String query) {
		textboxMasterSearch.clear();
		textboxMasterSearch.sendKeys(query);
		btnSearch.click();
	}
	
	public void searchReverseText(String query) {
		textboxMasterSearch.clear();
		textboxMasterSearch.sendKeys(Assignments.reverse(query));
		btnSearch.click();
	}
	
	public void searchRandomText(String query) {
		textboxMasterSearch.clear();
		textboxMasterSearch.sendKeys(Assignments.randomString(query, query.length()));
		btnSearch.click();
	}
	
	public void clickCart() {
		btnCart.click();
	}
	
	public void showAllDesktops() {
		navDesktop.click();
		showAllDesktops.click();
	}
	
	public void showAllLaptops() {
		navLaptop.click();
		showAllLaptops.click();
	}
	
	public void showAllPhones() {
		navPhonePDA.click();
	}
	
	public void goToRegister() {
		dropdownAccount.click();
		listAccount.get(0).click();
	}
	
	public void goToLogin() {
		dropdownAccount.click();
		listAccount.get(1).click();
	}
}
