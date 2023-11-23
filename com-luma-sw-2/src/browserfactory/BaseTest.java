package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {
    //BaseURL
   public static String baseUrl = "https://magento.softwaretestingboard.com/";
    //Setup Browser - Launch the Browser
    static String browser = "Chrome";
    public static WebDriver driver;
    public void openBrowser(String baseUrl) throws InterruptedException {
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }else {
            System.out.println("Wrong Browser name");
        }
        //Open the Url into Browser
        driver.get(baseUrl);
        //Maximize the Browser
        driver.manage().window().maximize();
        //Give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Thread.sleep(2000);
    }
    public void closeBrowser(){
        //Close all the Browser
        driver.quit();
    }
}