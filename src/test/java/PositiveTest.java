/**
 * Позитивный тест:
 * - переход к странице формы
 * - проверка на загрузку мормы (нахождение form wrapper)
 * - заполненме всех полей
 * - Проверка на открытие результирующей формы - метод поиска title формы
 * - Сравнение результирующий полей с вводимыми
 */

import com.codeborne.selenide.SelenideElement;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import setup.TestBase;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.DataErrorMessages.*;
import static data.ExpectedUserData.*;
import static data.NavData.*;
import static data.NavData.goToPracticeForm;
import static data.UserData.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositiveTest extends TestBase {

  @Test
  @Order(2)
  @Description("Переход к форме")
  public void goToPracticeForm() {
    $x(goToTestForms).shouldBe(visible).click();
    $(byText(clickTestFormsMenu)).scrollIntoView(true).shouldBe(visible).click();
    $(byText(goToPracticeForm)).shouldBe(visible).click();

    SelenideElement findForm = $(practiceForm).scrollIntoView(true).shouldBe(visible);
    Assertions.assertTrue(findForm.exists(), notFinedPracticeFormTitle);
  }

  @Test
  @Order(3)
  @Description("Заполение всех полей")
  public void positiveTest() throws InterruptedException {

    $(userFirstName).shouldBe(visible).setValue(expectedUserFirstName);
    $(userLastName).sendKeys(expectedUserLastName);
    $(byText(userGenderMale)).click();
    $(userEmail).sendKeys(expectedUserEmail);
    $(userNumber).sendKeys(expectedUserNumber);
    $(userBirthDateDropdown).shouldBe(visible).click();

    $(byText(expectedUserBirthMonth)).shouldBe(visible).click();
    $(byText(expectedUserBirthYear)).shouldBe(visible).click();

    $(byText(expectedUserBirthDay)).click();

    $(byText(userHobbySports)).shouldBe(visible).click();
    $(byText(userHobbyReading)).shouldBe(visible).click();
    $(byText(userHobbyMusic)).shouldBe(visible).click();

    $(userUploadFile).uploadFromClasspath(expectedUserPhoto);

    $(userCurrentAddress).sendKeys(expectedUserCurrentAddress);

    $(userStateDropdown).shouldBe(visible).click();
    $(byText(userStateNCR)).shouldBe(visible).click();

    $(userCityDropdown).shouldBe(visible).click();
    $(byText(userCityNoida)).shouldBe(visible).click();

    $(btnSubmit).click();
  }

  @Test
  @Order(4)
  @Description("Проверка на соответсвиет полей")
  public void comparisonFields() {

    SelenideElement formResult = $(byText(resultFormTitle));
    Assertions.assertTrue(formResult.exists(), notFinedResultFormTitle);

    List<String> expectedValues = List.of(
      expectedUserFirstAndLastName,
      expectedUserEmail,
      expectedUserGender,
      expectedUserNumber,
      expectedUserBirthDate,
      expectedUserSubjects,
      expectedUserHobby,
      expectedUserPhoto,
      expectedUserCurrentAddress,
      expectedUserStateAndCity
    );

    $$(resultFormDataActualList).shouldHave(texts(expectedValues));
  }

}
