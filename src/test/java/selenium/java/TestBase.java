package selenium.java;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	 
    //protected static ThreadLocal driver = new ThreadLocal<>();
 WebDriver driver;
    
 
    @Test
    public void setUp() throws Exception {
    	 WebDriver webDriver=Library.launchChrome("https://letskodeit.teachable.com/p/practice");
       // WebDriver webDriver = //new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"));
        webDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
       // driver.set(webDriver);
    }
 
    @After
    public void tearDown() {
       //s getDriver().quit();
    }
 
    //@AfterClass
    public static void remove() {
       // driver.remove();
    }
 
}