import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.DragAndDropPage;
import ui.HomePage;

public class MobileWebTest {

  AppiumDriver appiumDriver;

  @BeforeClass
  public void setup() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel API R");
    capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
    capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
    capabilities.setCapability("chromedriverExecutableDir","C:\\Users\\anvla\\.m2\\repository\\webdriver\\chromedriver\\win32\\83.0.4103.14");

    URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
    appiumDriver = new AndroidDriver(serverAddress, capabilities);
  }

  @Test
  public void testCal() throws Exception {
    HomePage homePage = new HomePage(appiumDriver);
    homePage.navigate();
  }

  @Test
  public void testCal2() throws Exception {
    DragAndDropPage dragAndDropPage = new DragAndDropPage(appiumDriver);
    dragAndDropPage.navigate();
    dragAndDropPage.putDeditAccount("BANK");
//    dragAndDropPage.putDebitAmount("5000");
//    dragAndDropPage.putCreditAccount("SALES");
//    dragAndDropPage.putCreditAmount("5000");
//
//    assertTrue(dragAndDropPage.successMessageIsShown());
  }

  @AfterClass
  public void teardown(){
    appiumDriver.quit();
  }

}
