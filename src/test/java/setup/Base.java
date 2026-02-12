  /* Расширяющий класс для:
   * Вход в систему
   * Открытие страницы
   * Закрытие страницы
   */

  package setup;

  import com.codeborne.selenide.Configuration;
  import com.codeborne.selenide.FileDownloadMode;
  import com.codeborne.selenide.Selenide;
  import org.testng.annotations.AfterClass;

  import org.testng.annotations.BeforeClass;

  import static com.codeborne.selenide.Selenide.closeWebDriver;

  public class Base{

    private static String BASE_URL = "https://itmrk.krtech.ru/";

    public void setUp(String url) {
      Configuration.browser = "chrome";
      Configuration.browserSize = "1920x1080";
      Configuration.headless = false;
      Configuration.holdBrowserOpen = true;                   /// держать браузер открытым - для отладки
      Configuration.reportsFolder = "target/selenide-reports";
      Configuration.timeout = 5000;
      Configuration.downloadsFolder = "D:\\Auto\\Camera\\build\\downloads";
      Configuration.fileDownload = FileDownloadMode.FOLDER;
    }

    @BeforeClass
    public void init() {
      setUp(BASE_URL);
      Selenide.open(BASE_URL);
    }

    @AfterClass
    public void tearDown() {
      closeWebDriver();
    }
  }
