/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Ferenc Karsany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
