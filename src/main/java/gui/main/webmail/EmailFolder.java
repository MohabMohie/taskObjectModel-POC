package gui.main.webmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class EmailFolder {
    private WebDriver driver;

    protected EmailFolder(WebDriver driver) {
	this.driver = driver;
    }

    public Email openEmail(String sender, String subjectContains) {
	By targetEmail = By.xpath("//div[contains(@class,'sender-style')][text()='" + sender
		+ "']//ancestor::li[@role='listitem']//div[contains(@class,'subjectstyle')][contains(.,'"
		+ subjectContains + "')]//ancestor::li");
	ElementActions.click(driver, targetEmail);
	return new Email(driver);
    }
}
