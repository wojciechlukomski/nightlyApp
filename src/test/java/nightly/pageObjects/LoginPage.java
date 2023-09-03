package nightly.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage {
    
    LoggedPage loggedPage = new LoggedPage();
    
    private final String baseUrl = "chrome-extension://fiikommddbeccaoicoejoniammnalkfa/src/pages/WebLogin/index.html";
    private final String secretPhrase = "fragile strategy guess crucial company anxiety donkey hip rough chair feel ancient kiwi aspect normal hello month moment alien scene board marble casino current";
    private final String password = "1234567";
    
    private final SelenideElement restoreWalletBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div[2]/div[2]/button/span"));
    private final SelenideElement secretPhraseArea = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div[3]/form/div/div[1]/div/div/textarea[1]"));
    
    private final SelenideElement restoreBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div[3]/form/div/div[3]/div/div[2]/button/span[1]"));
    
    private final SelenideElement passwordInput = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div[3]/form/div/div[1]/div/div[1]/div/div/input"));
    private final SelenideElement repeatedPasswordInput = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div[3]/form/div/div[1]/div/div[2]/div/div/input"));
    private final SelenideElement nextBtn = $(By.xpath(" //*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div[3]/form/div/div[2]/div/div[2]/button/span[1]"));
    
    private final SelenideElement wallet1CheckBox = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div/div/div/div/div[3]/div"));
    private final SelenideElement wallet2CheckBox = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div/div/div[1]/div/div[3]/div[2]/div/div/div/div/div[3]/div"));
    private final SelenideElement wallet3CheckBox = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div/div/div[1]/div/div[3]/div[3]/div/div/div/div/div[3]/div"));
    private final SelenideElement confirmBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div/div/div[2]/button/span[1]"));
    private final SelenideElement logIntoYourWalletBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[1]/div/div/div/div/div/div[2]/div[2]/div/div[2]/button/span[1]"));
    
    
   
    
    public LoginPage goToLoginPage() {
        open(baseUrl);
        getWebDriver().manage().window().maximize();
        return this;
    }
    
    public LoginPage logIn() {
        
        goToLoginPage();
        restoreWalletBtn.click();
        secretPhraseArea.setValue(secretPhrase);
        restoreBtn.click();
        passwordInput.setValue(password);
        repeatedPasswordInput.setValue(password);
        nextBtn.click();
        wallet1CheckBox.click();
        wallet2CheckBox.click();
        wallet3CheckBox.click();
        confirmBtn.click();
        
//        loggedPage.goToLoggedPage();
        return this;
    }
    
   
}
