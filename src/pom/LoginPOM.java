package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPOM extends MasterPOM {
	
	public LoginPOM(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
	}
	
	@FindBy(id = "input-email")
	protected WebElement textboxEmail;
	
	@FindBy(id = "input-password")
	protected WebElement textboxPassword;
	
	@FindBy(css = "form > input[type = \"submit\"]")
	protected WebElement btnSubmit;
	
	public void signIn(String email, String password) {
		textboxEmail.sendKeys(email);
		textboxPassword.sendKeys(password);
		btnSubmit.click();
	}
}
