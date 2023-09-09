package nightly.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoggedPage {
    
    private final String loggedUrl = "chrome-extension://fiikommddbeccaoicoejoniammnalkfa/src/pages/ExtensionRoot/index.html";
    
    private final SelenideElement menuBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[1]/div/div[1]/div/div[1]"));
    private final SelenideElement settingsBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[4]/div[3]/div/div[3]/button[1]"));
    private final SelenideElement addressBookBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div[2]/div[7]/button/span[1]"));
    
    public LoggedPage goToLoggedPage() {
        open(loggedUrl);
        getWebDriver().manage().window().maximize();
        return this;
    }
    
    public LoggedPage goToAddressBook() {
        menuBtn.click();
        settingsBtn.click();
        addressBookBtn.click();
        return this;
    }
    
    public LoggedPage goFromLoggedPageToAddContact() {
        goToLoggedPage();
        goToAddressBook();
        return this;
    }
}
