package com.rpshjha.gmailproject;

import com.rpshjha.gmailproject.entity.User;
import com.rpshjha.gmailproject.page.CreateAccountPage;
import com.rpshjha.gmailproject.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.concurrent.TimeUnit;

@EnableJpaRepositories
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class GmailProjectApplicationTests {

    @Lazy
    @Autowired
    WebDriver driver;

    @Value("${base.url}")
    private String url;

    @Lazy
    @Autowired
    private CreateAccountPage createAccountPage;

    @Lazy
    @Autowired
    private UserRepository repository;

    @BeforeAll
    public void setup() {
        this.driver.get(url);
        this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void createNewGmailAccount() throws InterruptedException {

        for (User temp : this.repository.findAll()) {
            System.out.println("Current user " + temp);

            this.createAccountPage.enterDetails(temp);
            this.createAccountPage.clickNext();
            Thread.sleep(10000);
            break;
        }
    }


    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/user_data.csv", numLinesToSkip = 1)
    public void createNewGmailAccount(int id, String firstname, String lastname, String username, String password, String dob, String gender, String recoveryemail, String recoveryphone) {
        System.out.print(firstname);
        System.out.print(lastname);
        System.out.print(recoveryemail);
        System.out.println();
    }

    @AfterAll
    public void tearDown() {
        this.driver.quit();
    }

}
