import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import setup.Base;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PositiveTest extends Base {

  @Test
  public void positiveTest() {

    $x("//input[@id='firstName' and @placeholder='First Name']").sendKeys("Иван");
    $x("//input[@id='lastName' and @placeholder='Last Name']").sendKeys("Гуров");
    $x("//input[@id='userEmail' and @placeholder='name@example.com']").sendKeys("test@ya.ru");

    $x("//input[@id='gender-radio-1' and @value='Male']/following-sibling::label").click();
    $x("//input[@id='userNumber' and @placeholder='Mobile Number']").sendKeys("123456789");

//    SelenideElement dateOfBirth = $x("//input[@id='dateOfBirthInput' and @class='form-control']");
//    dateOfBirth.clear();
////    dateOfBirth.sendKeys("12.02.2000");

    $x("//input[@id='hobbies-checkbox-2' and @value='2']/following-sibling::label").click();


    $("#uploadPicture").uploadFile("=./build.gradle");




  }

}
