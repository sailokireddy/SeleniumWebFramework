package webframework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webframework.AbstractComponents.AbstractComps;

public class LoginPage extends AbstractComps{

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement userid;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement pwd;
	
	@FindBy(css=".ng-star-inserted")
	WebElement errorMesage;
	
	public void lPage(String usrid,String pswerd) throws InterruptedException {
		//Thread.sleep(3000);
		userid.sendKeys(usrid);
		//Thread.sleep(4000);
		pwd.sendKeys(pswerd);
		loginBtn.click();
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMesage);
		return errorMesage.getText();
		}
}
