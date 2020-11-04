package model.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

  protected WebDriver driver;

  @FindBy(xpath = "//input[@name='q']")
  protected WebElement searchInput;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
}