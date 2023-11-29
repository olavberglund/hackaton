package triatlon.fr.mockdata;

import java.time.LocalDate;

import triatlon.fr.model.MeldingOmUtflytting;
import triatlon.fr.model.Person;

public class Meldinger {
    public static MeldingOmUtflytting genererMeldingGroentLoep(Person person) {
        return new MeldingOmUtflytting.Builder()
                .medIdentifikator(person.getIdentifikator())
                .medTilflytningsland("USA")
                .medTilflytningsdato(LocalDate.now().minusDays(5))
                .medBoligIUtlandet(true)
                .medDokumentasjonForBoligIUtlandet(true)
                .medEktefelleINorge(false)
                .medBarnINorge(false)
                .medOppholdINorge(false)
                .medArbeidsforholdINorge(false)
                .build();
    }

    public static MeldingOmUtflytting genererMeldingMedBarn(Person personBarn) {
        return new MeldingOmUtflytting.Builder()
                .medIdentifikator(personBarn.getIdentifikator())
                .medTilflytningsland("USA")
                .medTilflytningsdato(LocalDate.now().minusDays(5))
                .medBoligIUtlandet(true)
                .medDokumentasjonForBoligIUtlandet(true)
                .medEktefelleINorge(false)
                .medBarnINorge(true)
                .medOppholdINorge(false)
                .medArbeidsforholdINorge(false)
                .build();
    }

    public static MeldingOmUtflytting genererMeldingMedEktefelle(Person personHarEktefelle) {
        return new MeldingOmUtflytting.Builder()
                .medIdentifikator(personHarEktefelle.getIdentifikator())
                .medTilflytningsland("USA")
                .medTilflytningsdato(LocalDate.now().minusDays(5))
                .medBoligIUtlandet(true)
                .medDokumentasjonForBoligIUtlandet(true)
                .medEktefelleINorge(true)
                .medBarnINorge(false)
                .medOppholdINorge(false)
                .medArbeidsforholdINorge(false)
                .build();
    }

    public static MeldingOmUtflytting genererMeldingAlleredeUtflyttet(Person personUtenforNorge) {
        return new MeldingOmUtflytting.Builder()
                .medIdentifikator(personUtenforNorge.getIdentifikator())
                .medTilflytningsland("USA")
                .medTilflytningsdato(LocalDate.now().minusDays(5))
                .medBoligIUtlandet(true)
                .medDokumentasjonForBoligIUtlandet(true)
                .medEktefelleINorge(false)
                .medBarnINorge(false)
                .medOppholdINorge(false)
                .medArbeidsforholdINorge(false)
                .build();
    }

    public static MeldingOmUtflytting genererMeldingHarBarnOgEktefelleOgAlleredeUtflyttet(Person personHarBarnOgEktefelleOgAlleredeUtflyttet) {
        return new MeldingOmUtflytting.Builder()
                .medIdentifikator(personHarBarnOgEktefelleOgAlleredeUtflyttet.getIdentifikator())
                .medTilflytningsland("USA")
                .medTilflytningsdato(LocalDate.now().minusDays(5))
                .medBoligIUtlandet(true)
                .medDokumentasjonForBoligIUtlandet(true)
                .medEktefelleINorge(true)
                .medBarnINorge(true)
                .medOppholdINorge(false)
                .medArbeidsforholdINorge(false)
                .build();
    }
}

