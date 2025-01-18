package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static String homeberger_menue_xpath = "//input[@type='checkbox']";

    public static String online_product_link_xpath = "//li[normalize-space()='Online Products']";

    public void click_homeberger_menue() {
        driver.findElement(By.xpath(homeberger_menue_xpath)).click();
    }

    public void click_online_product_link() {
        driver.findElement(By.xpath(online_product_link_xpath)).click();

    }

}
