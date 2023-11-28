package triatlon.fr;

public enum Action {
    /*
     * Eksempler
     */
    CONTINUE("Fortsett registrering"),
    CANCEL("Avbryt registrering"),
    MANUAL("Manuell vurdering"),
    NO_ACTION("INGEN HANDLING");

    private final String action;

    private Action(String action) {
        this.action = action;
    }

    public String getName() {
        return action;
    }
}