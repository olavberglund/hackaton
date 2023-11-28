package tull;


public enum Condition {
    IDENTIFIKATOR_FOUND("Identifikator found"),
    DEFAULT("Default");

    private final String description;

    private Condition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean match(String input) {
        return this.description.equalsIgnoreCase(input);
    }
}
