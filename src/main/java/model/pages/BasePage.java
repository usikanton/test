package model.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

  protected WebDriver driver;

  @FindBy(xpath = "//input[@type='text']")
  protected WebElement searchInput;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    PageFactory.initElements(driver, this);
  }
}