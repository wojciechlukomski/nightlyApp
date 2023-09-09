package nightly.tests;

import nightly.pageObjects.BaseTest;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class AvatarEmojiTest extends BaseTest {
    
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
