package utils;

import org.testng.annotations.DataProvider;

public class BirthdateDataProvider {

  @DataProvider(name = "birthdateDataProvider")
  public Object[][] getBirthdate() {
    return new Object[][]{{"1994-05-14"}, {"2005-10-24"}};
  }
}