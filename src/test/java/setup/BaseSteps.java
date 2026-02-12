/**
 * Расширяющий класс для шагов регистрации
 */

package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseSteps {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected SoftAssert softAssert;
}