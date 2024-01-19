import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;

public class TestNotepad {
    public WindowsDriver driver = null;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities cap = new DesiredCapabilities();

        //Open notepad.
        cap.setCapability("app", "c:\\Windows\\System32\\notepad.exe");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "WindowsPC");

        try {
            // create webdriver instance
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // provide implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown(){
        System.out.println("Executed");
    }

    @Test
    public void CreateNotepadFile() {
        WebElement element = driver.findElementByName("Text editor");
        element.sendKeys("this is my poc using APM.");
        element.sendKeys("now i will automatically click on file menu.");
        WebElement fileMenu = driver.findElementByName("File");
        
        //Clicking file menu.
        fileMenu.click();
        System.out.println("Executed");
    }
}