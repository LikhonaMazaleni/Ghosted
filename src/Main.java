import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the username:");
        String username = scanner.nextLine();

        System.out.println("Paste the bio/post text, then press Enter:");
        String bio = scanner.nextLine();

        List<Rule> usernameRules = List.of(new UsernameRule());
        List<Rule> bioRules = List.of(new BirthdayRule(), new LocationRule(), new WorkplaceRule(), new MentionRule());

        List<Flag> flags = new ArrayList<>();
        for (Rule rule : usernameRules) {
            Flag flag = rule.check(username);
            if (flag != null) flags.add(flag);
        }
        for (Rule rule : bioRules) {
            Flag flag = rule.check(bio);
            if (flag != null) flags.add(flag);
        }

        System.out.println("\n--- Ghosted Report ---");
        if (bio.isBlank() && username.isBlank()) {
            System.out.println("Nothing entered to check.");
        } else if (flags.isEmpty()) {
            System.out.println("No red flags found. Nice and private!");
        } else {
            for (Flag f : flags) {
                System.out.println("[" + f.rule + "] " + f.message);
            }
        }
    }
}