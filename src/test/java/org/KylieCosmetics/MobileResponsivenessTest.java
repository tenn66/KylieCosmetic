package org.KylieCosmetics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MobileResponsivenessTest
{
    WebDriver driver;
    CookieConsentPage cookieConsent;
    TearDownPage tearDown;
    MobileLoginPage login;
    SearchPage search;

    @BeforeTest
    public void setUp() throws Exception
    {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // navigate to website
        driver.get("https://kyliecosmetics.com/en-in");
        // resize window to mobile device screen size
        driver.manage().window().setSize(new Dimension(360, 740));
        Thread.sleep(1000);
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //driver = new ChromeDriver(capabilities);
        cookieConsent = PageFactory.initElements(driver, CookieConsentPage.class);
        tearDown = PageFactory.initElements(driver, TearDownPage.class);
        login = PageFactory.initElements(driver, MobileLoginPage.class);
        search = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test(priority = 1)
    public void CookieConsent()
    {
        cookieConsent.clickCookieConsentButton();
    }
    @Test(priority = 2)
    public void menuIcon() throws InterruptedException
    {
        // check that website elements are displayed correctly
        WebElement menuIcon = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[3]/a"));
        Assert.assertTrue(menuIcon.isDisplayed());
        Thread.sleep(2000);

        menuIcon.click();
    }
    @Test(priority = 3)
    public void setLogin()
    {
        try
        {
            WebElement accountIcon = driver.findElement(By.xpath("//a[@href='/en-in/account/login']"));
            if (((WebElement) accountIcon).isDisplayed())
            {
                Assert.assertTrue(accountIcon.isDisplayed());
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException | InterruptedException e)
        {
            // Handle exception if the element is not found
        }
        login.login("jivadixit1@gmail.com","Smita@0987");
    }
    public void search() throws InterruptedException
    {
        search.search("eyeliner");
    }
    @AfterTest
    public void tearDown() throws Exception
    {
        //driver.quit();
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
