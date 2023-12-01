package sandbox;


public final class Rule {
    private final Condition condition;
    
    public Rule(Condition condition) {
        this.condition = condition;
    }
    
    public Outcome evaluate(Condition condition) {
        if (this.condition.matches(condition)) {
            return Outcome.MANUAL;
        } else {
            return Outcome.NO_ACTION;
        }
    }
}
