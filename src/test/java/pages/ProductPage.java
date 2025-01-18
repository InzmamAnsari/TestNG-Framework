package pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static testcases.TestCase.*;

public class ProductPage {

    WebDriver driver;

    public static SoftAssert sa;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String formal_shoes_xpath = "//h2[@class='FormalShoesTitle']";

    public static String sports_shoes_xpath = "//h2[@class='SportsShoesTitle']";

    public static String sneakers_xpath = "//h2[@class='SneakerShoesTitle']";

    public static String formal_shoes_dropdwn_xpath = "//i[@class='fa fa-angle-double-down formalshoedropdown']";
    public static String sports_shoes_dropdwn_xpath = "//i[@class='fa fa-angle-double-down sportsshoedropdown']";
    public static String sneakers_dropdwn_xpath = "//i[@class='fa fa-angle-double-down sneakershoedropdown']";
    public static String formal_shoes_firstProduct_xpath = "//table[@class = 'table table-striped thead-dark formalshoetable']/tbody/tr[1]/td[1]";
    public static String sports_shoes_firstProduct_xpath = "/html[1]/body[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]";
    public static String sneakers_firstProduct_xpath = "/html[1]/body[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]";

    public void formal_shoes_verify_title() throws IOException {
        String expected_title = "Formal Shoes";
        String actual_title = driver.findElement(By.xpath(formal_shoes_xpath)).getText();
        sa = new SoftAssert();
        sa.assertEquals(actual_title, expected_title);
        if (expected_title.equals(actual_title)) {
            test.log(Status.PASS, "test has passed for title verification");
            //test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver))+"Test Passed");
        } else {
            test.log(Status.FAIL, "test got fail for formal title verification");
        }
        sa.assertAll();
    }

    public void sports_shoes_verify_title() {
        String expected_title = "Sports Shoes";
        String actual_title = driver.findElement(By.xpath(sports_shoes_xpath)).getText();
        sa = new SoftAssert();
        sa.assertEquals(actual_title, expected_title);
        if (expected_title.equals(actual_title)) {
            test.log(Status.PASS, "test has passed for title verification");
        } else {
            test.log(Status.FAIL, "test got fail for sport shoe title verification");
        }
        sa.assertAll();
    }

    public void sneakers_verify_title() {
        String expected_title = "Sneakers";
        String actual_title = driver.findElement(By.xpath(sneakers_xpath)).getText();
        sa = new SoftAssert();
        sa.assertEquals(actual_title, expected_title);
        if (expected_title.equals(actual_title)) {
            test.log(Status.PASS, "test has passed for title verification");
        } else {
            test.log(Status.FAIL, "test got fail for sneakers title verification");
        }
        sa.assertAll();
    }

    public void formal_shoes_firstProduct_verify_title() {
        driver.findElement(By.xpath(formal_shoes_dropdwn_xpath)).click();
        String actual_title = driver.findElement(By.xpath(formal_shoes_firstProduct_xpath)).getText().trim();
        String expected_title = "Classic Cheltenham";
        sa = new SoftAssert();
        sa.assertEquals(actual_title, expected_title);
        if (expected_title.equals(actual_title)) {
            test.log(Status.PASS, "test has passed for formal shoe first product title verification");
        } else {
            test.log(Status.FAIL, "test got fail for formal shoe first product title verification");
        }
        sa.assertAll();
    }

    public void sports_shoes_firstProduct_verify_title() throws InterruptedException {
        //Thread.sleep(500);
        driver.findElement(By.xpath(sports_shoes_dropdwn_xpath)).click();
        String actual_title = driver.findElement(By.xpath(sports_shoes_firstProduct_xpath)).getText().trim();
        String expected_title = "Ultimate";
        sa = new SoftAssert();
        sa.assertEquals(actual_title, expected_title);
        if (expected_title.equals(actual_title)) {
            test.log(Status.PASS, "test has passed for sport shoes first product title verification");
        } else {
            test.log(Status.FAIL, "test got fail for  sport shoes first product title verification");
        }
        sa.assertAll();

    }

    public void sneakers_firstProduct_verify_title() {
        driver.findElement(By.xpath(sneakers_dropdwn_xpath)).click();
        String actual_title = driver.findElement(By.xpath(sneakers_firstProduct_xpath)).getText().trim();
        String expected_title = "Archivo";
        sa = new SoftAssert();
        sa.assertEquals(actual_title, expected_title);
        if (expected_title.equals(actual_title)) {
            test.log(Status.PASS, "test has passed for sneakers shoes first product title verification");
        } else {
            test.log(Status.FAIL, "test got fail for sneakers shoes first product title verification");
        }
        sa.assertAll();
    }
}
