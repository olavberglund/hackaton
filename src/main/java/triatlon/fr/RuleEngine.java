package triatlon.fr;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import triatlon.fr.model.MeldingOmUtflytting;

public class RuleEngine {

    private final PriorityQueue<Rule> rules;

    public RuleEngine(List<Rule> rules) {
        this.rules = new PriorityQueue<>((rule1, rule2) -> Integer.compare(rule2.getId(), rule1.getId()));
    }

    public Action evaluate(MeldingOmUtflytting meldingOmUtflytting) {
        List<Action> actions = new ArrayList<>();
        for (Rule rule : rules) {
            if (rule.evaluate(rule.getCondition(), meldingOmUtflytting)) {
                actions.add(rule.getAction());
            }
        }
        if (actions.contains(Action.CANCEL)) {
            return Action.CANCEL;
        } else if (actions.contains(Action.MANUAL)) {
            return Action.MANUAL;
        } else if (actions.contains(Action.CONTINUE)) {
            return Action.CONTINUE;
        }
        return Action.NO_ACTION;
    }
}
