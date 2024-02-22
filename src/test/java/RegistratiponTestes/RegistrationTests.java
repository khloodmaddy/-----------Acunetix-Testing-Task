package RegistratiponTestes;

import BaseTest.BaseTest;
import Pages.RegistrationPage;
import Pages.SignupOrLoginPage;
import net.datafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class RegistrationTests extends BaseTest {
    public static String randomFirstName = Faker.instance().name().firstName();
    public static String randomLastName = Faker.instance().name().firstName();
    static Random randomGenerator = new Random();
    static int randomInt = randomGenerator.nextInt(1000);
    public static String email = randomFirstName + randomLastName + randomInt + "@mailinator.com";

    @Test
    public void createAccountVerification() {
        SoftAssert softAssert = new SoftAssert();
        boolean homePageStatus = homePage.homepageAppearance();
        softAssert.assertTrue(homePageStatus, "homepage not opened correctly");
        SignupOrLoginPage signupOrLoginPage = homePage.openSignUp();
        boolean subtitleStatus = signupOrLoginPage.subTitleAppearance();
        softAssert.assertTrue(subtitleStatus, "subtitle not appears correctly");
        signupOrLoginPage.enterMail(email);
        signupOrLoginPage.enterName(randomFirstName);
        RegistrationPage registrationPage=signupOrLoginPage.clickSignUp();
        boolean addressStatus=registrationPage.addressSectionAppearance();
        softAssert.assertTrue(addressStatus, "address info not appears correctly");
        registrationPage.selectGender();
        registrationPage.enterPassword("22334466");
        registrationPage.selectFromDropDown("2","days");
        registrationPage.selectFromDropDown("July","months");
        registrationPage.selectFromDropDown("1996","years");
        registrationPage.enterFirstName(randomFirstName);
        registrationPage.enterLastName(randomLastName);
        registrationPage.setAddress("Nasr city/abas el aqad");
        registrationPage.selectFromDropDown("Canada","country");
        registrationPage.setZipCode("3753450");
        registrationPage.setMobile("01088776621");
        registrationPage.createAccount();

    }
}
