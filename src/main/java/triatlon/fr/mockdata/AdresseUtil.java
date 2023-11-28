package triatlon.fr.mockdata;

import java.util.Random;

public class AdresseUtil {

    private static final String[] BYER = {"Oslo", "Bergen", "Trondheim", "Stavanger", "Drammen", "Fredrikstad", "Porsgrunn", "Skien", "Kristiansand", "Ålesund", "Tønsberg", "Moss", "Haugesund", "Sandefjord", "Arendal", "Bodø", "Tromsø", "Hamar", "Halden", "Larvik"};

    public static String genererByNummer() {
        Random random = new Random();
        int byIndex = random.nextInt(BYER.length);
        int nummer = random.nextInt(100);

        return BYER[byIndex] + " " + nummer;
    }
}