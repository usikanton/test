package utils;

import org.testng.annotations.DataProvider;

public class SearchQueryDataProvider {

  @DataProvider(name = "getSearchQueryData")
  public Object[][] getSearchQueryData() {
    return new Object[][]{{"NASA", "Поиск"}, {"Christian Bale", "Шукаць"}};
  }
}