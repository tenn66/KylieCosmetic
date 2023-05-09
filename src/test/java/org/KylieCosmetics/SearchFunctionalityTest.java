package org.KylieCosmetics;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchFunctionalityTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    SearchProduct searchFunctionality;
    TearDownPage tearDown;

    @Test(priority = 1)
    public void environmentTest()
    {
        driver = SetUpPage.setupBrowser("chrome","https://kyliecosmetics.com/en-in");
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        searchFunctionality = PageFactory.initElements(driver, SearchProduct.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
    }
    @Test(priority = 2)
    void setCookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    /*@Test(priority = 3)
    public void SearchFunctionality() throws InterruptedException
    {
        searchFunctionality.searchFunctionality("lipstick");

        String expectedURL = "https://kyliecosmetics.com/en-in";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }*/
    @Test(priority = 3)
    public void verifySearch()
    {
        driver.findElement(By.xpath("//a[@title='Search']")).click();
        //WebElement searchBox = driver.findElement(By.xpath("//a[@title='Search']"));
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("lipstick", Keys.ENTER);

        String expectedURL = "https://kyliecosmetics.com/en-in/search?q=lipstick";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test(priority = 4)
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
