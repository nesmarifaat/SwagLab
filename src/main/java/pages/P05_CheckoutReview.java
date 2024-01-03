package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.P02_Products.totalprice;

public class P05_CheckoutReview {
    WebDriver driver;

    public P05_CheckoutReview(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Finish button locator and method

    private final By finishbutton = By.xpath("//a[@class='btn_action cart_button']");

    public P05_CheckoutReview clickonfinishbutton() {
        driver.findElement(this.finishbutton).click();
        return this;
    }


    //TODO: Total price without Taxs

    private final By itemtotalprice = By.xpath("//div[@class='summary_subtotal_label']");
    Double itemprice;

    public Boolean checktotalpricebeforetax() {
        return driver.findElement(this.itemtotalprice).getText().equals("Item total: $" + totalprice);


    }

}
