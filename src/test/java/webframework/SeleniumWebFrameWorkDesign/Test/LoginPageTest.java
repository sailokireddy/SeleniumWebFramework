package webframework.SeleniumWebFrameWorkDesign.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import webframework.PageObjects.CartPage1;
import webframework.PageObjects.ConfirmPage;
import webframework.PageObjects.Homepge;
import webframework.PageObjects.PaymentPage;
import webframework.TestComponenets.BaseTest;

public class LoginPageTest extends BaseTest{

	@Test(dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String str="ZARA COAT 3";
		//LoginPage loginpage=launchApp();
		lpage.lPage(input.get("email"), input.get("paswrd"));
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
	public void ErrorValid() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String str="ZARA COAT 3";
		//LoginPage loginpage=launchApp();
		lpage.lPage("saistudent0806@gmacom", "Sn200");
		Assert.assertEquals("Incorrect email or password.",lpage.getErrorMessage());
		
	}
	
	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * HashMap<String, String> map=new HashMap<String, String>();
	 * map.put("email","saistudent080796@gmail.com"); map.put("paswrd",
	 * "S@chin200");
	 * 
	 * return new Object[][] {{map}}; }
	 */
	
	@DataProvider 
	public Object[][] getData() throws IOException {
		 
		  HashMap<String, String> map=new HashMap<String, String>();
		  map.put("email","saistudent080796@gmail.com"); 
		  map.put("paswrd","S@chin200");
		  List<HashMap<String, String>> data =getJsonToMap(System.getProperty("user.dir")+"//src//test//java//webframewwork//Data//TestData.json");
		  return new Object[][] {{data.get(0)}};
	
	
}
	
	
}
