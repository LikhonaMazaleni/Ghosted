public class WorkplaceRule implements Rule {
    private static final String[] KEYWORDS = {"work at", "working at", "employee at", "intern at"};

    @Override
    public Flag check(String bio) {
        String lower = bio.toLowerCase();
        for (String keyword : KEYWORDS) {
            if (lower.contains(keyword)) {
                return new Flag("Workplace", 3,
                        "Your bio names your workplace - combined with your routine, this makes social engineering easier.");
            }
        }
        return null;
    }
}
