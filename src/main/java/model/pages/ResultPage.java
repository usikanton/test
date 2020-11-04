package model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends BasePage {

  @FindBy(id = "result-stats")
  private WebElement resultStat;
  @FindBy(id = "logo")
  private WebElement logo;

  public ResultPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public boolean isResultStatPresent() {
    return resultStat.isDisplayed();
  }

  public String isHintDisplayed() {
    return searchInput.getAttribute("title");
  }

  public HomePage moveToHomePage() {
    logo.click();
    return new HomePage(driver);
  }
}