package triatlon.fr.kontroller;

import triatlon.fr.Action;
import triatlon.fr.RuleEngine;
import triatlon.fr.model.MeldingOmUtflytting;
import triatlon.fr.model.Person;

public class UtflyttingKontroller {
    public Action utflytting(MeldingOmUtflytting meldingOmUtflytting, Person person) {
        RuleEngine ruleEngine = new RuleEngine();

        return ruleEngine.evaluate(meldingOmUtflytting);
    }
}