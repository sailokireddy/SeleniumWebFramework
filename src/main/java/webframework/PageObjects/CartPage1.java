package webframework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webframework.AbstractComponents.AbstractComps;

public class CartPage1 extends AbstractComps{
	WebDriver driver;
	public CartPage1(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//li[@class='totalRow']/button")
	WebElement checkOutBtn;
	
	public Boolean getCartItems(String ProdctName) {
		Boolean Pd=cartProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(ProdctName));
		return Pd;
	}
	
	public PaymentPage goToPayment() {
	
		checkOutBtn.click();
		return new PaymentPage(driver);
	}

	
}
