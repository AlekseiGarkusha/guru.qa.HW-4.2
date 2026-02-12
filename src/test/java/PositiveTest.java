import org.junit.jupiter.api.Test;
import setup.Base;

import java.io.File;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PositiveTest extends Base {

  @Test
  public void positiveTest() {

    $x("//input[@id='firstName' and @placeholder='First Name']").sendKeys("Иван");
    $x("//input[@id='lastName' and @placeholder='Last Name']").sendKeys("Гуров");
    $x("//input[@id='userEmail' and @placeholder='name@example.com']").sendKeys("test@ya.ru");

    $x("//input[@id='gender-radio-1' and @value='Male']/following-sibling::label").click();
    $x("//input[@id='userNumber' and @placeholder='Mobile Number']").sendKeys("1234567890");

    $x("//input[@id='dateOfBirthInput' and @class='form-control']").click();

    $x("//select[contains(@class,'react-datepicker__month-select')]/option[text()='March']").click();
    $x("//select[contains(@class,'react-datepicker__year-select')]/option[text()='1991']").click();

    $x(
      "//div[contains(@class,'react-datepicker__day') " +
        "and text()='29' " +
        "and not(contains(@class,'outside-month'))]"
    ).click();

    $x("//input[@id='hobbies-checkbox-1' and @value='1']/following-sibling::label").click();
    $x("//input[@id='hobbies-checkbox-2' and @value='2']/following-sibling::label").click();
    $x("//input[@id='hobbies-checkbox-3' and @value='3']/following-sibling::label").click();

    File file = new File("src/test/resources/Code.png");
    $("#uploadPicture").uploadFile(file);

    $("#currentAddress").sendKeys("Some fish text");

    $x("//div[contains(@class, 'css-yk16xz-control') and .//div[text()='Select State']]").click();
    $(byText("NCR")).shouldBe(visible).click();

    $x("//div[contains(@class, 'css-yk16xz-control') and .//div[text()='Select City']]").click();
    $(byText("Noida")).shouldBe(visible).click();

    $("#submit").click();
  }
}
