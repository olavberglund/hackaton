package sandbox.sandbox2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public final class RuleEngine {
    private final List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = Collections.unmodifiableList(new ArrayList<>(rules));
    }

    public Outcome evaluate(Condition condition) {
        for (Rule rule : rules) {
            Outcome outcome = rule.evaluate(condition);
            if (outcome == Outcome.MANUAL) {
                break;
            }
        }
        // Return default outcome if no rule matches
        return Outcome.DEFAULT;
    }

    // Other methods and constructors

    // Rule class and Outcome enum definitions

    // END: be15d9bcejpp
}
