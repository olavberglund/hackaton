package main.java;

import java.util.Arrays;
import java.util.Objects;

public class Rule {

    private final int id;
    private final String condition;
    private final String action;
    private final String[] parameters;

    public Rule(int id, String condition, String action, String... parameters) {
        this.id = id;
        this.condition = condition;
        this.action = action;
        this.parameters = parameters;

    }

    public int getId() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public String getAction() {
        return action;
    }

    public String[] getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
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
