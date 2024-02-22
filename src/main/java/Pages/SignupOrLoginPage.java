package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Pages.HomePage.verifyElAppearance;
import static Pages.HomePage.waitForEl;

public class SignupOrLoginPage {
    private static WebDriver driver;
    private By subtitleLocator = By.xpath("//h2[contains(text(),'New User Signup!')]");
    private By nameLocator = By.xpath("//input[@data-qa='signup-name']");
    private By mailLocator = By.xpath("//input[@data-qa='signup-email']");
    private By buttonLocator = By.xpath("//button[@data-qa='signup-button']");

    public SignupOrLoginPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public boolean subTitleAppearance() {
        return verifyElAppearance(subtitleLocator);
    }
    public static void sendKey(By el, String text) {
        waitForEl(el);
        driver.findElement(el).sendKeys(text);
    }

    public void enterName(String name) {
    sendKey(nameLocator,name);
    }
    public void enterMail(String mail) {
        sendKey(mailLocator,mail);
    }
    public RegistrationPage clickSignUp(){
        waitForEl(buttonLocator);
      driver.findElement(buttonLocator).click();
      return new RegistrationPage(driver);

    }
}
