import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by dharmens on 5/14/17.
 */

@RunWith(SerenityParameterizedRunner.class)
public class SimpleTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    private final String searchTerm;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"cats"},
                {"dogs"},
                {"ferrets"},
                {"rabbits"},
                {"canaries"}
        });
    }

    public SimpleTest(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Test
    public void startUp() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#lst-ib")).sendKeys(searchTerm);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector(".sfibbbc")).getText().contains(searchTerm));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
