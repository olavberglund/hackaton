package triatlon.fr;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingGroentLoep(personGroentLoep);
        Action utflytting = utflyttingKontroller.utflytting(meldingOmUtflytting);
        assertEquals(Action.CONTINUE, utflytting);
    }

    @Test
    void utflyttingBarn() {

        Person personBarn = Personer.getPersonMeBarn();
        Register.leggTilPerson(personBarn);
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingMedBarn(personBarn);
        utflyttingKontroller.utflytting(meldingOmUtflytting);
        Action utflytting = utflyttingKontroller.utflytting(meldingOmUtflytting);

        assertEquals(Action.CANCEL, utflytting);
    }

    @Test
    void utflyttingVoksenMedBarn() {

        Person personVoksenMedBarn = Personer.getPersonMeBarn();
        Register.leggTilPerson(personVoksenMedBarn);
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingMedBarn(personVoksenMedBarn);
        utflyttingKontroller.utflytting(meldingOmUtflytting);

        // todo: Add assert: IKKE OK
    }

    @Test
    void utflyttingHarEktefelle() {

        Person personHarEktefelle = Personer.getPersonMedEktefelle();
        Register.leggTilPerson(personHarEktefelle);
        Register.leggTilPerson(personHarEktefelle.getEktefelle());
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingMedEktefelle(personHarEktefelle);
        utflyttingKontroller.utflytting(meldingOmUtflytting);

        // todo: Add assert: IKKE OK
    }

    @Test
    void utflyttingAlleredeUtflyttet() {

        Person personUtenforNorge = Personer.getPersonUtenforNorge();
        Register.leggTilPerson(personUtenforNorge);
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingAlleredeUtflyttet(personUtenforNorge);
        utflyttingKontroller.utflytting(meldingOmUtflytting);

        // todo: Add assert: IKKE OK
    }

    @Test
    void utflyttingHarBarnOgEktefelleOgAlleredeUtflyttet() {

        Person personHarBarnOgEktefelleOgAlleredeUtflyttet = Personer.getPersonHarBarnOgEktefelleOgAlleredeUtflyttet();
        Register.leggTilPerson(personHarBarnOgEktefelleOgAlleredeUtflyttet);
        Register.leggTilPerson(personHarBarnOgEktefelleOgAlleredeUtflyttet.getEktefelle());
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingHarBarnOgEktefelleOgAlleredeUtflyttet(personHarBarnOgEktefelleOgAlleredeUtflyttet);
        Action action = utflyttingKontroller.utflytting(meldingOmUtflytting);

        assertEquals(Action.CANCEL, action);
    }
}