package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static WebDriver driver;
    private By signupLocator=By.xpath("//*[contains(text(),' Signup / Login')]");
    private By titleLocator=By.xpath("//b[contains(text(),'Test Cases')]");

    public HomePage(WebDriver webDriver){
        this.driver=webDriver;
    }
    public static void waitForEl(By byEl){
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byEl));
    }
    public static boolean verifyElAppearance(By el){
        waitForEl(el);
        return driver.findElement(el).isDisplayed();
    }
    public boolean homepageAppearance(){
        return verifyElAppearance(titleLocator);
    }


    public SignupOrLoginPage openSignUp(){
        waitForEl(signupLocator);
        driver.findElement(signupLocator).click();
       return new SignupOrLoginPage(driver);
    }

}
