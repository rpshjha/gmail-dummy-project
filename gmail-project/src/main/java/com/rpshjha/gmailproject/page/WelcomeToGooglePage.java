package com.rpshjha.gmailproject.page;

import com.rpshjha.gmailproject.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 21/09/21
 * Time: 7:53 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@Page
public class WelcomeToGooglePage {

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    @Autowired
    WebDriver driver;

    @Lazy
    @Autowired
    WebDriverWait wait;

    @FindBy(css = "input[type='email']")
    private WebElement recoveryEmail;

    @FindBy(css = "input[name='day']")
    private WebElement day;

    @FindBy(css = "select#month")
    private WebElement month;

    @FindBy(css = "input[name='year']")
    private WebElement year;

    @FindBy(css = "select#gender")
    private WebElement gender;

    @FindBy(xpath = "//button//span[text()='Next']")
    private WebElement next;


}
