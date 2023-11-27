package triatlon.fr;

import java.util.ArrayList;
import java.util.List;

public class Main {

        public static void main(String[] args) {

                Rule rule1 = new Rule(1, "Identifikator ikke oppgitt", "Avbryt registrering");
                Rule rule2 = new Rule(2, "Identifikator er oppgitt og gjenkjennbar", "Fortsett registrering");
                Rule rule3 = new Rule(3, "Identifikator er oppgitt, men ikke gjenkjennbar", "Avbryt registrering");
                Rule rule4 = new Rule(4, "Identifikator er ugyldig", "Avbryt registrering");
                Rule rule5 = new Rule(5, "Identifikator er oppgitt med ekstra mellomrom", "Fortsett registrering");
                Rule rule6 = new Rule(6, "Tilflytningsland ikke oppgitt", "Avbryt registrering");
                Rule rule7 = new Rule(7, "Tilflytningsland er oppgitt og gyldig", "Fortsett registrering");
                Rule rule8 = new Rule(8, "Tilflytningsland er oppgitt og ikke gyldig", "Avbryt registrering");
                Rule rule9 = new Rule(9, "Tilflytningsland er oppgitt med ekstra mellomrom", "Fortsett registrering");
                Rule rule10 = new Rule(10, "Det opplyses om at personen har egen selvstendig bolig",
                                "Det foreligger dokumentasjon på egen selvstendig bolig i tilflytningslandet",
                                "Fortsett registrering");
                Rule rule11 = new Rule(11, "Det opplyses om at personen har egen selvstendig bolig",
                                "Det foreligger ingen dokumentasjon på boligen i tilflytningslandet",
                                "Manuell vurdering");
                Rule rule12 = new Rule(12, "Det opplyses om at personen ikke har egen selvstendig bolig",
                                "Manuell vurdering");
                Rule rule13 = new Rule(13, "Det opplyses om at personen har dokumentasjon",
                                "Det oppgis ingen informasjon om egen selvstendig bolig i tilflytningslandet",
                                "Manuell vurdering");
                Rule rule14 = new Rule(14, "Informasjon om bolig og dokumentasjon er ikke oppgitt",
                                "Manuell vurdering");
                Rule rule15 = new Rule(15, "Personen har ektefelle i en norsk kommune", "Manuell vurdering");
                Rule rule16 = new Rule(16, "Personen har barn i en norsk kommune", "Manuell vurdering");
                Rule rule17 = new Rule(17, "Personen har ingen ektefelle eller barn i en norsk kommune",
                                "Fortsett registrering");
                Rule rule18 = new Rule(18, "Personen har arbeidsmessig tilknytning i en norsk kommune",
                                "Avbryt registrering");
                Rule rule19 = new Rule(19, "Personen har ingen arbeidsmessig tilknytning i en norsk kommune",
                                "Fortsett registrering");
                Rule rule20 = new Rule(20, "Personen planlegger å oppholde seg deler av året i Norge",
                                "Manuell vurdering");
                Rule rule21 = new Rule(21, "Personen oppgir maks antall dager totalt sett",
                                "Antall dager totalt sett er under den gitte grensen", "Fortsett registrering");
                Rule rule22 = new Rule(22, "Personen oppgir maks antall dager totalt sett",
                                "Antall dager totalt sett er over den gitte grensen", "Manuell vurdering");
                Rule rule23 = new Rule(23, "Personen oppgir maks antall dager i strekk",
                                "Antall dager i strekk er under den gitte grensen", "Fortsett registrering");
                Rule rule24 = new Rule(24, "Personen oppgir maks antall dager i strekk",
                                "Antall dager i strekk er over den gitte grensen", "Manuell vurdering");
                Rule rule25 = new Rule(25, "Personen oppgir at hen ikke skal oppholde seg i Norge",
                                "Fortsett registrering");

                List<Rule> rules = new ArrayList<Rule>();
                rules.add(rule1);

                rules.add(rule2);
                rules.add(rule3);
                rules.add(rule4);
                rules.add(rule5);
                rules.add(rule6);
                rules.add(rule7);
                rules.add(rule8);
                rules.add(rule9);
                rules.add(rule10);
                rules.add(rule11);
                rules.add(rule12);
                rules.add(rule13);
                rules.add(rule14);
                rules.add(rule15);
                rules.add(rule16);
                rules.add(rule17);
                rules.add(rule18);
                rules.add(rule19);
                rules.add(rule20);
                rules.add(rule21);
                rules.add(rule22);
                rules.add(rule23);
                rules.add(rule24);
                rules.add(rule25);

                RuleEngine ruleEngine = new RuleEngine(rules);
                Rule rule = ruleEngine.evaluate("Identifikator er oppgitt", "123456789");

                if (rule != null) {
                    System.out.println("Rule ID: " + rule.getId());
                    System.out.println("Condition: " + rule.getCondition());
                    System.out.println("Action: " + rule.getAction());
                } else {
                    System.out.println("No matching rule found");
                }
        }
}
