package com.page;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement title;

    public LoginPage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    public void login(String name, String pass) {
        username.sendKeys(name);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public String getLoginTitle() {
        return title.getText();
    }
}
