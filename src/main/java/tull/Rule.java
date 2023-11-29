package tull;

public final class Rule {
    private final String description;
    private final Condition condition;

    public Rule(String description, Condition condition) {
        this.description = description;
        this.condition = condition;
    }

    public String getDescription() {
        return this.description;
    }

    public Condition getCondition() {
        return this.condition;
    }

//    public boolean match() {
//        return this.condition.match();
//    }
}

