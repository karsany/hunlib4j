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

package hu.karsany.hunlib4j.number;


/**
 * Személyes azonosítószámok ellenőrzésére szolgáló csomag.
 *
 * @author Ferenc Karsány
 * @since 1.0
 */
public final class CheckIdentityNumbers {

    private CheckIdentityNumbers() {
    }

    /**
     * Azonosító szám hibák:
     * <ul>
     * <li>OK - helyes azonosító szám</li>
     * <li>EMPTY - ha üres</li>
     * <li>LENGTH_ERROR - ha a hossz nem megfelelő</li>
     * <li>FORMAT_ERROR - ha nem illeszkedik a szükséges formára</li>
     * <li>OTHER_ERROR - egyéb hiba, a konkrét eljárásban van definiálva a hiba oka</li>
     * <li>CDV_ERROR - ha az ellenőrző szám nem egyezik az utolsó számjeggyel</li>
     * </ul>
     */
    public enum IdentityNumberError {
        OK, EMPTY, LENGTH_ERROR, FORMAT_ERROR, OTHER_ERROR, CDV_ERROR
    }

    /**
     * TAJ szám ellenőrzése.
     * <p/>
     * <p>A TAJ szám egy kilenc számjegyből álló szám, amelyben az első nyolc számjegy egy
     * folyamatosan kiadott egyszerű sorszám, amely mindig az előző, utoljára kiadott
     * sorszámból egy hozzáadásával keletkezik.
     * <p/>
     * <p>A kilencedik számjegy ellenőrző ún. CDV kód, melynek képzési algoritmusa az alábbi:
     * <p/>
     * <ul>
     * <li>A TAJ szám első nyolc számjegyéből a páratlan helyen állókat hárommal,
     * a páros helyen állókat héttel szorozzuk, és a szorzatokat összeadjuk.</li>
     * <li>Az összeget tízzel elosztva a maradékot tekintjük a kilencedik, azaz CDV kódnak.</li>
     * </ul>
     *
     * @param taj társadalom biztosítási szám
     * @return hibakód
     */
    public static IdentityNumberError checkTAJ(final String taj) {

        if (taj == null || taj.isEmpty()) {
            return IdentityNumberError.EMPTY;
        }

        if (taj.length() != 9) {
            return IdentityNumberError.LENGTH_ERROR;
        }

        try {
            String tesztTaj = "000000000" + Integer.parseInt(taj);
            if (!tesztTaj.endsWith(taj)) {
                return IdentityNumberError.FORMAT_ERROR;
            }
        } catch (NumberFormatException e) {
            return IdentityNumberError.FORMAT_ERROR;
        }

        int no1 = Integer.parseInt(Character.toString(taj.charAt(0)));
        int no2 = Integer.parseInt(Character.toString(taj.charAt(1)));
        int no3 = Integer.parseInt(Character.toString(taj.charAt(2)));
        int no4 = Integer.parseInt(Character.toString(taj.charAt(3)));
        int no5 = Integer.parseInt(Character.toString(taj.charAt(4)));
        int no6 = Integer.parseInt(Character.toString(taj.charAt(5)));
        int no7 = Integer.parseInt(Character.toString(taj.charAt(6)));
        int no8 = Integer.parseInt(Character.toString(taj.charAt(7)));
        int no9 = Integer.parseInt(Character.toString(taj.charAt(8)));

        int cdv = (3 * (no1 + no3 + no5 + no7) + 7 * (no2 + no4 + no6 + no8)) % 10;

        if (cdv != no9) {
            return IdentityNumberError.CDV_ERROR;
        }

        return IdentityNumberError.OK;
    }

    /**
     * Adóazonosító jel ellenőrzése
     * </p>
     * <p>
     * A magánszemélyek adóazonosító jele 10 számjegyből áll: az első mindig a "8"-as szám, a 2.-6. számjegyek az
     * adott személy születési dátuma és 1867. január 1. között eltelt napok száma, a 7.-9. számjegyek az
     * azonos napon születettek megkülönböztetésére használt (pl. véletlenszerűen generált) számsorozat,
     * a tizedik számjegy pedig egy ellenőrző-összeg.
     * </p>
     * <p/>
     * <p>Visszatérési értékek</p>
     * <ul>
     * <li>EMPTY - ha üres</li>
     * <li>LENGTH_ERROR - ha nem 10 hosszú</li>
     * <li>FORMAT_ERROR - ha nem szám vagy nem 8-assal kezdődik</li>
     * <li>OTHER_ERROR - ha az ellenőrző szám 10-re jön ki (nem kiadható adóazonosító jel)</li>
     * <li>CDV_ERROR - ha az ellenőrző szám nem egyezik az utolsó számjeggyel</li>
     * </ul>
     *
     * @param personalTaxNumber adóazonosító jel
     * @return hibakód
     */
    public static IdentityNumberError checkPersonalTaxNumber(final String personalTaxNumber) {


        if (personalTaxNumber == null || personalTaxNumber.isEmpty()) {
            return IdentityNumberError.EMPTY;
        }

        if (personalTaxNumber.length() != 10) {
            return IdentityNumberError.LENGTH_ERROR;
        }

        try {
            String s = "0000000000" + Long.parseLong(personalTaxNumber);
            if (!s.endsWith(personalTaxNumber)) {
                return IdentityNumberError.FORMAT_ERROR;
            }
        } catch (NumberFormatException e) {
            return IdentityNumberError.FORMAT_ERROR;
        }

        if (!"8".equals(personalTaxNumber.substring(0, 1))) {
            return IdentityNumberError.FORMAT_ERROR;
        }

        int check = 0;
        for (int i = 1; i <= 9; i++) {
            check += Integer.parseInt(personalTaxNumber.substring(i - 1, i)) * i;
        }

        check = check % 11;

        if (check == 10) {
            return IdentityNumberError.OTHER_ERROR;
        }

        if (Integer.parseInt(personalTaxNumber.substring(10 - 1, 10)) != check) {
            return IdentityNumberError.CDV_ERROR;
        }

        return IdentityNumberError.OK;
    }


}
