package by.htp.les04.service.impl.validatorIncomingData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationDataForRegistration {
	private static Pattern patternN = Pattern.compile("[A-Za-zА-ЯЁёа-я]+");
	private static Pattern patternS = Pattern.compile("[A-Za-zА-ЯЁёа-я]+");
	private static Pattern patternE = Pattern.compile("[-A-Za-z1-9@_\\.]+");
	private static Pattern patternL = Pattern.compile("[A-Za-z1-9!\\.?_]+");
	private static Pattern patternP = Pattern.compile("[-A-Za-z1-9!@#$%^&*()]+");

	public static boolean validateDataForRegistration(String name, String surname, String email, String login, String password) {

		boolean result = true;

		if (name==null || "".equals(name)) {
			result = false;
		}
		if (name.trim().isEmpty()) {
			result = false;
		}

		Matcher matcherN = patternN.matcher(name);
		if (!matcherN.matches()) {
			result = false;
		}

		if (surname==null || "".equals(surname)) {
			result = false;
		}
		if (surname.trim().isEmpty()) {
			result = false;
		}

		Matcher matcherS = patternS.matcher(surname);
		if (!matcherS.matches()) {
			result = false;
		}

		if (email==null || "".equals(email)) {
			result = false;
		}
		if (email.trim().isEmpty()) {
			result = false;
		}

		Matcher matcherE = patternE.matcher(email);
		if (!matcherE.matches()) {
			result = false;
		}

		if (login==null || "".equals(login)) {
			result = false;
		}
		if (login.trim().isEmpty()) {
			result = false;
		}

		Matcher matcherL = patternL.matcher(login);
		if (!matcherL.matches()) {
			result = false;
		}

		if (password==null || "".equals(password)) {
			result = false;
		}
		if (password.trim().isEmpty()) {
			result = false;
		}

		Matcher matcherP = patternP.matcher(password);
		if (!matcherP.matches()) {
			result = false;
		}
		return result;
	}
}
