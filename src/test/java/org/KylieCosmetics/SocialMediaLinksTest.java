package org.KylieCosmetics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocialMediaLinksTest
{
    private WebDriver driver;
    JavascriptExecutor js;
    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://kyliecosmetics.com/en-in");
        driver.manage().window().maximize(); //Full screen.

        js = (JavascriptExecutor) driver;
    }
    @Test(priority = 1)
    public void CookieConsent()
    {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }

    @Test(priority = 2)
    public void facebookTest() throws InterruptedException
    {
        js.executeScript("window.scrollTo(0,5500)");
        Thread.sleep(3000);

        //driver.findElement(By.xpath("//div[@class='social-icon']/a[@arial-label='Facebook']")).click(); //img[@alt='Facebook']
        //driver.findElement(By.xpath("img[@alt='Facebook']")).click(); //img[@alt='Facebook']
        driver.findElement(By.cssSelector(".social-icon:nth-child(1) img")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void instagramTest() throws InterruptedException
    {
        driver.findElement(By.cssSelector(".social-icon:nth-child(2) img")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 4)
    public void twitterTest() throws InterruptedException
    {
        driver.findElement(By.cssSelector(".social-icon:nth-child(3) img")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
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
