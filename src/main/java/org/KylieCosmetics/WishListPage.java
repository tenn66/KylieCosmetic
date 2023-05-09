package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage
{
    WebDriver driver;
    @FindBy(xpath = "//a[@class='site-header__action site-header__action--wishlist']")
    WebElement wishlist;

    public WishListPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void checkWishlist() throws InterruptedException
    {
        wishlist.click();
        Thread.sleep(3000);
    }
}
