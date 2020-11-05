package searchtests;

import model.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Properties;
import utils.WebDriverFactoryUtils;

public class BaseTest {

  protected HomePage homePage;
  protected WebDriver driver;

  @BeforeTest(alwaysRun = true)
  public void getStarted() {
    driver = WebDriverFactoryUtils.initDriver();
    openHomePage();
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() {
    if (this.driver != null) {
      driver.close();
      driver.quit();
    }
  }

  private void openHomePage() {
    driver.manage().window().maximize();
    driver.get(Properties.get("base.url"));
    homePage = new HomePage(driver);
  }
}