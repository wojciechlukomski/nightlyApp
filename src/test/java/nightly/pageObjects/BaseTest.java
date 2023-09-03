package nightly.pageObjects;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class BaseTest {
    
    LoginPage loginPage = new LoginPage();
    
    @BeforeTest(alwaysRun = true)
    public void setUpBrowser() {
        
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("app.crx"));
        WebDriver webDriver = new ChromeDriver(options);
        setWebDriver(webDriver);
    
        Selenide.switchTo().window(1);
        Selenide.closeWindow();
        Selenide.switchTo().window(0);
    
//        Configuration.timeout = 8000;
        Configuration.assertionMode = AssertionMode.SOFT;
    
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(false).savePageSource(true));
    
        loginPage.logIn();
    }
    
    @AfterTest
    public void afterMethodSetUp() {
//        WebDriverRunner.closeWebDriver();
    }
}






