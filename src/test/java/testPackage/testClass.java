package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import com.shaft.validation.Assertions.AssertionComparisonType;
import com.shaft.validation.Assertions.AssertionType;

import gui.main.webmail.WebMail;

public class testClass {
    private WebDriver driver;
    private WebMail webMail;

    @Test
    public void assertThatEmailBodyContainsTargetText() {
	String actualEmailBody = webMail.selectEmailFolder("Favorites", "Inbox")
		.openEmail("Camden Mcmillan", "Reference Request").getEmailBody();
	Assertions.assertEquals("Hello Kerry Best,", actualEmailBody, AssertionComparisonType.CONTAINS,
		AssertionType.POSITIVE);
    }

    @Test
    public void assertThatEmailWithCorrectInformationWillBeSentSuccessfully() {
	String emailSentMessage = webMail.createnewEmail().fillEmailContentAndSend("oleg oneil", "ila russo",
		"Test Subject", "Test Body");
	Assertions.assertEquals("Your mail has been sent successfully.", emailSentMessage,
		AssertionComparisonType.EQUALS, AssertionType.POSITIVE);
    }

    @BeforeClass
    public void beforeClass() {
	driver = BrowserFactory.getBrowser();
	webMail = new WebMail(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
	webMail.navigateToURL();
    }
}
