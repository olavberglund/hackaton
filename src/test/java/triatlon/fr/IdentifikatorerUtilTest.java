package triatlon.fr;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import triatlon.fr.mockdata.IdentifikatorerUtil;

class IdentifikatorerUtilTest {

    @Test
    void genererIdentifikatorSkalReturnereKorrektFormat() {
        String identifikator = IdentifikatorerUtil.genererIdentifikator(LocalDate.of(1990, 5, 15));
        String forventetResultat = "150590";
        assertTrue(identifikator.matches("\\d{6}[A+-]\\d{3}[A-FHJ-NP-Z]"));
        assertEquals(forventetResultat, identifikator.substring(0, 6));
        assertEquals(11, identifikator.length());
    }
}
