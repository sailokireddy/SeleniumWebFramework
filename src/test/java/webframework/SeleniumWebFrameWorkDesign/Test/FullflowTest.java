package webframework.SeleniumWebFrameWorkDesign.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import webframework.PageObjects.CartPage1;
import webframework.PageObjects.ConfirmPage;
import webframework.PageObjects.Homepge;
import webframework.PageObjects.LoginPage;
import webframework.PageObjects.PaymentPage;
import webframework.TestComponenets.BaseTest;

public class FullflowTest extends BaseTest{

	
	
	
	@Test
	public void submitOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String str="ZARA COAT 3";
		//LoginPage loginpage=launchApp();
		lpage.lPage("saistudent080796@gmail.com", "S@chin200");
		Homepge homepageO=new Homepge(driver);
		List<WebElement> products=homepageO.hompageObjList();
		homepageO.addProduct(str);
		homepageO.goToCart();
		CartPage1 cartP=new CartPage1(driver);
		Boolean bl=cartP.getCartItems(str);
		Assert.assertTrue(bl);
		cartP.goToPayment();
		PaymentPage payment=new PaymentPage(driver);
		payment.SelectCountry("india");
		ConfirmPage confirm=new ConfirmPage(driver);
		String strHead=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(strHead.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.quit();

	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
	
		System.out.println("Picked depends test");
		
	}

}
