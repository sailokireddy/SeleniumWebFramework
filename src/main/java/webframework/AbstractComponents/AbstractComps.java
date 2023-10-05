package webframework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComps {

	
	WebDriver driver;
	public AbstractComps(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartBtn;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement OrderBtn;
	//By submitBtn;
	public void goToOrders() {
		OrderBtn.click();
	}
	public void goToCart() {
		cartBtn.click();
		
	}
	public void ClickUsingJSExec(By submitBtn) {
		JavascriptExecutor js = (JavascriptExecutor) driver;    		
        WebElement Element = driver.findElement(submitBtn);
        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
        js.executeScript("arguments[0].click();", Element);
	}
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
	}
	
	public void waitForWebElementToAppear(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Element));	
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}