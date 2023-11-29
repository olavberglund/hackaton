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
}

