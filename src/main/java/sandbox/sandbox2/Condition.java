package sandbox.sandbox2;

public enum Condition {
    CONDITION_1("Condition 1"),
    CONDITION_2("Condition 2"),
    CONDITION_3("Condition 3");

    private final String description;

    private Condition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean evaluate(String input) {
        return input.equals(description);
    }
}
