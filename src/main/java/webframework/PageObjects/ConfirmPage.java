package webframework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webframework.AbstractComponents.AbstractComps;

public class ConfirmPage extends AbstractComps{

	
	
	WebDriver driver;
	
	public ConfirmPage(WebDriver driver) {
		super(driver);
		driver=this.driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement textHead;
	
	public String validateTitle() {
		
		return textHead.getText();
	}
	
}
