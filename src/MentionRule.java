import java.util.regex.Pattern;

// flags @username mentions - tagging someone reveals your relationships to strangers
public class MentionRule implements Rule {
    private static final Pattern MENTION_PATTERN = Pattern.compile("@\\w+");

    @Override
    public Flag check(String bio) {
        if (MENTION_PATTERN.matcher(bio).find()) {
            return new Flag("Tagged Account", 3,
                    "You've tagged someone else's username - this reveals your relationships to strangers.");
        }
        return null;
    }
}
