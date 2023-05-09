package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage
{
    WebDriver driver;

    @FindBy(xpath = "/html/body/header/div[2]/div/div[4]/a[3]")
    WebElement searchIcon;

    //@FindBy(id = "CustomerLogin-CustomerEmail")
    @FindBy(xpath = "//*[@id=\"SearchForm-Header-Query\"]")
    WebElement searchField;

    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void search(String query) throws InterruptedException
    {
        searchIcon.click();
        Thread.sleep(3000);
        searchField.sendKeys(query);
        Thread.sleep(3000);
    }
}
