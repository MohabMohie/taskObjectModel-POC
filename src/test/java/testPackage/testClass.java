package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
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
    public void testMethod() {
	String actualEmailBody = webMail.selectEmailFolder("Favorites", "Inbox")
		.openEmail("Camden Mcmillan", "Reference Request").getEmailBody();
	Assertions.assertEquals("Hello Kerry Best,", actualEmailBody, AssertionComparisonType.CONTAINS,
		AssertionType.POSITIVE);
    }

    @BeforeClass
    public void beforeClass() {
	driver = BrowserFactory.getBrowser();
	webMail = new WebMail(driver);
	webMail.navigateToURL();
    }
}
