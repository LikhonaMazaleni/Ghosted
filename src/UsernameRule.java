import java.util.regex.Pattern;

// checks the username itself, not the bio - usernames often leak birth years and real names
public class UsernameRule implements Rule {
    private static final Pattern YEAR_PATTERN = Pattern.compile("(19|20)\\d{2}");
    private static final Pattern SHORT_NUM_PATTERN = Pattern.compile("\\d{2,4}$");

    @Override
    public Flag check(String username) {
        if (YEAR_PATTERN.matcher(username).find()) {
            return new Flag("Username Birth Year", 4,
                    "Your username contains what looks like a birth year - a strong clue to your exact age.");
        }
        if (SHORT_NUM_PATTERN.matcher(username).find()) {
            return new Flag("Username Numbers", 2,
                    "Your username ends in numbers - often a birthday, house number, or year in disguise.");
        }
        return null;
    }
}