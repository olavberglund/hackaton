package triatlon.fr;

import static triatlon.fr.Condition.DET_OPPGIVES_OM_PERSON_HAR_EGEN_SELVSTENDIG_BOLIG;
import static triatlon.fr.Condition.IDENTIFIKATOR_ER_OPPGITT_OG_GJENKJENNBAR;
import static triatlon.fr.Condition.PERSONEN_HAR_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_HAR_EKTEFELLE_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_HAR_INGEN_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_HAR_INGEN_EKTEFELLE_ELLER_BARN_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_OPPGIR_AT_HEN_IKKE_SKAL_OPPHOLDE_SEG_I_NORGE;
import static triatlon.fr.Condition.PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK;
import static triatlon.fr.Condition.PERSONEN_PLANLEGGER_A_OPPHOLDE_SEG_DELER_AV_AARET_I_NORGE;
import static triatlon.fr.Condition.TILFLYTNINGSLAND_ER_OPPGITT_OG_GYLDIG;
import static triatlon.fr.Condition.TILFLYTNINGSLAND_IKKE_OPPGITT;

import java.util.ArrayList;
import java.util.List;

import triatlon.fr.model.MeldingOmUtflytting;

public class Main {

    public static void main(String[] args) {

        List<Rule> rules = new ArrayList<>() {{
            add(new Rule(2, IDENTIFIKATOR_ER_OPPGITT_OG_GJENKJENNBAR, Action.CONTINUE));
            add(new Rule(6, TILFLYTNINGSLAND_IKKE_OPPGITT, Action.CANCEL));
            add(new Rule(7, TILFLYTNINGSLAND_ER_OPPGITT_OG_GYLDIG, Action.CONTINUE));
            add(new Rule(10, DET_OPPGIVES_OM_PERSON_HAR_EGEN_SELVSTENDIG_BOLIG, Action.CONTINUE));
            add(new Rule(15, PERSONEN_HAR_EKTEFELLE_I_EN_NORSK_KOMMUNE, Action.MANUAL));
            add(new Rule(17, PERSONEN_HAR_INGEN_EKTEFELLE_ELLER_BARN_I_EN_NORSK_KOMMUNE, Action.CONTINUE));
            add(new Rule(18, PERSONEN_HAR_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE, Action.CANCEL));
            add(new Rule(19, PERSONEN_HAR_INGEN_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE, Action.CONTINUE));
            add(new Rule(20, PERSONEN_PLANLEGGER_A_OPPHOLDE_SEG_DELER_AV_AARET_I_NORGE, Action.MANUAL));
            add(new Rule(23, PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK, Action.CONTINUE));
            add(new Rule(25, PERSONEN_OPPGIR_AT_HEN_IKKE_SKAL_OPPHOLDE_SEG_I_NORGE, Action.CONTINUE));
        }};

//        RuleEngine ruleEngine = new RuleEngine(rules);

//        ruleEngine.evaluate(new MeldingOmUtflytting());

    }
}
