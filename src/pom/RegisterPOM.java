package pom;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import helpers.Assignments;
import helpers.Wait;

public class RegisterPOM extends MasterPOM {

	public RegisterPOM(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
	}
	
	@FindBy(id = "input-firstname")
	protected WebElement textboxFirstName;
	
	@FindBy(css = "#input-firstname + div")
	protected WebElement errmsgFirstName;
	
	@FindBy(id = "input-lastname")
	protected WebElement textboxLastName;
	
	@FindBy(css = "#input-lastname + div")
	protected WebElement errmsgLastName;
	
	@FindBy(id = "input-email")
	protected WebElement textboxEmail;
	
	@FindBy(css = "#input-email + div")
	protected WebElement errmsgEmail;
	
	@FindBy(id = "input-telephone")
	protected WebElement textboxTelephone;
	
	@FindBy(css = "#input-telephone + div")
	protected WebElement errmsgTelephone;
	
	@FindBy(id = "input-password")
	protected WebElement textboxPassword;
	
	@FindBy(css = "#input-password + div")
	protected WebElement errmsgPassword;
	
	@FindBy(id = "input-confirm")
	protected WebElement textboxConfirm;
	
	@FindBy(css = "#content > form > fieldset:nth-child(3) > div > div > label")
	protected List<WebElement> radioNewsletter;
	
	@FindBy(name = "agree")
	protected WebElement checkboxAgree;
	
	@FindBy(css = "#account-register > div.alert.alert-danger.alert-dismissible")
	protected WebElement errmsgAgree;
	
	@FindBy(css = "#content > form > div > div > input.btn.btn-primary")
	protected WebElement btnContinue;
	
	public void register(String fName,String lName,String email,String tel,String pass,String confirm, boolean newsletter) {
		textboxFirstName.clear();
		textboxFirstName.sendKeys(fName);
		textboxLastName.clear();
		textboxLastName.sendKeys(lName);
		textboxEmail.clear();
		textboxEmail.sendKeys(email);
		textboxTelephone.clear();
		textboxTelephone.sendKeys(tel);
		textboxPassword.clear();
		textboxPassword.sendKeys(pass);
		textboxConfirm.clear();
		textboxConfirm.sendKeys(confirm);
		if(newsletter) {
			radioNewsletter.get(0).click();
		}else {
			radioNewsletter.get(1).click();
		}
		checkboxAgree.click();
		Wait.sleep(3);
		btnContinue.click();
	}
	
	public void registerValidation(String fName,String lName,String email,String tel,String pass,String confirm, boolean newsletter) {
		this.register(fName, lName, email, tel, pass, confirm, newsletter);
		
		if(fName.isEmpty()||fName.length()>32) {
			Assert.assertEquals(errmsgFirstName.getText(),"First Name must be between 1 and 32 characters!");
		}
		if(lName.isEmpty()||lName.length()>32) {
			Assert.assertEquals(errmsgLastName.getText(),"Last Name must be between 1 and 32 characters!");
		}
		if(email.isEmpty()|| !Assignments.isValidEmail(email)) {
			try {
				Assert.assertEquals(errmsgEmail.getText(),"E-Mail Address does not appear to be valid!");
			}catch(NoSuchElementException e) {
				Assert.assertTrue(false, "Email error message not displayed!");
			}
		}
		if(tel.isEmpty()|| !Assignments.isValidPhone(tel)) {
			try {
				Assert.assertEquals(errmsgTelephone.getText(),"Telephone must be between 3 and 32 characters!");
			}catch(NoSuchElementException e) {
				Assert.assertTrue(false, "Telephone error message not displayed!");
			}
		}
		if(!checkboxAgree.isSelected()) {
			Assert.assertEquals(errmsgAgree.getText(), " Warning: You must agree to the Privacy Policy!");
		}
	}
}
