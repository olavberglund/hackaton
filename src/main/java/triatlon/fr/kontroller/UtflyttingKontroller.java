package triatlon.fr.kontroller;

import triatlon.fr.Action;
import triatlon.fr.RuleEngine;
import triatlon.fr.model.MeldingOmUtflytting;

public class UtflyttingKontroller {
    public Action utflytting(MeldingOmUtflytting meldingOmUtflytting) {
        RuleEngine ruleEngine = new RuleEngine();

        return ruleEngine.evaluate(meldingOmUtflytting);
    }
}