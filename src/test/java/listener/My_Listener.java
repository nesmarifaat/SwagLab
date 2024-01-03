package listener;

import common.MyScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class My_Listener implements ITestListener {
    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
    }

    public void onTestFailure(ITestResult result) {
        // take screenshot on test failure
        takeScreenshot();
    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
        try {
            MyScreenRecorder.startRecording(context.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onFinish(ITestContext context) {
        try {
            MyScreenRecorder.stopRecording();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void takeScreenshot(){
        WebDriver driver=new ChromeDriver();
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate=new Date();
        String screenshotName=currntDate.toString().replace(" ","-").replace(":","-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/"+ screenshotName + ".png"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }
}
