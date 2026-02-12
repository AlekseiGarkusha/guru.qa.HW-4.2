  /* Расширяющий класс для:
   * Вход в систему
   * Открытие страницы
   * Закрытие страницы
   */

  package setup;

  import com.codeborne.selenide.Configuration;
  import com.codeborne.selenide.Selenide;
  import org.junit.jupiter.api.AfterAll;
  import org.junit.jupiter.api.BeforeAll;

  import static com.codeborne.selenide.Selenide.closeWebDriver;

  public class Base{

    private static String BASE_URL = "https://demoqa.com/automation-practice-form";

    public static void setUp(String url) {
      Configuration.browser = "chrome";
      Configuration.browserSize = "1920x1080";
      Configuration.headless = false;
      Configuration.holdBrowserOpen = true;                   /// держать браузер открытым - для отладки
      Configuration.reportsFolder = "target/selenide-reports";
      Configuration.timeout = 5000;
    }

    @BeforeAll
    public static void init() {
      setUp(BASE_URL);
      Selenide.open(BASE_URL);
    }

    @AfterAll
    public static void tearDown() {
      closeWebDriver();
    }
  }
