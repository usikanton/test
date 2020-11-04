package model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public ResultPage makeSearch(String query) {
    searchInput.sendKeys(query);
    searchInput.submit();
    return new ResultPage(driver);
  }

  public String getSearchQueryText() {
    return searchInput.getText();
  }
}