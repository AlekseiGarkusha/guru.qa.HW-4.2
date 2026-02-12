/**
 * Авторизация
 * Логин и пароль указываются в документе
 */

package setup;

import static com.codeborne.selenide.Selenide.$x;

public class Auth {

  public void fillLoginAndPassword (String username, String password) {
    $x("//input[@placeholder='логин']").sendKeys(username);
    $x("//input[@placeholder='пароль']").sendKeys(password);
    $x("//button[contains(text(), 'Войти')]").click();
  }
}
