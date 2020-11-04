package utils;

import java.util.Locale;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactoryUtils {

  private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
  private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
  private static String osSuffix;

  public static WebDriver initDriver() throws Exception {
    Platform platform = definePlatform();
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    String browser = System.getProperty("browser");
    if (os.contains("mac")) {
      platform = Platform.MAC;
    } else if (os.contains("nux")) {
      platform = Platform.LINUX;
    }
    if (browser != null && !browser.isEmpty()) {
      if (browser.equalsIgnoreCase("chrome")) {
        return initChromeDriver(platform);
      } else if (browser.equalsIgnoreCase("firefox")) {
        return initFirefoxDriver(platform);
      }
    } else {
      return initFirefoxDriver(platform);
    }
    throw new Exception("Browser parameter has been configured incorrectly");
  }

  private static Platform definePlatform() {
    Platform platform = null;
    String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    if (os.contains("windows")) {
      platform = Platform.WINDOWS;
    } else if (os.contains("linux")) {
      platform = Platform.LINUX;
    } else if (os.contains("mac")) {
      platform = Platform.MAC;
    }
    return platform;
  }

  private static WebDriver initFirefoxDriver(Platform platform) {
    switch (platform) {
      case WINDOWS:
        osSuffix = "win64.exe";
        break;
      case LINUX:
        osSuffix = "limux64";
        break;
      case MAC:
        osSuffix = "mac64";
        break;
      default:
        osSuffix = "win64.exe";
        break;
    }
    System
        .setProperty(GECKO_DRIVER_PROPERTY, "src\\main\\resources\\drivers\\geckodriver_win64.exe");
    return new FirefoxDriver();
  }

  private static WebDriver initChromeDriver(Platform platform) {
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("disable-infobars");
    chromeOptions.addArguments();
    switch (platform) {
      case WINDOWS:
        osSuffix = "win64.exe";
        break;
      case LINUX:
        osSuffix = "limux64";
        break;
      case MAC:
        osSuffix = "mac64";
        break;
      default:
        osSuffix = "win64.exe";
        break;
    }
    System.setProperty(CHROME_DRIVER_PROPERTY,
        "src\\main\\resources\\drivers\\chromedriver_win32.exe");
    return new ChromeDriver();
  }
}