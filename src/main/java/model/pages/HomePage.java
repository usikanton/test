package model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  public ResultPage makeSearch(String query) {
    searchInput.click();
    searchInput.sendKeys(query);
    searchInput.submit();
    return new ResultPage(driver);
  }

  public String getSearchQueryText() {
    return searchInput.getText();
  }
}