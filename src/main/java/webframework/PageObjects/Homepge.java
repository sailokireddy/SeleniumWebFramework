package webframework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webframework.AbstractComponents.AbstractComps;

public class Homepge extends AbstractComps{

	WebDriver driver;
	public Homepge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".ng-animating")
	WebElement spinner;

	@FindBy(css=".mb-3")
	List<WebElement> Prods;

	By productsBy=By.cssSelector(".mb-3");
	By addToCart=By.xpath("//*[@id=\"products\"]/div[1]/div[2]/div[1]/div/div/button[2]");
	By toastmessage=By.cssSelector("#toast-container");

	

	public List<WebElement> hompageObjList() {

		waitForElementToAppear(productsBy);
		return Prods;
	}
	
	public WebElement getProductByName(String ProdctName) {
		WebElement prod=hompageObjList().stream().filter(a->a.findElement(By.cssSelector("b")).getText().equals(ProdctName)).findFirst().orElse(null);
		return prod;
	}

	public void addProduct(String productName) {
		getProductByName(productName).findElement(addToCart).click();
		waitForElementToAppear(toastmessage);
		waitForElementToDisappear(spinner);
		

	}
}
