package adulttest;

import static org.testng.Assert.assertTrue;

import birthdate.AdultChecker;
import org.testng.annotations.Test;
import utils.BirthdateDataProvider;

public class AdultTest {

  @Test(testName = "adultTest", dataProvider = "birthdateDataProvider", dataProviderClass = BirthdateDataProvider.class)
  public void adultTest(String birthdate) {
    assertTrue(AdultChecker.isAdult(birthdate), "You are not adult yet.");
  }

}
