package searchtests;

import model.pages.ResultPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.SearchQueryDataProvider;

public class GoogleTest extends BaseTest {

  private ResultPage resultPage;

  @Test(testName = "google search", dataProvider = "getSearchQueryData", dataProviderClass = SearchQueryDataProvider.class)
  public void googleSearchTest(String query, String tooltipText) {
    SoftAssert softAssert = new SoftAssert();
    resultPage = homePage.makeSearch(query);
    softAssert.assertTrue(resultPage.isResultStatPresent(), "No results found.");
    softAssert
        .assertEquals(resultPage.isHintDisplayed(), tooltipText, "Tooltip text is incorrect.");
    homePage = resultPage.moveToHomePage();
    softAssert.assertTrue(homePage.getSearchQueryText().isEmpty(), "Query text is present.");
    softAssert.assertAll();
  }
}