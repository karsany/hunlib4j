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

import java.util.List;

/**
 * Névdaraboló osztály.
 *
 * @author Ferenc Karsány
 * @since 1.0
 */
public final class NameSplitter {

    private NameSplitter() {
    }

    /**
     * Feldarabolja a paraméterként kapott nevet. Használati esetekért
     * lásd a NameSplitterTest teszt osztályt.
     *
     * @param name összetett név
     * @return darabolt személynév
     */
    public static PersonName splitName(String name) {
        PersonName personName = new PersonName();

        if (name != null && name.trim().length() != 0) {

            String cleanName = cleanName(name);

            List<String> parts = NameFunctions.getNoTitleArray(cleanName);
            List<String> titles = NameFunctions.getTileArray(cleanName);

            switch (parts.size()) {
                case 2:
                    splitNameSize2(personName, parts);
                    break;
                case 3:
                    splitNameSize3(personName, parts);
                    break;
                case 4:
                    splitNameSize4(personName, parts);
                    break;
                case 5:
                    splitNameSize5(personName, parts);
                    break;
                case 6:
                    splitNameSize6(personName, parts);
                    break;
                default:
                    throw new UnsupportedOperationException("A daraboló csak 2, 3, 4, 5 és 6 részből álló neveket tud darabolni.");
            }


            setTitles(personName, titles);

        }


        return personName;
    }

    private static String cleanName(String s) {
        String ss = s.replaceAll("- ", "-");
        ss = ss.replaceAll(" -", "-");
        ss = ss.replaceAll(" *\\.", ".");
        ss = ss.replaceAll("\\.", ". ");
        ss = ss.replaceAll("  *", " ");
        ss = ss.trim();
        return ss;
    }

    private static void setTitles(PersonName personName, List<String> titles) {
        if (!titles.isEmpty()) {
            personName.setBeforeTitle(titles.get(0));

            if (titles.size() >= 2) {
                personName.setAfterTitle(titles.get(1));
            }

        }
    }

    private static void splitNameSize6(PersonName personName, List<String> parts) {
        if (parts.get(2).toUpperCase().endsWith("NÉ")) {
            personName.setLastName(parts.get(0) + " " + parts.get(1) + " " + parts.get(2) + " " + parts.get(3));
            personName.setFirstName1(parts.get(4));
            personName.setFirstName2(parts.get(5));
        }
    }

    private static void splitNameSize5(PersonName personName, List<String> parts) {
        if (parts.get(1).toUpperCase().endsWith("NÉ")) {
            personName.setLastName(parts.get(0) + " " + parts.get(1) + " " + parts.get(2));
            personName.setFirstName1(parts.get(3));
            personName.setFirstName2(parts.get(4));
        } else if (parts.get(2).toUpperCase().endsWith("NÉ")) {
            personName.setLastName(parts.get(0) + " " + parts.get(1) + " " + parts.get(2) + " " + parts.get(3));
            personName.setFirstName1(parts.get(4));
        }
    }

    private static void splitNameSize4(PersonName personName, List<String> parts) {
        if (parts.get(1).toUpperCase().endsWith("NÉ")) {
            personName.setLastName(parts.get(0) + " " + parts.get(1) + " " + parts.get(2));
            personName.setFirstName1(parts.get(3));
        } else if (parts.get(0).toUpperCase().endsWith("NÉ")) {
            personName.setLastName(parts.get(0) + " " + parts.get(1));
            personName.setFirstName1(parts.get(2));
            personName.setFirstName2(parts.get(3));
        } else if ((parts.get(0).length() == 2 && parts.get(0).endsWith(".")) ||
                (parts.get(1).length() == 2 && parts.get(1).endsWith("."))) {
            personName.setLastName(parts.get(0) + " " + parts.get(1));
            personName.setFirstName1(parts.get(2));
            personName.setFirstName2(parts.get(3));
        }
    }

    private static void splitNameSize3(PersonName personName, List<String> parts) {
        if (parts.get(0).toUpperCase().endsWith("NÉ")) {
            personName.setLastName(parts.get(0) + " " + parts.get(1));
            personName.setFirstName1(parts.get(2));
        } else if ((parts.get(0).length() == 2 && parts.get(0).endsWith(".")) ||
                (parts.get(1).length() == 2 && parts.get(1).endsWith("."))) {
            personName.setLastName(parts.get(0) + " " + parts.get(1));
            personName.setFirstName1(parts.get(2));
        } else {
            splitNameSize2(personName, parts);
            personName.setFirstName2(parts.get(2));
        }
    }

    private static void splitNameSize2(PersonName personName, List<String> parts) {
        personName.setLastName(parts.get(0));
        personName.setFirstName1(parts.get(1));
    }

}
