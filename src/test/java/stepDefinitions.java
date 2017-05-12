import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by dharmens on 5/9/17.
 */
public class stepDefinitions extends SerenityTest {

    @Given("^I navigate to the cleartrip homepage$")
    public void i_navigate_to_the_cleartrip_homepage() throws Throwable {
        driver.get("https://cleartrip.com");
    }

    @Given("^choose the round trip option$")
    public void choose_the_round_trip_option() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("#RoundTrip")).click();
    }

    @Given("^I have selected from and to options$")
    public void i_have_selected_from_and_to_option() throws Throwable {
        driver.findElement(By.cssSelector("#FromTag")).sendKeys("New Delhi, IN - Indira Gandhi Airport (DEL)");
        driver.findElement(By.cssSelector("#ToTag")).sendKeys("Hyderabad, IN - Rajiv Gandhi International (HYD)");
        driver.findElement(By.cssSelector("#DepartDate")).sendKeys(getDate(1), Keys.TAB);
    }

    @When("^I click on search flights$")
    public void click_on_search_flights() throws Throwable {
        driver.findElement(By.cssSelector("#SearchBtn")).click();
    }

    @Then("^list of flight options will be visible$")
    public void the_shipping_cost_should_be_included_in_the_total_price() throws Throwable {
        waitForAppReady(org.openqa.selenium.By.cssSelector(".progressTracker"));
        Assert.assertNotNull(driver.findElement(By.cssSelector(".resultsContainer")));

    }

    @When("^I select flight with \"([^\"]*)\" and \"([^\"]*)\" options$")
    public void select_flight_from_and_to_options(String arg1, String arg2) throws Throwable {
        driver.findElement(By.cssSelector("#FromTag")).sendKeys(arg1);
        driver.findElement(By.cssSelector("#ToTag")).sendKeys(arg2);
        driver.findElement(By.cssSelector("#DepartDate")).sendKeys(getDate(1), Keys.TAB);
        driver.findElement(By.cssSelector("#ReturnDate")).sendKeys(getDate(4), Keys.TAB);
    }

    @When("^I select flights with \"([^\"]*)\" and \"([^\"]*)\" options$")
    public void selects_flights_with_options(String arg1, String arg2) throws Throwable {
        driver.findElement(By.cssSelector("#FromTag")).sendKeys(arg1);
        driver.findElement(By.cssSelector("#ToTag")).sendKeys(arg2);
        driver.findElement(By.cssSelector("#DepartDate")).sendKeys(getDate(1), Keys.TAB);
        driver.findElement(By.cssSelector("#ReturnDate")).sendKeys(getDate(4), Keys.TAB);
    }

    public String getDate(int Days){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, Days);
        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        return simple.format(cal.getTime());
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
