package triatlon.fr;

import java.util.Arrays;
import java.util.Objects;

public class Rule {

    private final int id;
    private final Condition condition;
    private final Action action;
    private final String[] parameters;

    public Rule(int id, Condition condition, Action action, String... parameters) {
        this.id = id;
        this.condition = condition;
        this.action = action;
        this.parameters = parameters;
    }

    public int getId() {
        return id;
    }

    public Condition getCondition() {
        return condition;
    }

    public Action getAction(String conditionDescription) {
        if (this.condition.match(conditionDescription)) {
            return this.action;
        } else {
            return Action.NO_ACTION;
        }
    }

    public String[] getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rule rule = (Rule) o;
        return id == rule.id &&
            condition.equals(rule.condition) &&
            Arrays.equals(parameters, rule.parameters) &&
            action.equals(rule.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, condition, action);
    }

    @Override
    public String toString() {
        return "Rule{" +
            "id=" + id +
            ", condition='" + condition + '\'' +
            ", action='" + action + '\'' +
            '}';
    }
}
