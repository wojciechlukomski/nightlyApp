package nightly.pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddressBookPage {
    
    private final SelenideElement addContactBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/button"));
    private final SelenideElement nameInput = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/form/div/div[1]/div/input"));
    private final SelenideElement addressInput = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/form/div/div[1]/textarea"));
    private final SelenideElement submitAddContactBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/form/div/div[2]/button/span[1]"));
    private final SelenideElement error = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/form/div/div[1]/span"));
    private final SelenideElement newContactOnList = $(By.xpath(" //*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/div[3]/div/div[1]/span[1]"));
    private final SelenideElement editContactBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/div[3]/div/div[2]/span"));
    private final SelenideElement deleteContactBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/form/div/div[2]/button[1]"));
    private final SelenideElement emojiMonkeyFace = $(By.xpath("//*[@id=\"emojiPicker\"]/aside/div[2]/ul/li[3]/div[2]/button[1]"));
    private final SelenideElement emojiMonkeyFaceImg = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/div/div/img"));
    private final SelenideElement changeEmojiBtn = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/div/div"));
    private final SelenideElement changeEmojiAnimals = $(By.xpath("//*[@id=\"emojiPicker\"]/aside/div[1]/div[2]/button[3]"));
    private final SelenideElement noAddressesYetField = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/div[3]/span"));
    private final SelenideElement searchInput = $(By.xpath("//*[@id=\"app-container\"]/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div[2]/div[2]/input"));
    
    public SelenideElement getError() {
        return error;
    }
    public SelenideElement getEmojiMonkeyFace() {
        return emojiMonkeyFace;
    }
    public SelenideElement getEmojiMonkeyFaceImg() {
        return emojiMonkeyFaceImg;
    }
    public SelenideElement getNewContactOnList() {
        return newContactOnList;
    }
    
    public SelenideElement getNoAddressesYetField() {
        return noAddressesYetField;
    }
    
    public AddressBookPage fillUpNameAndAddress(String name, String address) {
        nameInput.setValue(name);
        addressInput.setValue(address);
        submitAddContactBtn.click();
        return this;
    }
    public AddressBookPage addNewContact(){
        addContactBtn.click();
        return this;
    }
    
    public AddressBookPage deleteContact() {
        if (editContactBtn.exists()) {
            editContactBtn.click();
            deleteContactBtn.click();
        }
        return this;
    }
    
    public AddressBookPage changeEmojiAvatar() {
        addContactBtn.click();
        changeEmojiBtn.click();
        changeEmojiAnimals.click();
        emojiMonkeyFace.click();
        
        return this;
    }
    
    public AddressBookPage enterSearchInput(String name) {
        searchInput.clear();
        searchInput.setValue(name);
        return this;
    }
}
