package webframework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webframework.AbstractComponents.AbstractComps;

public class PaymentPage extends AbstractComps{

	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By selec=By.cssSelector(".ta-results");
	By submitBtn=By.cssSelector(".action__submit");
	
	@FindBy(xpath="//section/button[2]/span")
	WebElement Country_2;
	

	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement SelectCountry1;
	
	public void SelectCountry(String country) {
		Actions a=new Actions(driver);
		a.sendKeys(SelectCountry1, country).build().perform();
		waitForElementToAppear(selec);
		Country_2.click();
		ClickUsingJSExec(submitBtn);
		
		}
	
}
