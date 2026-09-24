public class LocationRule implements Rule {
    private static final String[] KEYWORDS = {"based in", "living in", "live in", "from "};

    @Override
    public Flag check(String bio) {
        String lower = bio.toLowerCase();
        for (String keyword : KEYWORDS) {
            if (lower.contains(keyword)) {
                return new Flag("Location", 4,
                        "Your bio mentions where you live - makes it easier to find you in person.");
            }
        }
        return null;
    }
}
