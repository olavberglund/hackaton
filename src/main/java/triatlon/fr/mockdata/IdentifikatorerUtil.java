package triatlon.fr.mockdata;

import java.time.LocalDate;
import java.util.Random;

public class IdentifikatorerUtil {

    private IdentifikatorerUtil() { }

    public static String genererIdentifikator(LocalDate foedselsdato) {

        int dag = foedselsdato.getDayOfMonth();
        int maaned = foedselsdato.getMonthValue();
        int aarToSisteSifre = foedselsdato.getYear() % 100;

        Random random = new Random();
        char tegn = random.nextBoolean() ? 'A' : (random.nextBoolean() ? '-' : '+');

        int tresifretTall = random.nextInt(900) + 100;

        char bokstav;
        do {
            bokstav = (char) (random.nextInt(25) + 'A');
        } while (bokstav == 'G' || bokstav == 'I' || bokstav == 'O' || bokstav == 'Q');

        return String.format("%02d%02d%02d%c%03d%c", dag, maaned, aarToSisteSifre, tegn, tresifretTall, bokstav);
    }
}