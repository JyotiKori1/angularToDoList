package commonLib;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.internal.org.jline.utils.Log;

public class BaseTest {


     protected WebDriver driver;
     protected static Logger logger = LogManager.getLogger(BaseTest.class);  

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        
    	BasicConfigurator.configure();  
    	logger.info("Initialzing Browser");
        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
        	WebDriverManager.firefoxdriver().setup();
   		 driver = new FirefoxDriver();;
        	
        }else{
        	WebDriverManager.chromedriver().setup();
   		 driver = new ChromeDriver();
        }

    }

    @AfterTest
    public void quitDriver(){
      this.driver.quit();
    }



}
