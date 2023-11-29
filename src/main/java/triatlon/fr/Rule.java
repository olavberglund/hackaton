package triatlon.fr;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import triatlon.fr.model.MeldingOmUtflytting;
import triatlon.fr.util.Countries;

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

    public static boolean isValidNorwegianPersonnummer(String input) {
        // Definerer et regulært uttrykk for norsk personnummer
        String regex = "^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[0-2])(\\d{2}|20[01]\\d)[0-9]{5}$";

        // Oppretter et Pattern-objekt
        Pattern pattern = Pattern.compile(regex);

        // Oppretter et Matcher-objekt
        Matcher matcher = pattern.matcher(input);

        // Returnerer true hvis strengen matcher regulært uttrykk, ellers false
        return matcher.matches();
    }

    public static boolean isValidCountry(String countryName) {
        try {
            // Use valueOf for case-insensitive comparison
            Countries.valueOf(countryName.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false; // Enum constant not found, country is not valid
        }
    }

    public int getId() {
        return id;
    }

    public Condition getCondition() {
        return condition;
    }

    public Action getAction() {
        return this.action;
    }

    public String[] getParameters() {
        return parameters;
    }

    public boolean evaluate(Condition condition, MeldingOmUtflytting meldingOmUtflytting) {
        return switch (condition) {
            case IDENTIFIKATOR_ER_OPPGITT -> isEmptyOrNull(meldingOmUtflytting.getIdentifikator());
            case IDENTIFIKATOR_ER_OPPGITT_OG_GJENKJENNBAR -> isValidNorwegianPersonnummer(meldingOmUtflytting.getIdentifikator());
            case TILFLYTNINGSLAND_IKKE_OPPGITT -> isEmptyOrNull(meldingOmUtflytting.getTilflytningsland());
            case TILFLYTNINGSLAND_ER_OPPGITT_OG_GYLDIG -> isValidCountry(meldingOmUtflytting.getTilflytningsland());
            case DET_OPPGIVES_OM_PERSON_HAR_EGEN_SELVSTENDIG_BOLIG -> harBoligIUtlandet(meldingOmUtflytting);
            case PERSONEN_HAR_EKTEFELLE_I_EN_NORSK_KOMMUNE -> harEktefelleINorge(meldingOmUtflytting);
            case PERSONEN_HAR_INGEN_EKTEFELLE_ELLER_BARN_I_EN_NORSK_KOMMUNE ->
                !harEktefelleINorge(meldingOmUtflytting) && !harDagerINorge(meldingOmUtflytting);
            case PERSONEN_HAR_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE -> harArbeidsforholdINorge(meldingOmUtflytting);
            case PERSONEN_HAR_INGEN_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE -> !harArbeidsforholdINorge(meldingOmUtflytting);
            case PERSONEN_PLANLEGGER_A_OPPHOLDE_SEG_DELER_AV_AARET_I_NORGE -> harDagerINorge(meldingOmUtflytting);
            case PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK -> harMaksAntallDagerINorgeAvgangen(meldingOmUtflytting);
            case PERSONEN_OPPGIR_AT_HEN_IKKE_SKAL_OPPHOLDE_SEG_I_NORGE -> !harDagerINorge(meldingOmUtflytting);
            default ->
                // Handle unsupported condition
                false;
        };
    }

    public boolean harBoligIUtlandet(MeldingOmUtflytting meldingOmUtflytting) {
        return meldingOmUtflytting.isBoligIUtlandet();
    }

    public boolean harEktefelleINorge(MeldingOmUtflytting meldingOmUtflytting) {
        return meldingOmUtflytting.isEktefelleINorge();
    }

    public boolean harArbeidsforholdINorge(MeldingOmUtflytting meldingOmUtflytting) {
        return meldingOmUtflytting.isArbeidsforholdINorge();
    }

    public boolean harDagerINorge(MeldingOmUtflytting meldingOmUtflytting) {
        return meldingOmUtflytting.getAntallDagerINorgeTotalt() > 0;
    }

    public boolean harMaksAntallDagerINorgeAvgangen(MeldingOmUtflytting meldingOmUtflytting) {
        return meldingOmUtflytting.getMaksAntallDagerINorgeAvgangen() != 0;
    }

    public boolean isEmptyOrNull(String condition) {
        return condition == null || condition.isEmpty();
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
