import java.util.regex.Pattern;

public class BirthdayRule implements Rule {
    private static final Pattern AGE_PATTERN =
            Pattern.compile("\\b(19|20)\\d{2}\\b|\\bI'?m \\d{1,2}\\b|\\bturning \\d{1,2}\\b", Pattern.CASE_INSENSITIVE);

    @Override
    public Flag check(String bio) {
        if (AGE_PATTERN.matcher(bio).find()) {
            return new Flag("Birthday/Age", 3,
                    "Your bio reveals your age or birth year - makes identity theft targeting easier.");
        }
        return null;
    }
}
