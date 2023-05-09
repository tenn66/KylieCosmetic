package org.KylieCosmetics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

public class SetUpPage
{
    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookieConsentButton;
    static WebDriver driver;
    public static WebDriver setupBrowser(String browser, String url)
    {
        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("safari"))
        {
            WebDriverManager.safaridriver().setup();
            driver=new SafariDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }
}