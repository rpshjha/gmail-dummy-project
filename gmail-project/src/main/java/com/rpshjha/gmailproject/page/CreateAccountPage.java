package com.rpshjha.gmailproject.page;

import com.rpshjha.gmailproject.annotation.Page;
import com.rpshjha.gmailproject.entity.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 08/09/21
 * Time: 10:13 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@Page
public class CreateAccountPage {

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    @Autowired
    WebDriver driver;

    @Lazy
    @Autowired
    WebDriverWait wait;

    @FindBy(css = "input#firstName")
    private WebElement firstname;

    @FindBy(css = "input#lastName")
    private WebElement lastname;

    @FindBy(css = "input#username")
    private WebElement username;

    @FindBy(css = "input[name='Passwd']")
    private WebElement password;

    @FindBy(css = "input[name='ConfirmPasswd']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button//span[text()='Next']")
    private WebElement next;


    public void enterDetails(User user) {
        this.wait.until(ExpectedConditions.urlContains("signup"));

        sendKeys(this.firstname, user.getFirstname());
        sendKeys(this.lastname, user.getLastname());
        sendKeys(this.username, user.getUsername());
        sendKeys(this.password, user.getPassword());
        sendKeys(this.confirmPassword, user.getPassword());

//        this.firstname.sendKeys(user.getFirstname());
//        this.lastname.sendKeys(user.getLastname());
//        this.username.sendKeys(user.getUsername());
//        this.password.sendKeys(user.getPassword());
//        this.confirmPassword.sendKeys(user.getPassword());
    }

    public void clickNext() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.next)).click();
    }

    private void sendKeys(WebElement element, String text) {
        Random r = new Random();
        for (int i = 0; i < text.length(); i++) {
            try {
                Thread.sleep((int) (r.nextGaussian() * 15 + 100));
            } catch (InterruptedException e) {
            }
            String s = new StringBuilder().append(text.charAt(i)).toString();
            element.sendKeys(s);
        }
        return;
    }


}
