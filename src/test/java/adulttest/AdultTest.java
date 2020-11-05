package adulttest;

import birthdate.AdultChecker;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BirthdateDataProvider;

public class AdultTest {

  @Test(testName = "adultTest", dataProvider = "birthdateDataProvider", dataProviderClass = BirthdateDataProvider.class)
  public void adultTest(String birthdate) {
    Assert.assertTrue(AdultChecker.isAdult(birthdate), "You are not adult yet.");
  }
}