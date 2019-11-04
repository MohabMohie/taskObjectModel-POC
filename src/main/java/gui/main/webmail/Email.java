package gui.main.webmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class Email {
    private WebDriver driver;
    private static final By EMAIL_BODY = By.id("accContent");

    protected Email(WebDriver driver) {
	this.driver = driver;
    }

    public String getEmailBody() {
	return ElementActions.getText(driver, EMAIL_BODY);
    }
}
