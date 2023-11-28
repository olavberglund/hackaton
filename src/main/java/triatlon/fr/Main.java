package triatlon.fr;

import static triatlon.fr.Condition.DET_OPPGIVES_OM_PERSON_HAR_EGEN_SELVSTENDIG_BOLIG;
import static triatlon.fr.Condition.IDENTIFIKATOR_ER_OPPGITT_OG_GJENKJENNBAR;
import static triatlon.fr.Condition.PERSONEN_HAR_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_HAR_EKTEFELLE_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_HAR_INGEN_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_HAR_INGEN_EKTEFELLE_ELLER_BARN_I_EN_NORSK_KOMMUNE;
import static triatlon.fr.Condition.PERSONEN_OPPGIR_AT_HEN_IKKE_SKAL_OPPHOLDE_SEG_I_NORGE;
import static triatlon.fr.Condition.PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK;
import static triatlon.fr.Condition.PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK_MANUAL;
import static triatlon.fr.Condition.PERSONEN_PLANLEGGER_A_OPPHOLDE_SEG_DELER_AV_AARET_I_NORGE;
import static triatlon.fr.Condition.TILFLYTNINGSLAND_ER_OPPGITT_OG_GYLDIG;
import static triatlon.fr.Condition.TILFLYTNINGSLAND_IKKE_OPPGITT;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Rule rule2 = new Rule(2, IDENTIFIKATOR_ER_OPPGITT_OG_GJENKJENNBAR, Action.CONTINUE);
        Rule rule6 = new Rule(6, TILFLYTNINGSLAND_IKKE_OPPGITT, Action.CANCEL);
        Rule rule7 = new Rule(7, TILFLYTNINGSLAND_ER_OPPGITT_OG_GYLDIG, Action.CONTINUE);
        Rule rule10 = new Rule(10, DET_OPPGIVES_OM_PERSON_HAR_EGEN_SELVSTENDIG_BOLIG, Action.CONTINUE);
        Rule rule15 = new Rule(15, PERSONEN_HAR_EKTEFELLE_I_EN_NORSK_KOMMUNE, Action.MANUAL);
        Rule rule17 = new Rule(17, PERSONEN_HAR_INGEN_EKTEFELLE_ELLER_BARN_I_EN_NORSK_KOMMUNE, Action.CONTINUE);
        Rule rule18 = new Rule(18, PERSONEN_HAR_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE, Action.CANCEL);
        Rule rule19 = new Rule(19, PERSONEN_HAR_INGEN_ARBEIDSMESSIG_TILKNYTNING_I_EN_NORSK_KOMMUNE, Action.CONTINUE);
        Rule rule20 = new Rule(20, PERSONEN_PLANLEGGER_A_OPPHOLDE_SEG_DELER_AV_AARET_I_NORGE, Action.MANUAL);
        Rule rule23 = new Rule(23, PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK, Action.CONTINUE);
        Rule rule24 = new Rule(24, PERSONEN_OPPGIR_MAKS_ANTALL_DAGER_I_STREKK_MANUAL, Action.MANUAL);
        Rule rule25 = new Rule(25, PERSONEN_OPPGIR_AT_HEN_IKKE_SKAL_OPPHOLDE_SEG_I_NORGE, Action.CONTINUE);

        List<Rule> rules = new ArrayList<Rule>();

        rules.add(rule2);
        rules.add(rule6);
        rules.add(rule7);
        rules.add(rule10);
        rules.add(rule15);
        rules.add(rule17);
        rules.add(rule18);
        rules.add(rule19);
        rules.add(rule20);
        rules.add(rule23);
        rules.add(rule24);
        rules.add(rule25);

        RuleEngine ruleEngine = new RuleEngine(rules);
        Action action = ruleEngine.evaluate(String.valueOf(IDENTIFIKATOR_ER_OPPGITT_OG_GJENKJENNBAR), "123456789");

        if (action != null) {
//            System.out.println("Rule ID: " + action .getId());
//            System.out.println("Condition: " + rule.getCondition());
//            System.out.println("Action: " + rule.getAction());
        } else {
            System.out.println("No matching rule found");
        }
    }
}
