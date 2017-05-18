import Pages.ClearTripHome;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.WithTag;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by dharmens on 5/14/17.
 */

@RunWith(SerenityRunner.class)
public class SimpleTest {

    @Managed(driver = "chrome")
    WebDriver driver;

    ClearTripHome clearTripHome;

    @WithTag(name="Manual:Audit")
    @Test
    public void startUp() throws InterruptedException {
        clearTripHome.open();
        Thread.sleep(5000);
        clearTripHome.chooseTravelPlan("New Delhi","Mumbai","23/05/2017","27/05/2017");
        Thread.sleep(2000);
        waitForAppReady(net.serenitybdd.core.annotations.findby.By.cssSelector(".progressTracker"));
        Assert.assertNotNull(driver.findElement(net.serenitybdd.core.annotations.findby.By.cssSelector(".resultsContainer")));
    }

    public void waitForAppReady(org.openqa.selenium.By locator){
        try{
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("Element with locator: "+locator+"not loaded:-"+e.getMessage());
        }
    }
}
