package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import retrytest.Retry;

import static utilities.Utility.captureScreenshot;
import static utilities.Utility.generateDescription;

public class TC01_E2EPurchaseFlow extends TestBase {
    String username = "standard_user";
    String password = "secret_sauce";
    String desc = generateDescription();
    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String postalcode = faker.address().zipCode();

    @Test(priority = 1, description = "Add All Products to Cart", retryAnalyzer = Retry.class)
    public void addproductstocart_P() throws InterruptedException {

        new P01_Login(driver).fillusername(username).fillpassword(password).clickonloginbutton();
        new P02_Products(driver).calculateprice();
        new P02_Products(driver).clickonshoppingcart();
        new P03_Shoopingcart(driver).clickoncheckoutbutton();
        new P04_CheckOutInfo(driver).fillfirstname(firstname).filllastname(lastname).fillpostalcode(postalcode).clickoncontinuebutton();
        Assert.assertTrue(new P05_CheckoutReview(driver).checktotalpricebeforetax());
        new P05_CheckoutReview(driver).clickonfinishbutton();
        captureScreenshot(driver, "P_AddProduct_To_Cart");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new P06_Finish(driver).checkifimagevisible());
        softAssert.assertAll();



    }
}
