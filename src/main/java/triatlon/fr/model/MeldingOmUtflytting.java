package triatlon.fr.model;

import java.time.LocalDate;

public class MeldingOmUtflytting {
    private String identifikator;
    private String tilflytningsland;
    private LocalDate tilflytningsdato;
    private boolean boligIUtlandet;
    private boolean dokumentasjonForBoligIUtlandet;
    private boolean ektefelleINorge;
    private boolean barnINorge;
    private boolean oppholdINorge;
    private int antallDagerINorgeTotalt;
    private int maksAntallDagerINorgeAvgangen;
    private boolean arbeidsforholdINorge;

    private MeldingOmUtflytting() { }

    public static class Builder {
        private MeldingOmUtflytting meldingOmUtflytting;

        public Builder() {
            meldingOmUtflytting = new MeldingOmUtflytting();
        }

        public Builder medIdentifikator(String identifikator) {
            meldingOmUtflytting.identifikator = identifikator;
            return this;
        }

        public Builder medTilflytningsland(String tilflytningsland) {
            meldingOmUtflytting.tilflytningsland = tilflytningsland;
            return this;
        }

        public Builder medTilflytningsdato(LocalDate tilflytningsdato) {
            meldingOmUtflytting.tilflytningsdato = tilflytningsdato;
            return this;
        }

        public Builder medBoligIUtlandet(boolean boligIUtlandet) {
            meldingOmUtflytting.boligIUtlandet = boligIUtlandet;
            return this;
        }

        public Builder medDokumentasjonForBoligIUtlandet(boolean dokumentasjonForBoligIUtlandet) {
            meldingOmUtflytting.dokumentasjonForBoligIUtlandet = dokumentasjonForBoligIUtlandet;
            return this;
        }

        public Builder medEktefelleINorge(boolean ektefelleINorge) {
            meldingOmUtflytting.ektefelleINorge = ektefelleINorge;
            return this;
        }

        public Builder medBarnINorge(boolean barnINorge) {
            meldingOmUtflytting.barnINorge = barnINorge;
            return this;
        }

        public Builder medOppholdINorge(boolean oppholdINorge) {
            meldingOmUtflytting.oppholdINorge = oppholdINorge;
            return this;
        }

        public Builder medAntallDagerINorgeTotalt(int antallDagerINorgeTotalt) {
            meldingOmUtflytting.antallDagerINorgeTotalt = antallDagerINorgeTotalt;
            return this;
        }

        public Builder medMaksAntallDagerINorgeAvgangen(int maksAntallDagerINorgeAvgangen) {
            meldingOmUtflytting.maksAntallDagerINorgeAvgangen = maksAntallDagerINorgeAvgangen;
            return this;
        }

        public Builder medArbeidsforholdINorge(boolean arbeidsforholdINorge) {
            meldingOmUtflytting.arbeidsforholdINorge = arbeidsforholdINorge;
            return this;
        }

        public MeldingOmUtflytting build() {
            return meldingOmUtflytting;
        }
    }

    public String getIdentifikator() {
        return identifikator;
    }

    public String getTilflytningsland() {
        return tilflytningsland;
    }

    public LocalDate getTilflytningsdato() {
        return tilflytningsdato;
    }

    public boolean isBoligIUtlandet() {
        return boligIUtlandet;
    }

    public boolean isDokumentasjonForBoligIUtlandet() {
        return dokumentasjonForBoligIUtlandet;
    }

    public boolean isEktefelleINorge() {
        return ektefelleINorge;
    }

    public boolean isBarnINorge() {
        return barnINorge;
    }

    public boolean isOppholdINorge() {
        return oppholdINorge;
    }

    public int getAntallDagerINorgeTotalt() {
        return antallDagerINorgeTotalt;
    }

    public int getMaksAntallDagerINorgeAvgangen() {
        return maksAntallDagerINorgeAvgangen;
    }

    public boolean isArbeidsforholdINorge() {
        return arbeidsforholdINorge;
    }
}


