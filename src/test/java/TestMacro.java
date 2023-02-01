import java.util.concurrent.TimeUnit;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.*;
import java.util.*;

public class TestMacro {
    public static WindowsDriver driver = null;
    
    @BeforeClass
    public void setUp() throws Exception {
        LtWinDriver.start();
    }
    
    @Test
    public static void test() throws Exception {
        String appPath = "testing.xltm";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", appPath);
        cap.setCapability("ms:waitForAppLaunch", 30);
        cap.setCapability("appArguments", " /m ");
        cap.setCapability("ms:experimental-webdriver", true);

        try {
            // Block of code to try
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
        } catch (Exception e) {
            // Block of code to handle errors
            System.out.println("Something went wrong.");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
        }
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        try {
            driver.findElement(By.name("Enable Content")).click();
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.findElement(By.name("Rectangle: Rounded Corners 2")).click();
        
        
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.name("B10")).click();
        driver.findElement(By.name("Formula Bar")).sendKeys("10");
        driver.findElement(By.name("B11")).click();
        driver.findElement(By.name("Formula Bar")).sendKeys("20");
        driver.findElement(By.name("B12")).click();
        driver.findElement(By.name("Formula Bar")).sendKeys("=SUM(B10,B11)");
        driver.findElement(By.name("Formula Bar")).sendKeys(Keys.ENTER);
    }

    @AfterClass
    public void tearDown() throws Exception {
       if (driver != null) {
            LtWinDriver.stopExcel();
            driver.quit();
        }
    }
}