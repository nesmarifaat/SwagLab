package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static pages.PageBase.longWait;
import static utilities.Utility.generateRandomNumber;

public class P03_Shoopingcart {

    WebDriver driver;

    public P03_Shoopingcart(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Checkout button locator and method

    private final By checkout = By.xpath("//a[@href=\"./checkout-step-one.html\"]");

    public P03_Shoopingcart clickoncheckoutbutton() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.checkout));
        } catch (TimeoutException exc) {
            exc.printStackTrace();
        }
        driver.findElement(this.checkout).click();
        return this;
    }


    //TODO: remove button locator and method

    private final By removebutton = By.xpath("//button[@class='btn_secondary cart_button']");

    public P03_Shoopingcart clickonremovebutton() throws InterruptedException {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.removebutton));
        } catch (TimeoutException exc) {
            exc.printStackTrace();
        }
        driver.findElement(this.removebutton);
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().refresh();

        return this;

    }
}
