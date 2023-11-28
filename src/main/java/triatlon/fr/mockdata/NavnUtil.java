package triatlon.fr.mockdata;
import java.util.Random;

public class NavnUtil {

    private static final String[] ADJEKTIVER = {"STOR", "LITEN", "RASK", "LANGSOM", "GLAD", "TRIST"};
    private static final String[] SUBSTANTIVER = {"HUND", "KATT", "HUS", "BIL", "TRE", "STEIN"};

    public static String genererAdjektivSubstantiv() {
        Random random = new Random();
        int adjektivIndex = random.nextInt(ADJEKTIVER.length);
        int substantivIndex = random.nextInt(SUBSTANTIVER.length);

        return ADJEKTIVER[adjektivIndex] + " " + SUBSTANTIVER[substantivIndex];
    }

}

