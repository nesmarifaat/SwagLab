package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;


import static pages.PageBase.longWait;

public class P01_Login {
    WebDriver driver;

    public P01_Login(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Username field locator and method

    private final By username = By.id("user-name");

    public P01_Login fillusername(String username) {
        driver.findElement(this.username).sendKeys(username);
        return this;
    }


    //TODO: Password field locator and method

    private final By password = By.id("password");

    public P01_Login fillpassword(String password) {

        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.password));
        }
        catch (TimeoutException exc){
            exc.printStackTrace();
        }
        driver.findElement(this.password).sendKeys(password);
        return this;
    }

    //TODO: login button locator and password

    private final By loginbutton=By.id("login-button");

    public P01_Login clickonloginbutton()
    {
        try{
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.loginbutton));
        }
        catch (TimeoutException exc){
            exc.printStackTrace();
        }

        driver.findElement(this.loginbutton).click();
        return this;
    }

    //TODO: product page locator and method

    private final By productpage=By.xpath("//div[@class='product_label']");
    public Boolean validateloginsuccessfully()
    {
        return driver.findElement(this.productpage).getText().equals("Products");
    }

//********************************************************************************************
    //TODO:Current URL  method assertion method

    public Boolean checkcurrenturl()
    {
        return driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html");
    }

//********************************************************************************************

    private final By addtocart=By.xpath("//button[@class='btn_primary btn_inventory']");

    public Boolean checkifaddtocartvisible()
    {

        return driver.findElement(this.addtocart).isDisplayed();
    }



}
