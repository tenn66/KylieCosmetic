package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage
{
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"uid-41-ProductTile-Title\"]")
    WebElement productDetails;
    public ProductDetailsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void getProductDetails()
    {
        productDetails.click();
    }
}
