public class InputDataCheck {
	private static final String STUDENT_ID_PATTERN = "\\d{10}";
	private static final String SUBJECT_ID_PATTERN = "\\d{3}";
	private static final String STUDENT_NAME_PATTERN = "[\\p{L}\\p{N} _·-]+";
	private static final String CREDIT_PATTERN = "\\d+(\\.\\d+)?";
	private static final String ACHIEVEMENT_PATTERN = "\\d+\\.\\d{1,4}";

	public static boolean isStudentId(String input) {
		return input != null && input.trim().matches(STUDENT_ID_PATTERN);
	}

	public static boolean isSubjectId(String input) {
		return input != null && input.trim().matches(SUBJECT_ID_PATTERN);
	}

	public static boolean isStudentName(String input) {
		return input != null && input.trim().matches(STUDENT_NAME_PATTERN);
	}

	public static boolean isAchievement(String input) {
		if (input == null || !input.trim().matches(ACHIEVEMENT_PATTERN)) {
			return false;
		}

		double achievement = Double.parseDouble(input.trim());
		return achievement >= 0 && achievement <= 101.0000;
	}

	public static boolean isCredit(String input) {
		if (input == null || !input.trim().matches(CREDIT_PATTERN)) {
			return false;
		}

		double credit = Double.parseDouble(input.trim());
		return credit >= 0;
	}
}
