import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
 * Created by dharmens on 5/16/17.
 */

@RunWith(SerenityParameterizedRunner.class)
public class SerenityBDDTest {
    @Managed(driver = "chrome")
    WebDriver driver;

    private final String searchTerm;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"cats"},
                {"dogs"}
        });
    }

    public SerenityBDDTest(String searchTerm){
        this.searchTerm = searchTerm;
    }

    @Given("I land on the google page")
    public void startUp() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(3000);
    }

    @When("When I enter the search term")
    public void enter_the_search_term() throws InterruptedException {
        driver.findElement(By.cssSelector("#lst-ib")).sendKeys(searchTerm);
        Thread.sleep(3000);
    }

    @Then("I can see the value specific results in the dropdown")
    public void can_see_the_value_specific_results(){
        Assert.assertTrue(driver.findElement(By.cssSelector(".sfibbbc")).getText().contains(searchTerm));
    }

    @Test
    public void executeSampleTest() throws InterruptedException,Throwable {
        startUp();
        enter_the_search_term();
        can_see_the_value_specific_results();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
