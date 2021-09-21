package com.rpshjha.gmailproject.config;

import com.rpshjha.gmailproject.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 08/09/21
 * Time: 10:22 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@Lazy
@Configuration
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        String homedir = System.getProperty("user.home");
        String dir = homedir + "/Library/Application Support/Google/Chrome/selenium";
        options.addArguments("user-data-dir=" + dir);
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {

        WebDriverManager.firefoxdriver().setup();
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile testprofile = allProfiles.getProfile("selenium");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(testprofile);
        return new FirefoxDriver(options);
    }

}
