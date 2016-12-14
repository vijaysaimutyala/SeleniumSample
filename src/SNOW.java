import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SNOW {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\chromedriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://niketech.service-now.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSNOW() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("**");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("**");
    driver.findElement(By.linkText("Login")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | gsft_nav | ]]
    driver.findElement(By.id("div.4fe67f8fc0a80164000a00fde5904c3e")).click();
    driver.findElement(By.id("4fe67f8fc0a80164000a00fde5904c3e")).click();
    driver.findElement(By.id("439bcf454fca52000b86ecee0210c7f6")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
