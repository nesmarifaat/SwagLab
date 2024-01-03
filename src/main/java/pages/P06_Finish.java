package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_Finish {
    WebDriver driver;

    public P06_Finish(WebDriver driver)
    {
        this.driver=driver;
    }

    //TODO: image locator and method

  private final By image=By.xpath("//img[@class='pony_express']");


   public Boolean checkifimagevisible()
    {
        return driver.findElement(this.image).isDisplayed();
    }
}
