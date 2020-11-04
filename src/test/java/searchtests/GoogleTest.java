package searchtests;

import model.pages.ResultPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.SearchQueryDataProvider;

public class GoogleTest extends BaseTest {

  public static final String TOOLTIP_TEXT = "Поиск";
  public static final String EMPTY_STRING = "";

  @Test(testName = "google search", dataProvider = "getSearchQueryData", dataProviderClass = SearchQueryDataProvider.class)
  public void googleSearchTest(String query) {
    SoftAssert softAssert = new SoftAssert();
    ResultPage resultPage = homePage.makeSearch(query);
    softAssert.assertTrue(resultPage.isResultStatPresent(), "No results found.");
    softAssert
        .assertEquals(resultPage.isHintDisplayed(), TOOLTIP_TEXT, "Tooltip text is incorrect.");
    homePage = resultPage.moveToHomePage();
    softAssert.assertEquals(homePage.getSearchQueryText(), EMPTY_STRING, "Query text is present.");
    softAssert.assertAll();
  }
}