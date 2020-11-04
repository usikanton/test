package searchtests;

import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.WebDriverFactoryUtils;

public class BaseTest {

  public static final String BASE_URL = "https://google.com";
  protected HomePage homePage;
  protected WebDriver driver;

  @BeforeTest
  public void getStarted() {
    try {
      driver = WebDriverFactoryUtils.initDriver();
    } catch (Exception e) {
      e.printStackTrace();
    }
    driver.get(BASE_URL);
    homePage = new HomePage(driver);
  }

  @AfterTest
  public void tearDown() {
    driver.close();
    driver.quit();
  }
}