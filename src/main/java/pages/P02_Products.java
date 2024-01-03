package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.Random;

import static pages.PageBase.longWait;
import static utilities.Utility.generateRandomNumber;




public class P02_Products {
    WebDriver driver;


    public P02_Products(WebDriver driver) {
        this.driver = driver;
    }

    //TODO: Remove button locator and method

    private final By removebutton = By.xpath("//button[text()='REMOVE']");

    public Boolean validateifremovebuttondisplayed() {
        return driver.findElement(this.removebutton).getText().equals("REMOVE");

    }


    //TODO: price calculation
private final By randomproducts=By.xpath("//button[@class=\"btn_primary btn_inventory\"]");
   static double totalprice = 0.0;

    public P02_Products calculateprice() {

        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.randomproducts));
        }
        catch (TimeoutException exc){
            exc.printStackTrace();
        }
        for (int i = 1; i <= generateRandomNumber(); i++) {

            By.xpath("//div[@class='inventory_list']//div[" + i + "]//div[3]//button").findElement(driver).click();


            totalprice += Double.parseDouble(driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[" + i+ "]")).getText().replace("$", ""));


        }
        System.out.println("Total Price=$" + totalprice);
        return this;
    }


    //TODO:Remove one random product
    double insteadtotal=0.0;
    public void removeproduct()
    {
        Random random=new Random();
        //int temp=random.nextInt();
        driver.findElement(By.xpath("(//button[@class='btn_secondary btn_inventory']["+1+"])")).click();
        insteadtotal= Double.parseDouble(driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[" + 1+ "]")).getText().replace("$", ""));
       totalprice-=insteadtotal;
        System.out.println("instead total=$"+totalprice);

    }



    //TODO: Click on Shopping Cart locator and method

    private final By shoopingcart = By.xpath("//a[@href=\"./cart.html\"]");

    public P02_Products clickonshoppingcart() {
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.shoopingcart));
        }
        catch (TimeoutException exc){
            exc.printStackTrace();
        }
        driver.findElement(this.shoopingcart).click();
        return this;
    }
}




