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
        Action utflytting = utflyttingKontroller.utflytting(meldingOmUtflytting, personGroentLoep);
        assertEquals(Action.CONTINUE, utflytting);
    }

    @Test
    void utflyttingHarEktefelle() {
        Person personHarEktefelle = Personer.getPersonMedEktefelle();
        Register.leggTilPerson(personHarEktefelle);
        Register.leggTilPerson(personHarEktefelle.getEktefelle());
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingMedEktefelle(personHarEktefelle);

        Action utflytting = utflyttingKontroller.utflytting(meldingOmUtflytting, personHarEktefelle);
        assertEquals(Action.MANUAL, utflytting);
    }

    @Test
    void utflyttingAlleredeUtflyttet() {
        Person personUtenforNorge = Personer.getPersonUtenforNorge();
        Register.leggTilPerson(personUtenforNorge);
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingAlleredeUtflyttet(personUtenforNorge);
        utflyttingKontroller.utflytting(meldingOmUtflytting, personUtenforNorge);

        Action utflytting = utflyttingKontroller.utflytting(meldingOmUtflytting, personUtenforNorge);
        assertEquals(Action.CANCEL, utflytting);
    }

    @Test
    void utflyttingHarBarnOgEktefelleOgAlleredeUtflyttet() {

        Person personHarBarnOgEktefelleOgAlleredeUtflyttet = Personer.getPersonHarBarnOgEktefelleOgAlleredeUtflyttet();
        Register.leggTilPerson(personHarBarnOgEktefelleOgAlleredeUtflyttet);
        Register.leggTilPerson(personHarBarnOgEktefelleOgAlleredeUtflyttet.getEktefelle());
        MeldingOmUtflytting meldingOmUtflytting = Meldinger.genererMeldingHarBarnOgEktefelleOgAlleredeUtflyttet(personHarBarnOgEktefelleOgAlleredeUtflyttet);
        Action action = utflyttingKontroller.utflytting(meldingOmUtflytting,personHarBarnOgEktefelleOgAlleredeUtflyttet);

        assertEquals(Action.CANCEL, action);
    }
}