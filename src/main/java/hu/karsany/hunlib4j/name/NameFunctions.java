package hu.karsany.hunlib4j.name;

import java.util.ArrayList;
import java.util.List;

/**
 * Alap név funkciók
 */
public final class NameFunctions {
    private NameFunctions() {
    }

    /**
     * Eldönti egy stringről, hogy titulus-e. Teljesen alap, használhatatlan verzió.
     *
     * @param s string bemenet
     * @return igaz, ha titulus, hamis ha nem titulus
     * @todo egyelőre csak a Dr. titulust kezeli.
     */
    public static boolean isTitle(String s) {
        return (s.toUpperCase().trim().equals("DR."));
    }

    /**
     * Kapott stringet szóközönklnt darabokra bont úgy,
     * hogy csak a nem titulus stringek maradnak benne
     *
     * @param name string bemenet, amit darabolni fogunk
     * @return darabolt string a titulusok nélkül, lista.
     */
    public static List<String> getTileArray(String name) {
        List<String> strings = new ArrayList<String>();

        for (String s : name.split(" ")) {
            if (isTitle(s)) {
                strings.add(s);
            }
        }

        return strings;
    }

    /**
     * Kapott stringet szóközönklnt darabokra bont úgy,
     * hogy csak a titulus stringek maradnak benne
     *
     * @param name string bemenet, amit darabolni fogunk
     * @return darabolt string csak a titulusokkal, lista.
     */
    public static List<String> getNoTitleArray(String name) {
        List<String> strings = new ArrayList<String>();

        for (String s : name.split(" ")) {
            if (!isTitle(s)) {
                strings.add(s);
            }
        }

        return strings;
    }


}
