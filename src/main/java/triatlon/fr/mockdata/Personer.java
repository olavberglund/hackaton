package triatlon.fr.mockdata;

import java.time.LocalDate;

import triatlon.fr.model.Person;

public class Personer {
    public static Person getPersonGroentLoep() {
        LocalDate foedselsdato = DatoUtil.genererFodselsdatoForVoksen();
        return new Person.Builder()
                .medFodselsdato(foedselsdato)
                .medIdentifikator(IdentifikatorerUtil.genererIdentifikator(foedselsdato))
                .medNavn(NavnUtil.genererAdjektivSubstantiv())
                .medAdresse(AdresseUtil.genererByNummer())
                .medAntallBarn(0)
                .medEktefelle(null)
                .medStatus(Person.Status.BOSATT)
                .bygg();
    }

    public static Person getPersonMeBarn() {
        LocalDate foedselsdato = DatoUtil.genererFodselsdatoForVoksen();
        return new Person.Builder()
                .medFodselsdato(foedselsdato)
                .medIdentifikator(IdentifikatorerUtil.genererIdentifikator(foedselsdato))
                .medNavn(NavnUtil.genererAdjektivSubstantiv())
                .medAdresse(AdresseUtil.genererByNummer())
                .medAntallBarn(1)
                .medEktefelle(null)
                .medStatus(Person.Status.BOSATT)
                .bygg();
    }

    public static Person getPersonUtenforNorge() {
        LocalDate foedselsdato = DatoUtil.genererFodselsdatoForVoksen();
        return new Person.Builder()
                .medFodselsdato(foedselsdato)
                .medIdentifikator(IdentifikatorerUtil.genererIdentifikator(foedselsdato))
                .medNavn(NavnUtil.genererAdjektivSubstantiv())
                .medAdresse(AdresseUtil.genererByNummer())
                .medAntallBarn(0)
                .medEktefelle(null)
                .medStatus(Person.Status.UTFLYTTET)
                .bygg();
    }

    public static Person getPersonUnder18() {
        LocalDate foedselsdato = DatoUtil.genererFodselsdatoForBarn();
        return new Person.Builder()
                .medFodselsdato(foedselsdato)
                .medIdentifikator(IdentifikatorerUtil.genererIdentifikator(foedselsdato))
                .medNavn(NavnUtil.genererAdjektivSubstantiv())
                .medAdresse(AdresseUtil.genererByNummer())
                .medAntallBarn(0)
                .medEktefelle(null)
                .medStatus(Person.Status.BOSATT)
                .bygg();
    }

    public static Person getPersonAkkurat18() {
        return new Person.Builder()
                .medFodselsdato(LocalDate.now().minusYears(18))
                .medIdentifikator(IdentifikatorerUtil.genererIdentifikator(LocalDate.now().minusYears(18)))
                .medNavn(NavnUtil.genererAdjektivSubstantiv())
                .medAdresse(AdresseUtil.genererByNummer())
                .medAntallBarn(0)
                .medEktefelle(null)
                .medStatus(Person.Status.BOSATT)
                .bygg();
    }

    public static Person getPersonMedEktefelle() {
        String adresse = AdresseUtil.genererByNummer();
        LocalDate foedselsdatoEktefelle1 = DatoUtil.genererFodselsdatoForVoksen();
        LocalDate foedselsdatoEktefelle2 = DatoUtil.genererFodselsdatoForVoksen();

        Person ektefelle1 = new Person.Builder()
                .medFodselsdato(foedselsdatoEktefelle1)
                .medIdentifikator(IdentifikatorerUtil.genererIdentifikator(foedselsdatoEktefelle1))
                .medNavn(NavnUtil.genererAdjektivSubstantiv())
                .medAdresse(adresse)
                .medAntallBarn(0)
                .medStatus(Person.Status.BOSATT)
                .bygg();

        Person ektefelle2 = new Person.Builder()
                .medFodselsdato(foedselsdatoEktefelle2)
                .medIdentifikator(IdentifikatorerUtil.genererIdentifikator(foedselsdatoEktefelle2))
                .medNavn(NavnUtil.genererAdjektivSubstantiv())
                .medAdresse(adresse)
                .medAntallBarn(0)
                .medStatus(Person.Status.BOSATT)
                .bygg();

        ektefelle1.setEktefelle(ektefelle2);
        ektefelle2.setEktefelle(ektefelle1);

        return ektefelle1;
    }

}
