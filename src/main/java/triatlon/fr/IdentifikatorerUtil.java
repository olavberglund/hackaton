package triatlon.fr;

import java.time.LocalDate;
import java.util.Random;

public class IdentifikatorerUtil {

    private IdentifikatorerUtil() { }

    public static String genererIdentifikatorFinsk(LocalDate foedselsdato) {

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

    public static String genererIdentifikatorSverige(LocalDate foedselsdato) {

        int aarToSisteSifre = foedselsdato.getYear() % 100;
        int maaned = foedselsdato.getMonthValue();
        int dag = foedselsdato.getDayOfMonth();

        char alderSymbol = (LocalDate.now().getYear() - foedselsdato.getYear() > 100) ? '+' : '-';

        int firesifretTall = new Random().nextInt(9000) + 1000;

        return String.format("%02d%02d%02d%c%04d", aarToSisteSifre, maaned, dag, alderSymbol, firesifretTall);
    }

    public static String genererIdentifikatorFaeroyene(LocalDate foedselsdato) {

        int aarToSisteSifre = foedselsdato.getYear() % 100;
        int maaned = foedselsdato.getMonthValue();
        int dag = foedselsdato.getDayOfMonth();

        int tresifretTall = new Random().nextInt(900) + 100;

        return String.format("%02d%02d%02d%03d", dag, maaned, aarToSisteSifre, tresifretTall);

    }

    public static String genererIdentifikatorDansk(LocalDate foedselsdato) {
        return genererIdentifikatorDatoPlussSiffer(foedselsdato);
    }

    public static String genererIdentifikatorIsland(LocalDate foedselsdato) {
        return genererIdentifikatorDatoPlussSiffer(foedselsdato);
    }

    private static String genererIdentifikatorDatoPlussSiffer(LocalDate foedselsdato) {

        int dag = foedselsdato.getDayOfMonth();
        int maaned = foedselsdato.getMonthValue();
        int aarToSisteSifre = foedselsdato.getYear() % 100;

        int firesifretTall = new Random().nextInt(9000) + 1000;

        return String.format("%02d%02d%02d%04d", dag, maaned, aarToSisteSifre, firesifretTall);
    }
}