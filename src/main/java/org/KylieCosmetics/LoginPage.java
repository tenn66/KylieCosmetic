package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    WebDriver driver;

    @FindBy(xpath = "//a[@title='Account']")
    WebElement loginIcon;

    @FindBy(xpath = "//*[@id=\"CustomerLogin-CustomerEmail\"]")
    WebElement emailField;

    @FindBy(xpath = "//*[@id=\"CustomerLogin-CustomerPassword\"]")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"CustomerLogin-Submit\"]")
    WebElement loginButton;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginToWebsite(String email, String password) throws InterruptedException
    {
        loginIcon.click();
        Thread.sleep(2000);
        emailField.sendKeys(email);
        Thread.sleep(2000);
        passwordField.sendKeys(password);
        Thread.sleep(2000);
        loginButton.click();
        Thread.sleep(2000);
    }
}
