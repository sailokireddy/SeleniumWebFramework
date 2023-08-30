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
import webframework.TestComponenets.RetryListen;

public class ErrorValidations extends BaseTest{

	@Test(retryAnalyzer = RetryListen.class)
	public void ErrorValid() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String str="ZARA COAT 3";
		//LoginPage loginpage=launchApp();
		lpage.lPage("saistudent0806@gmacom", "Sn200");
		Assert.assertEquals("Incorrect email lr password.",lpage.getErrorMessage());
		
	}

}
