package  com.example.footballStandings;

public class Utils {
	
	public static boolean isAnyNullOrEmpty(String... args) {
		for (String s : args) {
			if(s == null || s.isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
