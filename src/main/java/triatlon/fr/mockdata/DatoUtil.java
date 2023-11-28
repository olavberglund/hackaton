package triatlon.fr.mockdata;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class DatoUtil {

    public static LocalDate genererFodselsdatoForBarn() {
        long minDay = LocalDate.of(LocalDate.now().getYear() - 10, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalDate genererFodselsdatoForVoksen() {
        long minDay = LocalDate.of(LocalDate.now().getYear() - 65, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(LocalDate.now().getYear() - 18, 1, 1).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalDate genererFodselsdatoFor18Aar() {
        return LocalDate.now().minusYears(18);
    }

    public static LocalDate genererFodselsdatoFor17Aar() {
        return LocalDate.now().minusYears(17);
    }
}