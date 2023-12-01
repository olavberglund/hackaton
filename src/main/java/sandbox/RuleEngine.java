package sandbox;

import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class RuleEngine {
    private final List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = Collections.unmodifiableList(new ArrayList<>(rules));
        // Alternatively, you can use:
        // this.rules = new CopyOnWriteArrayList<>(rules);
    }

    public Outcome evaluate(Condition condition) {
        for (Rule rule : rules) {
            Outcome outcome = rule.evaluate(condition);
            if (outcome == Outcome.MANUAL) {
                return outcome;
            }
        }
        return Outcome.AUTO;
    }
}
