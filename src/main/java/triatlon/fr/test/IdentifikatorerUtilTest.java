package triatlon.fr.test;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import triatlon.fr.IdentifikatorerUtil;

class IdentifikatorerUtilTest {

    @Test
    void genererFinskIdentifikatorSkalReturnereKorrektFormat() {
        String identifikator = IdentifikatorerUtil.genererIdentifikatorFinsk(LocalDate.of(1990, 5, 15));
        assertTrue(identifikator.matches("\\d{6}[A+-]\\d{3}[A-FH-Z]"));
    }

    @Test
    void genererSvenskIdentifikatorSkalReturnereKorrektFormat() {
        String identifikator = IdentifikatorerUtil.genererIdentifikatorSverige(LocalDate.of(1990, 5, 15));
        assertTrue(identifikator.matches("\\d{6}[+-]\\d{4}"));
    }

    @Test
    void genererSvenskIdentifikatorSkalReturnerePlussForEldreEnn100Aar() {
        String identifikator = IdentifikatorerUtil.genererIdentifikatorSverige(LocalDate.of(1900, 5, 15));
        assertTrue(identifikator.charAt(6) == '+');
    }

    @Test
    void genererFaeroyskIdentifikatorSkalReturnereKorrektFormat() {
        String identifikator = IdentifikatorerUtil.genererIdentifikatorFaeroyene(LocalDate.of(1990, 5, 15));
        assertTrue(identifikator.matches("\\d{6}\\d{3}"));
    }

    @Test
    void genererDanskIdentifikatorSkalReturnereKorrektFormat() {
        String identifikator = IdentifikatorerUtil.genererIdentifikatorDansk(LocalDate.of(1990, 5, 15));
        assertTrue(identifikator.matches("\\d{6}\\d{4}"));
    }

    @Test
    void genererIslandskIdentifikatorSkalReturnereKorrektFormat() {
        String identifikator = IdentifikatorerUtil.genererIdentifikatorIsland(LocalDate.of(1990, 5, 15));
        assertTrue(identifikator.matches("\\d{6}\\d{4}"));
    }
}
