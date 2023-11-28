package triatlon.fr;

public enum Condition {
    IDENTIFICATOR_GIVEN("Identifikator oppgitt");

    private final String condition;

    private Condition(String condition) {
        this.condition = condition;
    }

    public Boolean match(String condition) {
        return this.condition.equals(condition);
    }
}
