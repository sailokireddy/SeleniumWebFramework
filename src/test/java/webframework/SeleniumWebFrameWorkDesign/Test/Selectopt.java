package webframework.SeleniumWebFrameWorkDesign.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectopt {
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://demoqa.com/select-menu");
	Select select =new Select(driver.findElement(By.id("oldSelectMenu")));
	List<WebElement> li=select.getOptions();
	System.out.println(li);
	
}
}
