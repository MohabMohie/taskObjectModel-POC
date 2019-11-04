package gui.main.webmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;

public class WebMail {
    private static final String URL = "https://ej2.syncfusion.com/showcase/typescript/webmail/?_ga=2.192317357.682659301.1572873137-1227451190.1572873137#/home";
    private WebDriver driver;
    private static final By NEW_EMAIL_BUTTON = By.xpath("//button[contains(.,'New')]");

    public WebMail(WebDriver driver) {
	this.driver = driver;
    }

    public void navigateToURL() {
	BrowserActions.navigateToURL(driver, URL);
    }

    public EmailFolder selectEmailFolder(String type, String name) {
	By emailFolder = By.xpath("(//span[@class='treeName'][text()='" + type
		+ "']//following::span[@class='treeName'][text()='" + name + "'])[1]");
	ElementActions.click(driver, emailFolder);
	return new EmailFolder(driver);
    }

    public NewEmail createnewEmail() {
	ElementActions.click(driver, NEW_EMAIL_BUTTON);
	return new NewEmail(driver);
    }
}
