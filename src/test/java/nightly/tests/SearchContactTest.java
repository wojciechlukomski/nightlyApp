package nightly.tests;

import nightly.pageObjects.AddressBookPage;
import nightly.pageObjects.BaseTest;
import nightly.pageObjects.LoggedPage;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class SearchContactTest extends BaseTest {
    
    private final String falseValidAddress = "FZpDQSLHSviKz6DZQt281JYvAEzSyv3PKgi3JcvRYDHy";
    private final String falseValidAddress2 = "EVED4fuPt9n6RPBBgEC2LcJF4j2oeqbsMTcmUyBsfGzo";
    private final String falseValidAddress3 = "mEtiHgKmcUx8fXQM574CzLaw1HytAxtR5fJeNZoTVR1";
    private final String falseValidAddress4 = "GBygY3h7e7EhCqtBJUFiZLvJrSDY4bT6HcBQUgCyXFkk";
    
    private final String validContactName = "Wojtek";
    
    LoggedPage loggedPage = new LoggedPage();
    AddressBookPage addressBookPage = new AddressBookPage();
    
    @Test(priority = 0, groups = {"addContacts"})
    public void addFourNewContactSearchTest() {
        loggedPage.goFromLoggedPageToAddContact();
        addressBookPage
                .deleteContact()
                .addNewContact()
                .fillUpNameAndAddress("Wojtek", falseValidAddress)
                .addNewContact()
                .fillUpNameAndAddress("Ananas345", falseValidAddress2)
                .addNewContact()
                .fillUpNameAndAddress("!!!woj;p;p", falseValidAddress3)
                .addNewContact()
                .fillUpNameAndAddress("teks34woJ!!", falseValidAddress4);
    }
    
    @Test(priority = 1, groups = {"negative"})
    public void oneLetterContactNameSearchTest() {
        addressBookPage.enterSearchInput("A");
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("Ananas345"));
    }
    
    @Test(priority = 2, groups = {"negative"})
    public void twoLetterContactNameSearchTest() {
        addressBookPage.enterSearchInput("An");
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("Ananas345"));
    }
    
    @Test(priority = 3, groups = {"negative"})
    public void threeLetterContactNameSearchTest() {
        addressBookPage.enterSearchInput("Ana");
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("Ananas345"));
    }
    
    @Test(priority = 4, groups = {"negative"})
    public void validCapitalLettersContactNameSearchTest() {
        addressBookPage.enterSearchInput("ANANAS345");
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("Ananas345"));
    }
    
    @Test(priority = 5, groups = {"negative"})
    public void invalidPrecededBySpecialCharacterContactNameSearchTest() {
        addressBookPage.enterSearchInput("!ananas345");
        MatcherAssert.assertThat(addressBookPage.getNoAddressesYetField().getText(), equalTo("No addresses yet..."));
    }
    
    @Test(priority = 6, groups = {"negative"})
    public void invalidPrecededByDigitContactNameSearchTest() {
        addressBookPage.enterSearchInput("8ananas345");
        MatcherAssert.assertThat(addressBookPage.getNoAddressesYetField().getText(), equalTo("No addresses yet..."));
    }
    
    @Test(priority = 7, groups = {"negative"})
    public void valid3LastCharactersContactNameSearchTest() {
        addressBookPage.enterSearchInput("345");
        MatcherAssert.assertThat(addressBookPage.getNewContactOnList().getText(), equalTo("Ananas345"));
    }
    
    @Test(priority = 8, groups = {"negative"})
    public void invalidIntoStringContactNameSearchTest() {
        addressBookPage.enterSearchInput("yadyyadyAnanas345asdasd");
        MatcherAssert.assertThat(addressBookPage.getNoAddressesYetField().getText(), equalTo("No addresses yet..."));
    }
}
