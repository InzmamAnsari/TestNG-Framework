package testcases;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.ProductPage;

import java.io.File;
import java.io.IOException;


public class TestCase extends BaseClass {
    HomePage hp;
    ProductPage pr;
    static ExtentReports report;
   public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeMethod
    public void productLink(){
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        hp = new HomePage(driver);
        pr = new ProductPage(driver);
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);
        hp.click_homeberger_menue();
        hp.click_online_product_link();
    }

    public static String capture(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("src/../ExecImages" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(srcFile,Dest);
        return errflpath;
    }


    @Test(priority = 1)
    public void verify_title() throws IOException {
        test = extent.createTest("Validate Shoe Title", "This test validates different shoe types are correct or not");
        pr.formal_shoes_verify_title();
        pr.sports_shoes_verify_title();
        pr.sneakers_verify_title();
    }

    @Test(priority = 2)
    public void verify_formal_shoe_firstProduct(){
        test = extent.createTest("Validate First Formal Shoe Title", "This test validates first formal shoe types are correct or not");
        pr.formal_shoes_firstProduct_verify_title();

    }

    @Test(priority = 3)
    public void verify_sport_shoe_firstProduct(){
        test = extent.createTest("Validate First Sport Shoe Title", "This test validates first sports shoe types are correct or not");
        pr.sports_shoes_firstProduct_verify_title();

    }

    @Test(priority = 4)
    public void verify_sneakers_firstProduct(){
        test = extent.createTest("Validate First Sneakers Shoe Title", "This test validates first  sneakers shoe types are correct or not");
        pr.sneakers_firstProduct_verify_title();
    }

    @AfterTest
    public void flush(){
        extent.flush();
    }

}
