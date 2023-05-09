package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct
{
    WebDriver driver;
    @FindBy(xpath = "//a[@title='Search']")
    WebElement searchBar;
    @FindBy(xpath = "//input[@id='SearchForm-Header-Query']")
    WebElement searchBox;
    @FindBy(xpath = "//button[@id='SearchForm-Header-Submit']")
    WebElement searchButton;
    public SearchProduct(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchFunctionality(String searchQuery) throws InterruptedException
    {
        searchBar.click();
        Thread.sleep(3000);
        searchBox.sendKeys(searchQuery);
        Thread.sleep(3000);
        searchButton.click();
        Thread.sleep(3000);
    }
}
