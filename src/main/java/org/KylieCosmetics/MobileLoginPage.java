package org.KylieCosmetics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileLoginPage
{
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/en-in/account/login']")
    WebElement loginIcon;

    @FindBy(xpath = "//*[@id=\"CustomerLogin-CustomerEmail\"]")
    WebElement emailField;

    @FindBy(xpath = "//*[@id=\"CustomerLogin-CustomerPassword\"]")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"CustomerLogin-Submit\"]")
    WebElement loginButton;

    public MobileLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password)
    {
        loginIcon.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
