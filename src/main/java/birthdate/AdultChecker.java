package birthdate;

import java.time.LocalDate;
import java.time.Period;

public class AdultChecker {

  private static final int YEARS = 18;

  public static boolean isAdult(String birthdate) {
    LocalDate currentDate = LocalDate.now();
    LocalDate userDateOfBirth = LocalDate.parse(birthdate);
    Period period = Period.between(userDateOfBirth, currentDate);
    int yearsDifference = period.getYears();
    if (yearsDifference > YEARS) {
      return true;
    } else {
      return false;
    }
  }
}