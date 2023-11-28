package triatlon.fr;

import java.util.List;
import java.util.PriorityQueue;

public class RuleEngine {

    private final PriorityQueue<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = new PriorityQueue<>((rule1, rule2) -> Integer.compare(rule2.getId(), rule1.getId()));
    }

    public Action evaluate(String conditionDescription, String... parameters) {
        for (Rule rule : rules) {
            Action action = rule.getAction(conditionDescription);

            if (action != Action.NO_ACTION) {
                return action;
            }
        }
        return Action.NO_ACTION;

    }
}
