import java.util.concurrent.TimeUnit;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.*;
import java.util.*;

public class Test1 {
    public static WindowsDriver driver = null;
    
    @BeforeClass
    public void setUp() throws Exception {
        LtWinDriver.start();
    }
    
    @Test
    public static void test() throws Exception {
        String appPath = "testing.xlsx";
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", appPath);
        cap.setCapability("ms:waitForAppLaunch", 30);
        cap.setCapability("appArguments", "/e ");
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
        
        try {
            driver.findElement(By.name("Not now")).click();
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.manage().window().maximize();
        driver.findElement(By.name("Insert")).click();
        driver.findElement(By.name("Formulas")).click();
        driver.findElement(By.name("Data")).click();
        driver.findElement(By.name("Review")).click();
        driver.findElement(By.name("Help")).click();
        driver.findElement(By.name("Insert")).click();
        driver.findElement(By.name("Home")).click();
        driver.findElement(By.name("B2")).click();
        driver.findElement(By.name("Bold")).click();
        driver.findElement(By.name("Formula Bar")).sendKeys("10");
        driver.findElement(By.name("B3")).click();
        driver.findElement(By.name("Formula Bar")).sendKeys("20");
        driver.findElement(By.name("B4")).click();
        driver.findElement(By.name("Formula Bar")).sendKeys("=SUM(B2,B3)");
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