package ui;

import static com.codeborne.selenide.Selenide.$;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

  protected By rootElement = By.cssSelector("div#navbar-brand-centered");
  protected By newTourButton = By.cssSelector("a[href*='newtours']");
  protected By agileProjectButton = By.cssSelector("a[href*='Agile']");
  protected By seleniumDropDown = By.cssSelector("a.dropdown-toggle");
  protected By tableDemoLink = By.cssSelector("a[href*='table']");

  public void clickOnNewToursButton(){
    $(rootElement).find(newTourButton).click();
  }

  public void clickOnAgileProjectButton(){
    $(rootElement).find(agileProjectButton).click();
  }

  public void clickOnSeleniumDropDown(){
    $(rootElement).find(seleniumDropDown).click();
  }

  public void clickOnTableDemoLink(){
    $(rootElement).find(tableDemoLink).click();
  }

  public HomePage(AppiumDriver driver){
    appiumDriver = driver;
  }

  public void navigate() {
    appiumDriver.get("http://demo.guru99.com/");
  }
}