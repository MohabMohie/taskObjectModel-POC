package gui.main.webmail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import com.shaft.gui.element.ElementActions;

public class NewEmail {
    private WebDriver driver;
    private static final By TO_BUTTON = By.id("btnTo");
    private static final By CC_BUTTON = By.id("btnCc");
    private static final By SUBJECT_INPUT = By.id("txtSubject");
    private static final By BODY_INPUT = By.id("mailContentMessage");
    private static final By SEND_BUTTON = By.xpath("//div[@id='toolbar_newmail']//button[contains(.,'Send')]");
    private static final By SENT_EMAIL_LABEL = By.xpath("//div[@id='sentMailDialog']//span");

    protected NewEmail(WebDriver driver) {
	this.driver = driver;
    }

    public String fillEmailContentAndSend(String toFullName, String ccFullName, String subject, String body) {
	By toInput = RelativeLocator.withTagName("input").toRightOf(TO_BUTTON).above(CC_BUTTON);
	ElementActions.type(driver, toInput, toFullName);
	ElementActions.keyPress(driver, toInput, Keys.ENTER);
	By ccInput = RelativeLocator.withTagName("input").toRightOf(CC_BUTTON).below(TO_BUTTON);
	ElementActions.type(driver, ccInput, ccFullName);
	ElementActions.keyPress(driver, ccInput, Keys.ENTER);
	ElementActions.type(driver, SUBJECT_INPUT, subject);
	ElementActions.type(driver, BODY_INPUT, body);
	ElementActions.click(driver, SEND_BUTTON);
	return ElementActions.getText(driver, SENT_EMAIL_LABEL);
    }

}
