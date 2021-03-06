package com.sayem.selenium.pages;

import com.sayem.selenium.framework.BasePage;
import com.sayem.selenium.models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = USER_NAME_TEXT_FIELD_XPATH)
    WebElement userNameTextField;
    @FindBy(xpath = UPASSWORD_TEXT_FIELD_XPATH)
    WebElement passwordTextField;
    @FindBy(xpath = ULOGIN_BUTTON_XPATH)
    WebElement loginButton;
    @FindBy(xpath = REGISTER_LINK_XPATH)
    WebElement registerLink;

    public HomePage loginAs(User user) {
        userNameTextField.clear();
        userNameTextField.sendKeys(user.getUsername());
        //IExplorer fill automatically passwordTextField after userNameTextField was added, so clear it
        passwordTextField.clear();
        passwordTextField.sendKeys(user.getPassword());
        loginButton.click();
        return initPage(HomePage.class);
    }

    public RegisterPage registerNewUser() {
        registerLink.click();
        return initPage(RegisterPage.class);
    }

    public static final String USER_NAME_TEXT_FIELD_XPATH = "//input[@id='j_username']";
    public static final String UPASSWORD_TEXT_FIELD_XPATH = "//input[@id='j_password']";
    public static final String ULOGIN_BUTTON_XPATH = "//div[@class='form']/form/input";
    public static final String REGISTER_LINK_XPATH = "//a[contains(text(),'Register')]";
}
