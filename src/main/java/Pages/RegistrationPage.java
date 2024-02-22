package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static Pages.HomePage.verifyElAppearance;
import static Pages.HomePage.waitForEl;
import static Pages.SignupOrLoginPage.sendKey;

public class RegistrationPage {
    private WebDriver driver;
    private By maleGender = By.id("#id_gender1");
    private By passwordLocator = By.id("password");
    private By daysLocator = By.id("days");
    private By monthsLocator = By.id("months");
    private By yearsLocator = By.id("years");
    private By countryLocator = By.id("country");
    private By addressSectionLocator = By.xpath("//b[contains(text(),'Address Information')]");
    private By fName = By.id("first_name");
    private By lName = By.id("last_name");
    private By addressLocator = By.id("address1");
    private By stateLocator = By.id("state");
    private By cityLocator = By.id("state");
    private By zipCodeLocator = By.id("zipcode");
    private By mobileLocator = By.id("mobile_number");
    private By createAccountLocator = By.xpath("//button[@data-qa='create-account']");


    public RegistrationPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void selectGender() {
        waitForEl(maleGender);
        driver.findElement(maleGender).click();
    }

    public void enterPassword(String password) {
        sendKey(passwordLocator, password);
    }

    public void selectFromDropDown(String option, String menu) {
        findDropDownElement(menu).selectByVisibleText(option);
    }

    private Select findDropDownElement(String menu) {
        if (menu == "days") {
            return new Select(driver.findElement(daysLocator));
        } else if (menu == "months") {
            return new Select(driver.findElement(monthsLocator));
        } else if (menu == "years") {
            return new Select(driver.findElement(yearsLocator));
        } else {
            return new Select(driver.findElement(countryLocator));
        }

    }

    public void enterFirstName(String firstName) {
        sendKey(fName, firstName);
    }

    public void enterLastName(String lastName) {
        sendKey(lName, lastName);
    }

    public void setAddress(String address) {
        sendKey(addressLocator, address);
    }

    public void setState(String state) {
        sendKey(stateLocator, state);
    }

    public void cityState(String city) {
        sendKey(cityLocator, city);
    }

    public void setZipCode(String zipCode) {
        sendKey(zipCodeLocator, zipCode);
    }

    public void setMobile(String mobile) {
        sendKey(mobileLocator, mobile);
    }

    public boolean addressSectionAppearance() {
        return verifyElAppearance(addressSectionLocator);
    }

    public void createAccount() {
        driver.findElement(createAccountLocator).click();
    }

}
