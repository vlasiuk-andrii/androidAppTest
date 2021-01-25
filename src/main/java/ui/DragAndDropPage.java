package ui;

import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragAndDropPage extends BasePage {

  @FindBy(xpath = "//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Account')]/..//li")
  private SelenideElement debitAccountDropField;
  @FindBy(xpath = "//h3[contains(text(),'DEBIT')]/..//h3[contains(text(),'Amount')]/..//li")
  private SelenideElement debitAmountDropField;
  @FindBy(xpath = "//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Account')]/..//li")
  private SelenideElement creditAccountDropField;
  @FindBy(xpath = "//h3[contains(text(),'CREDIT')]/..//h3[contains(text(),'Amount')]/..//li")
  private SelenideElement creditAmountDropField;
  @FindBy(css = "div.table4_result")
  private SelenideElement resultTable;
  @FindBy(css = "div.platform-content")

  private SelenideElement dragAndDropForm;

  private Actions actionSelenium;
  private TouchAction actionAppium;

  public DragAndDropPage(AppiumDriver driver) {
    actionAppium = new TouchAction(driver);
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public SelenideElement getDebitAccountDropField() {
    return debitAccountDropField;
  }

  public SelenideElement getDebitAmountDropField() {
    return debitAmountDropField;
  }

  public SelenideElement getCreditAccountDropField() {
    return creditAccountDropField;
  }

  public SelenideElement getCreditAmountDropField() {
    return creditAmountDropField;
  }

  public SelenideElement getResultTable() {
    return resultTable;
  }

  public SelenideElement getDragAndDropForm() {
    return dragAndDropForm;
  }

  public void putDeditAccount(String account) {
    WebElement from = debitAccountDropField.findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
    WebElement to = creditAccountDropField;
    dragAndDrop(from, to);
  }

//  public void putDebitAmount(String amount) {
//    WebElement from = page(DragAndDropPage.class).getDragAndDropForm().findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
//    WebElement to = page(DragAndDropPage.class).getDebitAmountDropField();
//    dragAndDrop(from, to);
//  }
//
//  public void putCreditAccount(String account) {
//    WebElement from = page(DragAndDropPage.class).getDragAndDropForm().findElement(By.xpath("//*[contains(text(),'" + account + "')]"));
//    WebElement to = page(DragAndDropPage.class).getCreditAccountDropField();
//    dragAndDrop(from, to);
//  }
//
//  public void putCreditAmount(String amount) {
//    WebElement from = page(DragAndDropPage.class).getDragAndDropForm().findElement(By.xpath("(//*[contains(text(),'" + amount + "')])[2]"));
//    WebElement to = page(DragAndDropPage.class).getCreditAmountDropField();
//    dragAndDrop(from, to);
//  }
//
//  public boolean successMessageIsShown() {
//    return page(DragAndDropPage.class).getResultTable().isDisplayed();
//  }

  protected void dragAndDrop(WebElement from, WebElement to) {
    actionAppium.longPress(PointOption.point(from.getLocation().getX(), from.getLocation().getY()))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
        .moveTo(PointOption.point(to.getLocation().getX(), to.getLocation().getY()))
        .perform()
        .release();
  }

  public void navigate() {
    appiumDriver.get("http://demo.guru99.com/test/drag_drop.html");
  }
}