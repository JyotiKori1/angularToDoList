package commonLib;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	
	/* This is Base class to configure and initialise framework */


     protected WebDriver driver;
     protected static Logger logger = LogManager.getLogger(BaseTest.class);  

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
    	
    	//initalise logger
    	BasicConfigurator.configure();  
    	
    	
    	//BROWSER => Chrome/firefox
    	//HUB_HOST => localhost/120.30.03/hostname
    	
    	String host="localhost";
    	new DesiredCapabilities();
    	DesiredCapabilities dc;
    	
         
    	logger.info("Initialzing Browser");
        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
   		 dc = DesiredCapabilities.firefox();
        	
        }else{
        	WebDriverManager.firefoxdriver().setup();
        	dc=DesiredCapabilities.firefox();
        }
        
        if(System.getProperty("HUB_HOST")!=null) {
        	host=System.getProperty("HUB_HOST");
        	System.out.println("The entered value for HUB_HOST is : " +host);
        }
        
        String completeUrl="http://"+host+":4444/wd/hub";
        
      
		 
		 URL url=new URL("http://"+host+":"+"4444"+"/wd/hub");
	        System.out.println("Complete Url :" +url);
	        this.driver=new RemoteWebDriver(url, dc);
	        System.out.println("Complete Url :" +url);
    	this.driver.get("http://todomvc.com/examples/angularjs/#/");
    }

    @AfterTest
    public void quitDriver() throws IOException, InterruptedException{
      this.driver.quit();
      
		
    }



}
