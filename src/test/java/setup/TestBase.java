  /* Расширяющий класс для:
   * Вход в систему
   * Открытие страницы
   * Закрытие страницы
   */

  package setup;

  import com.codeborne.selenide.Configuration;
  import com.codeborne.selenide.Selenide;
  import com.codeborne.selenide.TextCheck;
  import org.junit.jupiter.api.AfterAll;
  import org.junit.jupiter.api.BeforeAll;
  import org.openqa.selenium.chrome.ChromeOptions;

  import static com.codeborne.selenide.Selenide.closeWebDriver;

  public class TestBase {

    private static String BASE_URL = "https://demoqa.com";

    public static void setUp() {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--remote-allow-origins=*");

      Configuration.browser = "chrome";
      Configuration.browserSize = "1920x1080";
      Configuration.headless = false;
      Configuration.holdBrowserOpen = true;
      Configuration.reportsFolder = "target/selenide-reports";
      Configuration.timeout = 5000;
      Configuration.textCheck = TextCheck.FULL_TEXT;
      Configuration.browserCapabilities = options;


    }

    @BeforeAll
    public static void init() {
      setUp();
      Selenide.open(BASE_URL);
    }

    @AfterAll
    public static void tearDown() {
      closeWebDriver();
    }
  }
