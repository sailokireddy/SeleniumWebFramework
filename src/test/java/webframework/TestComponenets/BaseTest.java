package webframework.TestComponenets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import webframework.PageObjects.LoginPage;

public class BaseTest {
	protected static WebDriver driver;
	public LoginPage lpage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\webframework\\resources\\GlobalData.properties");
		prop.load(file);
		String BrowserName=prop.getProperty("browser");
		System.out.println(BrowserName);
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;	
	}
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage launchApp() throws IOException {
		
		driver=initializeDriver();
		lpage=new LoginPage(driver);
		lpage.goTo();
				
		return lpage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void endTest() {
		driver.close();
	}
	
	
	@SuppressWarnings("deprecation")
	public List<HashMap<String, String>> getJsonToMap(String path) throws IOException {
		
		//read json to string
		String jsonContent=FileUtils.readFileToString(new File(path));
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String , String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String , String>>>(){});
		return data;
	}
	
	public String takescreenshot(String testcasename, WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
		FileUtils.copyFile(file, dest);
		return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
	}
	
	
}
