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

        String cName = name;


        if (cName != null && cName.trim().length() != 0) {

            cName = cName.replaceAll("- ", "-");
            cName = cName.replaceAll(" -", "-");
            cName = cName.replaceAll(" *\\.", ".");
            cName = cName.replaceAll("\\.", ". ");
            cName = cName.replaceAll("  *", " ");
            cName = cName.trim();


            List<String> parts = NameFunctions.getNoTitleArray(cName);
            List<String> titles = NameFunctions.getTileArray(cName);

            if (parts.size() == 2) {
                personName.setLastName(parts.get(0));
                personName.setFirstName1(parts.get(1));
            } else if (parts.size() == 3) {
                if (parts.get(0).toUpperCase().endsWith("NÉ")) {
                    personName.setLastName(parts.get(0) + " " + parts.get(1));
                    personName.setFirstName1(parts.get(2));
                } else if ((parts.get(0).length() == 2 && parts.get(0).endsWith(".")) ||
                        (parts.get(1).length() == 2 && parts.get(1).endsWith("."))) {
                    personName.setLastName(parts.get(0) + " " + parts.get(1));
                    personName.setFirstName1(parts.get(2));
                } else {
                    personName.setLastName(parts.get(0));
                    personName.setFirstName1(parts.get(1));
                    personName.setFirstName2(parts.get(2));
                }
            } else if (parts.size() == 4) {
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
            } else if (parts.size() == 5) {
                if (parts.get(1).toUpperCase().endsWith("NÉ")) {
                    personName.setLastName(parts.get(0) + " " + parts.get(1) + " " + parts.get(2));
                    personName.setFirstName1(parts.get(3));
                    personName.setFirstName2(parts.get(4));
                } else if (parts.get(2).toUpperCase().endsWith("NÉ")) {
                    personName.setLastName(parts.get(0) + " " + parts.get(1) + " " + parts.get(2) + " " + parts.get(3));
                    personName.setFirstName1(parts.get(4));
                }
            } else if (parts.size() == 6) {
                if (parts.get(2).toUpperCase().endsWith("NÉ")) {
                    personName.setLastName(parts.get(0) + " " + parts.get(1) + " " + parts.get(2) + " " + parts.get(3));
                    personName.setFirstName1(parts.get(4));
                    personName.setFirstName2(parts.get(5));
                }
            }

            if (titles.size() >= 1) {
                personName.setBeforeTitle(titles.get(0));
            }

            if (titles.size() >= 2) {
                personName.setAfterTitle(titles.get(1));
            }


        }


        return personName;
    }

}
