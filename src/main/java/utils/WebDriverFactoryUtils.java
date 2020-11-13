package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactoryUtils {

  private static WebDriver driver;
  private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
  private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
  public static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";

  public static WebDriver initDriver() {
    String browser = System.getProperty("browser");
    if (browser != null && !browser.isEmpty()) {
      switch (browser.toLowerCase()) {
        case "chrome":
          driver = initChromeDriver();
          break;
        case "firefox":
          driver = initFirefoxDriver();
          break;
        case "edge":
          driver = initEdgeDriver();
          break;
        default:
          driver = initFirefoxDriver();
          break;
      }
    }
    return driver;
  }

  private static WebDriver initFirefoxDriver() {
    System.setProperty(GECKO_DRIVER_PROPERTY, Properties.get("gecko.driver"));
    return new FirefoxDriver();
  }

  private static WebDriver initChromeDriver() {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("disable-infobars");
    System.setProperty(CHROME_DRIVER_PROPERTY, Properties.get("chrome.driver"));
    return new ChromeDriver();
  }

  private static WebDriver initEdgeDriver() {
    System.setProperty(EDGE_DRIVER_PROPERTY, Properties.get("edge.driver"));
    return new EdgeDriver();
  }
}