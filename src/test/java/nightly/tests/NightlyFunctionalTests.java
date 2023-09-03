package nightly.tests;

import nightly.pageObjects.AddressBookPage;
import nightly.pageObjects.BaseTest;
import nightly.pageObjects.LoggedPage;
import nightly.pageObjects.LoginPage;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class NightlyFunctionalTests extends BaseTest {
    
    private final String falseValidAddress = "Hnt46bpHYefLzHPPuoGSVKb7otqaFxSwJoJE1M61Yrp6";
    private final String invalidAddress = "Hnt46bpHYefLzHPPuoGSVKb7otqaFxSwJoJE1M61Yrp6";
    private final String validName = "wojtek";
    private final String validAddress = "12345678901234567890seven99";
    
    LoginPage loginPage = new LoginPage();
    LoggedPage loggedPage = new LoggedPage();
    AddressBookPage addressBookPage = new AddressBookPage();
    
    @Test(priority = 0, groups = {"beforeEveryTest"})
    public void positiveLoginTest() {
        loginPage
                .logIn();
    }
    
    @Test(priority = 1, groups = {"validName", "validAddress", "11"})
    public void validNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, validAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo(validName));
    }
    
    @Test(priority = 2, groups = {"validName", "invalidAddress", "10"})
    public void tooLongNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "Hnt46bpHYefLzHPPuoGSVKb7otqaFxSwJoJE1M61Yrp6");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 3, groups = {"validName", "invalidAddress", "10"})
    public void onlyLettersToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "qwertyuioplkjhgfdsazxcvbnmq");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 4, groups = {"validName", "invalidAddress", "10"})
    public void onlyDigitsToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "123456789012345678901234599");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 5, groups = {"validName", "invalidAddress", "10"})
    public void specialCharactersToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "ul.JanaKowalczyka-Grzyba23456");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 6, groups = {"validName", "invalidAddress", "10"})
    public void charactersWithSpacesToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "ul Jana Kowalczyka 12345678");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 7, groups = {"validName", "invalidAddress", "10"})
    public void tooShortAddressToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "12345678901234567890seven9");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 8, groups = {"validName", "invalidAddress", "10"})
    public void tooLongAddressToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "12345678901234567890seven991");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 9, groups = {"validName", "invalidAddress", "10"})
    public void emptyAddressToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 10, groups = {"validName", "invalidAddress", "10"})
    public void polishDiactricAddressToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "ulxJąnałKówałżźęaó123456789");
        
        MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect address!"));
    }
    
    @Test(priority = 11, groups = {"validName", "validAddress", "11"})
    public void validCapitalLettersAddressToNewContactAddressTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, "ULPJANAOKOWALCZYKAX12345678");
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo(validName));
    }
    
    @Test(priority = 13, groups = {"validName", "validAddress", "11"})
    public void validNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress(validName, falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo(validName));
    }
    
    @Test(priority = 14, groups = {"validName", "validAddress", "11"})
    public void validCapitalizeLetterNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("WOJTEK", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("WOJTEK"));
    }
    
    @Test(priority = 15, groups = {"validName", "validAddress", "11"})
    public void validOnlyDigitsNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("987654321", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("987654321"));
    }
    
    @Test(priority = 16, groups = {"validName", "validAddress", "11"})
    public void validSpecialCharactersNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("!@#$%^&*()", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("!@#$%^&*()"));
    }
    
    @Test(priority = 17, groups = {"validName", "validAddress", "11"})
    public void validOneCharacterPrecededBySpacesNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("        p", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("        p"));
    }
    
    @Test(priority = 18, groups = {"validName", "validAddress", "11"})
    public void validExactly15LettersNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("qwertyuioplkjhg", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("qwertyuioplkjhg"));
    }
    
    @Test(priority = 19, groups = {"validName", "validAddress", "11"})
    public void validPolishDiactricMarksNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("wójt żółć", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("wójt żółć"));
    }
    
    @Test(priority = 20, groups = {"validName", "validAddress", "11"})
    public void validDigitsLettersSpecialCharactersSpacesNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("  FedERER 20^^", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("  FedERER 20^^"));
    }
    
    @Test(priority = 21, groups = {"validName", "validAddress", "11"})
    public void validEOnlySpacesNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("     ", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("     "));
    }
    
    @Test(priority = 22, groups = {"validName", "validAddress", "11"})
    public void validEmptyInputNameNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("", falseValidAddress);
        
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo(""));
    }
    
    @Test(priority = 23, groups = {"invalidName", "validAddress", "01"})
    public void tooLongNewContactNameTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("qwertyuioplkjhgf", falseValidAddress);
        
            MatcherAssert.assertThat(addressBookPage.getError().getText(), equalTo("Incorrect name!"));
    }
    
    @Test(priority = 24, groups = {"emoji"})
    public void changeEmojiTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage.deleteContact();
        addressBookPage.changeEmojiAvatar();
        
        MatcherAssert.assertThat
                (addressBookPage.getEmojiMonkeyFaceImg().getAttribute("src"), equalTo("https://cdn.jsdelivr.net/npm/emoji-datasource-apple/img/apple/64/1f435.png"));
        
        addressBookPage.fillUpNameAndAddress(validName,falseValidAddress);
        MatcherAssert.assertThat
                (addressBookPage.getEmojiMonkeyFaceImg().getAttribute("src"), equalTo("https://cdn.jsdelivr.net/npm/emoji-datasource-apple/img/apple/64/1f435.png"));
        
    }
}
