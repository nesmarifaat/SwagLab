package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;

public class P04_CheckOutInfo {
    WebDriver driver;

    public P04_CheckOutInfo(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Firstname Locator and method

    private final By firstname = By.id("first-name");

    public P04_CheckOutInfo fillfirstname(String firstname) {
        try {
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstname));
        } catch (TimeoutException exc) {
            exc.printStackTrace();
        }
        driver.findElement(this.firstname).sendKeys(firstname);
        return this;
    }

    //TODO: lastname locator and method

    private final By lastname = By.id("last-name");

    public P04_CheckOutInfo filllastname(String lastname) {
        try {
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.lastname));
        } catch (TimeoutException exc) {
            exc.printStackTrace();
        }
        driver.findElement(this.lastname).sendKeys(lastname);
        return this;
    }


    //TODO:Postal code locator and method

    private final By postalcode = By.id("postal-code");

    public P04_CheckOutInfo fillpostalcode(String postalcode) {
        try {
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.postalcode));
        } catch (TimeoutException exc) {
            exc.printStackTrace();
        }
        driver.findElement(this.postalcode).sendKeys(postalcode);
        return this;
    }

    //TODO: continue button locator and method

    private final By continuebutton = By.xpath("//input[@class='btn_primary cart_button']");

    public P04_CheckOutInfo clickoncontinuebutton() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.continuebutton));
        } catch (TimeoutException exc) {
            exc.printStackTrace();
        }
        driver.findElement(this.continuebutton).click();
        return this;
    }
}
