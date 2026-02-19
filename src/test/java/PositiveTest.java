/**
 * Позитивный тест:
 * - переход к странице формы
 * - проверка на загрузку мормы (нахождение form wrapper)
 * - заполненме всех полей
 * - проверка на открытие результирующей формы - метод поиска title формы
 * - сравнение результирующий полей с вводимыми
 */

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import setup.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.DataErrorMessages.*;
import static data.NavData.*;
import static data.NavData.goToPracticeForm;

public class PositiveTest extends TestBase {
  // Selectors
  private static String selectorPracticeForm = ".practice-form-wrapper";
  private static String selectorResultFormTitle = "#example-modal-sizes-title-lg";

  private static String selectorLastName = "#lastName";
  private static String selectorEmail = "#userEmail";
  private static String selectorGenderMale = "Male";
  private static String selectorPhoneNumber = "#userNumber";
  private static String selectorBirthDateInput = "#dateOfBirthInput";

  private static String selectorHobbySports = "Sports";
  private static String selectorHobbyReading = "Reading";
  private static String selectorHobbyMusic = "Music";

  private static String selectorUploadPicture = "#uploadPicture";
  private static String selectorCurrentAddress = "#currentAddress";

  private static String selectorStateDropdown = "#state";
  private static String selectorStateNCR = "NCR";

  private static String selectorCityDropdown = "#city";
  private static String selectorCityNoida = "Noida";

  // Actions
  public static String userFirstName = "Гуров";
  public static String userLastName = "Иван";
  public static String userEmail = "test@ya.ru";
  public static String userNumber = "1234567890";

  public static String userBirthDay = "29";
  public static String userBirthMonth = "March";
  public static String userBirthYear = "1991";

  public static String userPhoto = "Code.png";
  public static String userCurrentAddress = "Florida";

  @Test
  public void practiceFormTest() {
    $x(goToTestForms).click();
    $(byText(clickTestFormsMenu)).scrollIntoView(true).shouldBe(visible).click();
    $(byText(goToPracticeForm)).scrollIntoView(true).shouldBe(visible).click();

    SelenideElement findForm = $(selectorPracticeForm).shouldBe(visible);
    Assertions.assertTrue(findForm.exists(), notFinedPracticeFormTitle);

    // fill Fields
    String selectorFirstName = "#firstName";
    $(selectorFirstName).shouldBe(visible).setValue(userFirstName);
    $(selectorLastName).sendKeys(userLastName);
    $(byText(selectorGenderMale)).click();
    $(selectorEmail).sendKeys(userEmail);
    $(selectorPhoneNumber).sendKeys(userNumber);
    $(selectorBirthDateInput).shouldBe(visible).click();

    $(byText(userBirthMonth)).shouldBe(visible).click();
    $(byText(userBirthYear)).shouldBe(visible).click();
    $(byText(userBirthDay)).click();

    $(byText(selectorHobbySports)).shouldBe(visible).click();
    $(byText(selectorHobbyReading)).shouldBe(visible).click();
    $(byText(selectorHobbyMusic)).shouldBe(visible).click();
    $(selectorUploadPicture).uploadFromClasspath(userPhoto);
    $(selectorCurrentAddress).sendKeys(userCurrentAddress);
    $(selectorStateDropdown).shouldBe(visible).click();
    $(byText(selectorStateNCR)).shouldBe(visible).click();
    $(selectorCityDropdown).shouldBe(visible).click();
    $(byText(selectorCityNoida)).shouldBe(visible).click();

    $(btnSubmit).click();

    $(selectorResultFormTitle).shouldHave(text("Thanks for submitting the form"));
  }
}
