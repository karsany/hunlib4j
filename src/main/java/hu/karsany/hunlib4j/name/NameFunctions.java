package hu.karsany.hunlib4j.name;

import java.util.ArrayList;
import java.util.List;

/**
 * Alap név funkciók
 */
final class NameFunctions {
    private NameFunctions() {
    }

    /**
     * Eldönti egy stringről, hogy titulus-e. A titulusok a resources/name/TITULUS.txt-ben
     * vannak fölsorolva soronként. Új titulus esetén ezt szükséges bővíteni.
     *
     * @param s string bemenet
     * @return igaz, ha titulus, hamis ha nem titulus
     */
    public static boolean isTitle(String s) {
        if (s == null) {
            return false;
        }
        return TitulusSet.getInstance().contains(s.toUpperCase().trim());
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
