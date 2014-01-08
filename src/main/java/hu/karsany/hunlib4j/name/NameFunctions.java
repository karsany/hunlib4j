package hu.karsany.hunlib4j.name;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkarsany on 2014.01.08..
 */
public final class NameFunctions {
    private NameFunctions() {
    }

    public static boolean isTitle(String s) {
        return (s.toUpperCase().trim().equals("DR."));
    }

    public static List<String> getTileArray(String name) {
        List<String> strings = new ArrayList<String>();

        for (String s : name.split(" ")) {
            if (isTitle(s)) {
                strings.add(s);
            }
        }

        return strings;
    }

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
