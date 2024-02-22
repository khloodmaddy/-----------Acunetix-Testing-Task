package BaseTest;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://automationexercise.com/test_cases");
        driver.manage().window().maximize();
        goToHome();
    }
    public void goToHome(){
        homePage=new HomePage(driver);
    }
    @AfterTest
    public void tearDown(){
        if (driver==null){
            driver.quit();
        }
    }
}
