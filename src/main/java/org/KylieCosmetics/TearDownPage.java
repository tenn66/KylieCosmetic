package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TearDownPage
{
    WebDriver driver;

    public TearDownPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void teardown()
    {
        driver.quit();
    }
}
