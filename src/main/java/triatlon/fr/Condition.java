package triatlon.fr;

public enum Condition {

    IDENTIFIKATOR_ER_OPPGITT("Identifikator er oppgitt"),
    IDENTIFIKATOR_ER_OPPGITT_OG_GJENKJENNBAR("Identifikator er oppgitt og gjenkjennbar"),
    TILFLYTNINGSLAND_IKKE_OPPGITT("Tilflytningsland ikke oppgitt"),
    TILFLYTNINGSLAND_ER_OPPGITT_OG_GYLDIG("Tilflytningsland er oppgitt og gyldig"),
    DET_OPPGIVES_OM_PERSON_HAR_EGEN_SELVSTENDIG_BOLIG("Det opplyses om at personen har egen selvstendig bolig"),
    DET_OPPGIVES_OM_PERSON_HAR_EGEN_SELVSTENDIG_BOLIG_MANUAL("Det opplyses om at personen har egen selvstendig bolig"),
    PERSONEN_HAR_EKTEFELLE_I_EN_NORSK_KOMMUNE("Personen har ektefelle i en norsk kommune"),
    PERSONEN_HAR_INGEN_EKTEFELLE_ELLER_BARN_I_EN_NORSK_KOMMUNE("Personen har ingen ektefelle eller barn i en norsk kommune"),
    PERSONEN_HAR_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE("Personen har arbeidsmessig tilknytning i en norsk kommune"),
    PERSONEN_HAR_INGEN_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE("Personen har ingen arbeidsmessig tilknytning i en norsk kommune"),
    PERSONEN_PLANLEGGER_A_OPPHOLDE_SEG_DELER_AV_AARET_I_NORGE("Personen planlegger å oppholde seg deler av året i Norge"),
    PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK("Personen oppgir maks antall dager i strekk"),
    PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK_MANUAL("Personen oppgir maks antall dager i strekk"),
    PERSONEN_OPPGIR_AT_HEN_IKKE_SKAL_OPPHOLDE_SEG_I_NORGE("Personen oppgir at hen ikke skal oppholde seg i Norge");
    private final String condition;

    private Condition(String condition) {
        this.condition = condition;
    }

    public boolean match(String condition) {
        return this.condition.equals(condition);
    }
}
