package tull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import triatlon.fr.Fact;

public class RuleEngine {
    private final Set<Rule> rules;

    public RuleEngine(Set<Rule> rules) {
        this.rules = Collections.unmodifiableSet(new HashSet<>(rules));
    }

    public boolean performActionBasedOnRule(String conditionDescription) {
        Set<Fact> facts = new HashSet<>();
        boolean newFactAdded = true;

        while (newFactAdded) {
            newFactAdded = false;

//            for (Rule rule : rules) {
//                if (!rule.match(facts, conditionDescription)) {
//                    return rule.getDefaultValue();
//                }
//
//                if (facts.add(rule.getConclusion())) {
//                    newFactAdded = true;
//                }
//            }
        }

        return true;
    }
}
