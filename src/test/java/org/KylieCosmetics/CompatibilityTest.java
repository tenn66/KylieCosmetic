package org.KylieCosmetics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompatibilityTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    TearDownPage tearDown;

    @Test (priority = 1)
    //@BeforeClass
    public void environmentTest()
    {
        driver = SetUpPage.setupBrowser("safari","https://kyliecosmetics.com/en-in");
        //compatibility = PageFactory.initElements(driver, Compatibility.class);
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
    }
    @Test(priority = 2)
    void setCookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    @Test(priority = 3)
    public void teardown()
    {
        tearDown.teardown();
    }
    @AfterMethod
    void takeScreenshotOnFailure(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {

            // Create the screenshot object
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            // Take the screenshot as a file
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            try
            {

                // Create a destination file with the current date and time as the filename
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
                String fileName = "screenshot" + dateFormat.format(new Date()) + ".png";
                File destination = new File("/Users/tenzinwangmo/Desktop/" + fileName);
                // Copy the source file to the destination file
                FileUtils.copyFile(source, destination);
                System.out.println("Screenshot taken and saved to: " + source + "  --->  " + destination);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}