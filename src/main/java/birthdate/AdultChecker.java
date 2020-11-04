package birthdate;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AdultChecker {

  private static final int YEARS = 18;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter you date of birth in format 'yyyy-mm-dd': \n");
    isAdult(scanner.next());
  }

  public static boolean isAdult(String birthdate) {
    LocalDate currentDate = LocalDate.now();
    LocalDate userDateOfBirth = LocalDate.parse(birthdate);
    Period period = Period.between(userDateOfBirth, currentDate);
    int yearsDifference = period.getYears();
    if (yearsDifference > YEARS) {
      System.out.println(String.format("You are adult: %d years old", yearsDifference));
      return true;
    } else {
      System.out.println(String.format("You are too young so far: %d years old", yearsDifference));
      return false;
    }
  }
}