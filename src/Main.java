import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Paste your bio/post text, then press Enter:");
        String bio = scanner.nextLine();

        List<Rule> rules = List.of(new BirthdayRule());
        List<Flag> flags = new ArrayList<>();

        for (Rule rule : rules) {
            Flag flag = rule.check(bio);
            if (flag != null) flags.add(flag);
        }

        System.out.println("\n--- Ghosted Report ---");
        if (flags.isEmpty()) {
            System.out.println("No red flags found. Nice and private!");
        } else {
            for (Flag f : flags) {
                System.out.println("[" + f.rule + "] " + f.message);
            }
        }
    }
}
