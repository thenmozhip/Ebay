package cucumber.prjname.java.tests;

import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SharedDriver extends WebDriverException {

    static String driverPath = "C:\\EbayProject\\EBay\\src\\test\\resources\\drivers\\";
    private static WebDriver driver;

     @Before("~@noWebDriver")
     public static void setUp() throws Exception {

         String browser  = System.getProperty("browser");
         String key = browser;
         System.out.println("The environment tag is: "+"chrome");
         setChromeDriver();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }

    public static WebDriver getDriver() {

        if (driver == null) {
            throw new IllegalStateException("Selenium client is not initialised.");
        }

        return driver.switchTo().defaultContent();
    }

    public static void setChromeDriver() {
		System.out.println("Launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

}
