import static org.testng.Assert.assertEquals;

import app.CalculatorMainView;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NativeAppTest {

  AppiumDriver appiumDriver;

  @BeforeClass
  public void setup() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel API R");
    capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");

    URL serverAddress = new URL("http://0.0.0.0:4723/wd/hub");

    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 100);
    capabilities.setCapability("appPackage", "com.google.android.calculator");
    capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

    appiumDriver = new AndroidDriver(serverAddress, capabilities);
  }

  @Test
  public void testCal() throws Exception {
    WebElement two=appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_2')]"));
    two.click();
    WebElement plus=appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'op_add')]"));
    plus.click();
    WebElement four=appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'digit_3')]"));
    four.click();
    WebElement equalTo=appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'eq')]"));
    equalTo.click();
    WebElement results=appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id, 'result')]"));

    assertEquals("5", results.getText(), "Actual value is : "+results.getText()+" did not match with expected value: 5");
  }

  @Test
  public void simpleSummTest() {
    CalculatorMainView calculatorMainView = new CalculatorMainView(appiumDriver);

    calculatorMainView.getDigit2().click();
    calculatorMainView.getPlusButton().click();
    calculatorMainView.getDigit3().click();
    calculatorMainView.getEqualButton().click();

    assertEquals("5", calculatorMainView.getResultField().getText());
  }

  @AfterClass
  public void teardown(){
    appiumDriver.quit();
  }


}
