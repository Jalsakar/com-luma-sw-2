package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    @Before
    public void setUp() throws InterruptedException {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomenJacketsPage() throws InterruptedException {
        //Click on ‘Sale’ Menu tab
        WebElement sale = driver.findElement(By.xpath("//a[@id=\"ui-id-8\"]"));
        sale.click();
        Thread.sleep(2000);
        //Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        WebElement jackets = driver.findElement(By.linkText("Jackets"));
        jackets.click();
        Thread.sleep(2000);
        //Verify the text ‘Jackets’ is displayed
        String expectedText = "Jackets";
        String actualText = driver.findElement(By.xpath("//h1[@id=\"page-title-heading\"]")).getText();
        Assert.assertEquals(expectedText, actualText);
        //Count the Total Item Displayed on Page
        WebElement totalItemDisplayedOnPage = driver.findElement(By.xpath("//img[@class='product-image-photo']"));
        System.out.println("Total Item displayed on page: " + totalItemDisplayedOnPage.getSize());
        // Print the name of all items into console
        List<WebElement> nameOfAllItems = driver.findElements(By.tagName("img"));
        System.out.println("Name of all items" + nameOfAllItems.size());
        for (WebElement nameOfItem : nameOfAllItems) {
            System.out.println(nameOfItem.getText());
            System.out.println(nameOfItem.getAttribute("src"));
        }
        //Verify total 12 Items displayed on page
        String expectedItemsDisplayedOnPage = "12 Items";
        String actualItemsDisplayedOnPage = driver.findElement(By.xpath("//p[@id='toolbar-amount']")).getText();
        Assert.assertEquals(expectedItemsDisplayedOnPage, actualItemsDisplayedOnPage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
