package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    // long explicit wait
    public static WebDriverWait longWait(WebDriver driver){
        return new WebDriverWait(driver, 25);
    }

    // short explicit wait
    public static WebDriverWait shortWait(WebDriver driver){
        return new WebDriverWait(driver, 10);
    }

    public static void waitForPageLoad(WebDriver driver) {
        (new WebDriverWait(driver, (50))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                String readyState = js.executeScript("return document.readyState").toString();
                //System.out.println("Ready State: " + readyState);
                return (Boolean) readyState.equals("complete");
            }
        });
    }}
