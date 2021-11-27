package pageObjects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import org.json.JSONException;



import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import core.Base;
import pageObjects.RegisterPageObject;
import utilities.UtilityClass;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RegisterUserAndCreateRandomDataMethods extends Base {

	RegisterPageObject registerPageObject = new RegisterPageObject();
	static Faker faker = new Faker();
	static FakeValuesService fakeValueService = new FakeValuesService(new Locale("en-US"), new RandomService());
	private static String firstNameFake = faker.name().firstName();
	private static String lastNameFake = faker.name().lastName();
	private static String emailFake = fakeValueService.bothify("?????##@gmail.com");
	private static String telePhoneFake = fakeValueService.numerify("###-###-####");
	private static String passwordFake = fakeValueService.bothify("??##?");
	private static String confirmPasswordFake = passwordFake;
	String dateOfBirth = fakeValueService.numerify("####-") + faker.random().nextInt(1, 12)
			+ fakeValueService.numerify("-") + faker.random().nextInt(1, 30);

	public void registerUser() throws InterruptedException {
		Thread.sleep(1000);
		registerPageObject.enterFirstName(firstNameFake);
		registerPageObject.enterLastName(lastNameFake);
		registerPageObject.enterEmail(emailFake);
		registerPageObject.enterPhone(telePhoneFake);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		registerPageObject.enterPassword(passwordFake);
		registerPageObject.enterConfirmPassword(confirmPasswordFake);
		registerPageObject.subscription("no");
		UtilityClass.takeScreenShot();
		registerPageObject.clickOnPrivacyPolicy();
		registerPageObject.clickOnContinueButton();
	}


	public static void writeEmailToJsonFile() {
		JSONObject fakeJsonObject = new JSONObject();
		fakeJsonObject.put("fakeEmail", emailFake);

		String jsonEmailString = fakeJsonObject.toJSONString();
		System.out.println("jsonString: " + jsonEmailString);

		try (FileWriter file = new FileWriter("fakeEmail.json")) {
			file.write(jsonEmailString);
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writePasswordToJsonFile() throws JSONException {
		JSONObject fakeJsonObject = new JSONObject();
		fakeJsonObject.put("fakePassword", passwordFake);
		String jsonPasswordString = fakeJsonObject.toJSONString();

		try (FileWriter file = new FileWriter("fakePassword.json")) {
			file.write(jsonPasswordString);
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String readFakeEmailFromJsonFile() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\fakeEmail.json");
		// jsonParser.parse will return an object
		Object obj = jsonParser.parse(reader);
		//cast it to a json object 
		JSONObject emailJsonObj = (JSONObject) obj;
		// let's extract the key from jsonObject and cast it to a string
		String emailStringValue = (String) emailJsonObj.get("fakeEmail");
		return emailStringValue;
	}

	public static String readFakePasswordFromJsonFile() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(".\\fakePassword.json");
		// jsonParser.parse will return an object
		Object obj = jsonParser.parse(reader);
		JSONObject passwordJSONObject = (JSONObject) obj;
		// let's extract the key from jsonObject and cast it to a string
		String passwordStringValue = (String) passwordJSONObject.get("fakePassword");
		return passwordStringValue;
	}
	
	public static String getFakeEmail() {
		return emailFake; 
	}
	
	public static String getFakeFirstName() {
		return firstNameFake;
	}
	public static String getFakeLasttName() {
		return lastNameFake;
	}
	public static String getFakeTelePhone() {
		return telePhoneFake;
	}
	

}

