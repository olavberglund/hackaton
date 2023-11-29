package triatlon.fr.model;

import java.util.HashMap;
import java.util.Map;

public class Register {
    private static final Map<String, Person> registerPersoner = new HashMap<>();

    public static void leggTilPerson(Person person) {
        registerPersoner.put(person.getIdentifikator(), person);
    }

    public static Person hentPerson(String identifikator) {
        return registerPersoner.get(identifikator);
    }
}
