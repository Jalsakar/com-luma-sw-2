package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    @Before //Before annotation to st up code
    public void setUp() throws InterruptedException {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(2000);
        //Enter valid Email
        driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("shreedh2002@yahoo.co.uk");
        Thread.sleep(2000);
        //Enter valid Password
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Shreedh@2002");
        Thread.sleep(2000);
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@type='submit'and@class='action login primary']")).click();
        Thread.sleep(2000);
        //Verify the ‘Welcome, Disha Patel!’ text is display
        String expectedText = "Welcome, Disha Patel!";
        String actualText = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() throws InterruptedException {
        //Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(2000);
        //Enter Invalid Email
        driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("abc0000@yahoo.co.uk");
        Thread.sleep(2000);
        //Enter Invalid Password
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("abc000");
        Thread.sleep(2000);
        //Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@type='submit'and@class='action login primary']")).click();
        Thread.sleep(2000);
        //Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily.
        // Please wait and try again later.’
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@data-ui-id='message-error']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        //Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        Thread.sleep(2000);
        //Enter valid Email
        driver.findElement(By.xpath("//input[@name='login[username]']")).sendKeys("shreedh2002@yahoo.co.uk");
        Thread.sleep(2000);
        //Enter valid Password
        driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Shreedh@2002");
        Thread.sleep(2000);
        //Click on ‘Sign In’button
        driver.findElement(By.xpath("//button[@type='submit'and@class='action login primary']")).click();
        Thread.sleep(2000);
        //Verify the ‘Welcome, Disha Patel’text is display
        String expectedText = "Welcome, Disha Patel!";
        String actualText = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText();
        Assert.assertEquals(expectedText, actualText);
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
        Assert.assertEquals(expectedText1, actualTextAfterRun);
    }

    @After // Close annotation to close all browser
    public void tearDown() {
        closeBrowser();
    }
}