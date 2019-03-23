package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import helpers.Wait;

public class ProductPOM extends MasterPOM {

	public ProductPOM(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
	
	@FindBy(css = "button[onclick*=\"wishlist.add\"]")
	protected WebElement wishList;
	
	@FindBy(css = "button[onclick*=\"compare.add\"]")
	protected WebElement compareTo;
	
	@FindBy(id = "button-cart")
	protected WebElement btnAddToCart;
	
	@FindBy(linkText = "Description")
	protected WebElement linkDescription;
	
	@FindBy(linkText = "Specification")
	protected WebElement linkSpecification;
	
	@FindBy(partialLinkText = "Reviews")
	protected WebElement linkReviews;
	
	protected _ProductPOM prodList;
	
	public void addToWishlist() {
		this.wishList.click();
		Wait.sleep(2);
	}
	
	public void addToComparelist() {
		this.compareTo.click();
		Wait.sleep(2);
	}
	
	public void clickSpecification() {
		linkSpecification.click();
	}
	
	public void clickDescription() {
		linkDescription.click();
	}
	
	public void clickReview() {
		linkReviews.click();
	}
	
	public void addToCart() {
		btnAddToCart.click();
	}
}
