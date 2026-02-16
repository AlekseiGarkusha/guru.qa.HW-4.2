package data;

import static data.UserData.*;

public class ExpectedUserData {
  public static String expectedUserFirstName = "Гуров";
  public static String expectedUserLastName = "Иван";
  public static String expectedUserFirstAndLastName = expectedUserFirstName + " " + expectedUserLastName;
  public static String expectedUserEmail = "test@ya.ru";
  public static String expectedUserGender = "Male";
  public static String expectedUserNumber = "1234567890";

  public static String expectedUserBirthDay = "29";
  public static String expectedUserBirthMonth = "March";
  public static String expectedUserBirthYear = "1991";
  public static String expectedUserBirthDate = expectedUserBirthDay + " " + expectedUserBirthMonth + ","+ expectedUserBirthYear;

  public static String expectedUserSubjects = "";
  public static String expectedUserHobby = userHobbySports + ", " + userHobbyReading + ", " + userHobbyMusic;
  public static String expectedUserPhoto = "Code.png";
  public static String expectedUserCurrentAddress = "Florida";
  public static String expectedUserStateAndCity = userStateNCR + " " + userCityNoida;
}
