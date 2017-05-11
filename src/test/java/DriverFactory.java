import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by dharmens on 5/10/17.
 */

public class DriverFactory {

    @Managed(driver="chrome", uniqueSession = true)
    public static WebDriver driver;

    public static WebDriver getDriver(){
        Capabilities capabilities = DesiredCapabilities.chrome();
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1440, 900));
        return driver;
    }

}
