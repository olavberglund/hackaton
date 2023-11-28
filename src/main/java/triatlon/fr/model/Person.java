package triatlon.fr.model;

import java.time.LocalDate;

public class Person {
    private String identifikator;
    private String navn;
    private String adresse;
    private LocalDate fodselsdato;
    private int antallBarn;
    private Person ektefelle;
    private Status status;

    public enum Status {
        BOSATT, DOED, UTFLYTTET
    }

    private Person() { }

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }

        public Builder medIdentifikator(String identifikator) {
            person.identifikator = identifikator;
            return this;
        }

        public Builder medNavn(String navn) {
            person.navn = navn;
            return this;
        }

        public Builder medAdresse(String adresse) {
            person.adresse = adresse;
            return this;
        }

        public Builder medFodselsdato(LocalDate fodselsdato) {
            person.fodselsdato = fodselsdato;
            return this;
        }

        public Builder medAntallBarn(int antallBarn) {
            person.antallBarn = antallBarn;
            return this;
        }

        public Builder medEktefelle(Person ektefelle) {
            person.ektefelle = ektefelle;
            return this;
        }

        public Builder medStatus(Status status) {
            person.status = status;
            return this;
        }

        public Person bygg() {
            return person;
        }
    }

    public String getIdentifikator() {
        return identifikator;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public LocalDate getFodselsdato() {
        return fodselsdato;
    }

    public int getAntallBarn() {
        return antallBarn;
    }

    public void setIdentifikator(String identifikator) {
        this.identifikator = identifikator;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setFodselsdato(LocalDate fodselsdato) {
        this.fodselsdato = fodselsdato;
    }

    public void setAntallBarn(int antallBarn) {
        this.antallBarn = antallBarn;
    }

    public void setEktefelle(Person ektefelle) {
        this.ektefelle = ektefelle;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Person getEktefelle() {
        return ektefelle;
    }

    public Status getStatus() {
        return status;
    }
}
