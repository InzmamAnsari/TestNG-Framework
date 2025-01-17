package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseClass {

   public WebDriver driver;

    @BeforeSuite
    public void setup(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterSuite
    public void tearDown(){
     driver.close();
    }

}
