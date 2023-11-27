package main.java;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class RuleEngine {

    private final List<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = rules;
    }

    public Rule evaluate(String condition, String... parameters) {
        PriorityQueue<Rule> matchingRules = new PriorityQueue<>((rule1, rule2) -> Integer.compare(rule2.getId(), rule1.getId()));

        for (Rule rule : rules) {
            if (rule.getCondition().equals(condition) && Arrays.equals(rule.getParameters(), parameters)) {
                matchingRules.add(rule);
            }
        }

        if (!matchingRules.isEmpty()) {
            return matchingRules.poll();
        }

        return null;
    }
}

