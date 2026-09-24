public interface Rule {
    // returns null if this rule wasn't triggered
    Flag check(String bio);
}