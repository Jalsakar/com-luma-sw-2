package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest {
    @Before
    public void setUp() throws InterruptedException {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSighInPageDisplay() throws InterruptedException {
        //Click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        Thread.sleep(2000);
        //Verify the text ‘Create New Customer Account’
        String expectedText = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        //Click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        Thread.sleep(2000);
        //Enter First name
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Disha");
        Thread.sleep(2000);
        //Enter Last name
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Patel");
        Thread.sleep(2000);
        //Enter Email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys(email());
        Thread.sleep(2000);
        //Enter Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("xyz@12345");
        Thread.sleep(2000);
        //Enter Confirm Password
        WebElement confirmedPassword = driver.findElement(By.name("password_confirmation"));
        confirmedPassword.sendKeys("xyz@12345");
        Thread.sleep(2000);
        //Click on Create an Account button
        WebElement createAnAccountButton = driver.findElement(By.xpath("//button[@title='Create an Account']"));
        createAnAccountButton.click();
        Thread.sleep(2000);
        //Verify the text 'Thank you for registering with Main Website Store.’
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[@data-bind = 'html: $parent.prepareMessageForHtml(message.text)']")).getText();
        Assert.assertEquals(expectedText,actualText);
        Thread.sleep(2000);
        //Click on down aero near Welcome
        WebElement downAeroNearWelcome = driver.findElement(By.xpath("//button[@type ='button']"));
        downAeroNearWelcome.click();
        Thread.sleep(2000);
        //Click on Sign Out link
        WebElement signOutLink = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']"));
        signOutLink.click();
        Thread.sleep(2000);
        //Verify the text ‘You are signed out’
        String expectedText1 = "You are signed out";
        WebElement actualText1 = driver.findElement(By.xpath("//*[text()='You are signed out']"));
        String actualTextAfterRun = actualText1.getText();
        Assert.assertEquals(expectedText1,actualTextAfterRun);
    }
    protected String email() {
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder email = new StringBuilder();
        Random rnd = new Random();

        while (email.length() < 7) {
            int index = (int) (rnd.nextFloat() * chars.length());
            email.append(chars.charAt(index));
        }
        String pre = email.toString() + "@test.com";
        return pre;
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
