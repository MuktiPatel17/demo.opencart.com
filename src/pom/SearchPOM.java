package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPOM extends CategoryPOM {
	WebDriver driver;
	
	public SearchPOM(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}
	
	@FindBy(id = "input-search")
	protected WebElement textboxSearch;
	
	@FindBy(name = "category_id")
	protected WebElement dropdownProdCategory;
	
	@FindBy(id = "description")
	protected WebElement checkboxDescription;
	
	@FindBy(id = "button-search")
	protected WebElement btnSearch;
	
	Select selectProdCategory;
	
	public void search(String query) {
		textboxSearch.sendKeys(query);
	}
	
	public void selectCategory(String category) {
		selectProdCategory = new Select(dropdownProdCategory);
		selectProdCategory.selectByValue(category);
	}
	
	public void clickDescription() {
		checkboxDescription.click();
	}
	
	public void clickSearch() {
		btnSearch.click();
	}

}
