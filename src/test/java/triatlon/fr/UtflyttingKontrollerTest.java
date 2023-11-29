package triatlon.fr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import triatlon.fr.kontroller.UtflyttingKontroller;
import triatlon.fr.mockdata.Meldinger;
import triatlon.fr.mockdata.Personer;
import triatlon.fr.model.MeldingOmUtflytting;
import triatlon.fr.model.Person;
import triatlon.fr.model.Register;

class UtflyttingKontrollerTest {

    private UtflyttingKontroller utflyttingKontroller;

    @BeforeEach
    void setUp() {
        utflyttingKontroller = new UtflyttingKontroller();
    }

    @Test
    void utflyttingGroentLoep() {

        Person personGroentLoep = Personer.getPersonGroentLoep();
        Register.leggTilPerson(personGroentLoep);
        MeldingOmUtflytting meldingOmUtflytting1 = Meldinger.genererMeldingGroentLoep(personGroentLoep);
        utflyttingKontroller.utflytting(meldingOmUtflytting1);

        // todo: Add assert: OK
    }

    @Test
    void utflyttingBarn() {

        Person personBarn = Personer.getPersonMedarn();
        Register.leggTilPerson(personBarn);
        MeldingOmUtflytting meldingOmUtflytting2 = Meldinger.genererMeldingMedarn(personBarn);
        utflyttingKontroller.utflytting(meldingOmUtflytting2);

        // todo: Add assert: IKKE OK
    }

    @Test
    void utflyttingVoksenMedBarn() {

        Person personVoksenMedBarn = Personer.getPersonMedarn();
        Register.leggTilPerson(personVoksenMedBarn);
        MeldingOmUtflytting meldingOmUtflytting3 = Meldinger.genererMeldingMedarn(personVoksenMedBarn);
        utflyttingKontroller.utflytting(meldingOmUtflytting3);

        // todo: Add assert: IKKE OK
    }


}