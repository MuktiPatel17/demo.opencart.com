package pom;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class _ProductPOM {
	WebDriver driver;
	
	public _ProductPOM(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}

	@FindBy(className = "product-thumb")
	List<WebElement> productList;

	public HashMap<String, WebElement> getProduct(String productname) {
		WebElement prod = null;
		for (WebElement c : productList) {
			WebElement title = c.findElement(By.cssSelector("h4 > a"));
			if (title.getText().contains(productname)) {
				prod = c;
			}
		}
		WebElement name = prod.findElement(By.partialLinkText(productname));
		WebElement caption = prod.findElement(By.cssSelector("div:nth-child(2) > div.caption"));
		WebElement prodInfo = caption.findElement(By.cssSelector("p:nth-child(2)"));
		WebElement price = caption.findElement(By.cssSelector("p:nth-child(3)"));

		WebElement buttons = prod.findElement(By.cssSelector("div:nth-child(2) > div.button-group"));
		WebElement addToCart = buttons.findElement(By.cssSelector("button:nth-child(1)"));
		WebElement addToWishList = buttons.findElement(By.cssSelector("button:nth-child(2)"));
		WebElement compareTo = buttons.findElement(By.cssSelector("button:nth-child(3)"));

		HashMap<String, WebElement> element = new HashMap<String, WebElement>();
		element.put("name", name);
		element.put("prodInfo", prodInfo);
		element.put("price", price);
		element.put("addToCart", addToCart);
		element.put("addToWishList", addToWishList);
		element.put("compareTo", compareTo);
		return element;
	}
}
