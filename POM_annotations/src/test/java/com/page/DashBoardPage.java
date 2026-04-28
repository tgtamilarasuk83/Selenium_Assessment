package com.page;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {

    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement dashboardText;

    public DashBoardPage(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    public String getHometext() {
        return dashboardText.getText();
    }
}
