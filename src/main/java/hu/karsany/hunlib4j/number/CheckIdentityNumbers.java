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

    public enum IdentityNumberError {
        OK, EMPTY, LENGTH_ERROR, FORMAT_ERROR, CDV_ERROR
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
    public static IdentityNumberError checkTAJ(String taj) {

        if (taj == null || taj.isEmpty()) {
            return IdentityNumberError.EMPTY;
        }

        if (taj.length() != 9) {
            return IdentityNumberError.LENGTH_ERROR;
        }

        try {
            String tesztTaj = "000000000" + String.valueOf(Integer.parseInt(taj));
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

}
