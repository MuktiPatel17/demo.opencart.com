package pom;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import helpers.Wait;

public class CategoryPOM extends MasterPOM {
	
	public CategoryPOM(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}

	@FindBy(css = "#content > h2")
	protected WebElement title;

	@FindBy(id = "list-view")
	protected WebElement btnListView;

	@FindBy(id = "grid-view")
	protected WebElement btnGridView;
	
	@FindBy(partialLinkText = "Product Compare")
	protected WebElement productComparison;
	
	@FindBy(id = "input-sort")
	protected WebElement dropdownSort;
	
	protected Select selectSort;
	
	@FindBy(id = "input-limit")
	protected WebElement dropdownLimit;
	
	protected Select selectLimit;
	
	protected _ProductPOM prodList;
	
	public HashMap<String,WebElement> getProduct(String productname) {
		prodList = new _ProductPOM(this.driver);
		return prodList.getProduct(productname);
	}
	
	public void clickProduct(String productName) {
		this.getProduct(productName).get("name").click();
	}
	
	public void gotoProductComparison() {
		productComparison.click();
	}
	
	public void compareProduct(String productName) {
		this.getProduct(productName).get("compareTo").click();
	}
	
	public void changeView() {
		Wait.sleep(2);
		if(btnListView.getAttribute("class").contains("active")) {
			btnGridView.click();
		}else {
			btnListView.click();
		}
		Wait.sleep(2);
	}
	
	public void changeSort(String sortOrder) {
		selectSort = new Select(dropdownSort);
		selectSort.selectByVisibleText(sortOrder);
	}
	
	public void changeLimit(String limit) {
		selectLimit = new Select(dropdownLimit);
		selectLimit.selectByVisibleText(limit);
	}
}
