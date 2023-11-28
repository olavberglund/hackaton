package triatlon.fr;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class RuleEngine {

    private final List<Rule> rules;
    private final PriorityQueue<Rule> matchingRules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
        matchingRules = new PriorityQueue<>((rule1, rule2) -> Integer.compare(rule2.getId(), rule1.getId()));

    }

    public Rule evaluate(String condition, String... parameters) {

        for (Rule rule : rules) {
            if (rule.getCondition().equals(condition) && Arrays.equals(rule.getParameters(), parameters)) {
                return rule.getAction()
                // this.matchingRules.add(rule);
            }
        }

        if (!matchingRules.isEmpty()) {
            return this.matchingRules.poll();
        }

        return null;
    }
}
