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

package hu.karsany.hunlib4j.text;

/**
 * Számok (összegek) átalakítása a magyer helyesírás szabályok szerinti szöveggé
 * <p/>
 * Alkalmas például számlák, csekkek végösszegénél feltüntetni az összeget betűvel.
 * <p/>
 * Pl. azaz huszonhárom forint.
 *
 * @author Karsány Ferenc
 * @since 1.0
 */
public final class NumberToString {

    private NumberToString() {
    }

    /**
     * Egy számot kiír betűvel, a magyar helyesírási szabályoknak megfelelően
     *
     * @param n szám
     * @return betűvel
     */
    public static String toString(int n) {

        if (n == 0) {
            return "nulla";
        }

        String[] egyesek = {"#", "egy", "kettő", "három", "négy", "öt", "hat", "hét", "nyolc", "kilenc", "tíz"};
        String[] tizesek = {"#", "tizen", "huszon", "harminc", "negyven", "ötven", "hatvan", "hetven", "nyolcvan", "kilencven"};
        String[] szazasok = {"#", "egy", "két", "három", "négy", "öt", "hat", "hét", "nyolc", "kilenc"};

        int aktualisHatralevo = n;
        int helyiertek = 1;

        String ret = "";
        String bele = n < 2000 ? "" : "-";

        while (aktualisHatralevo != 0) {
            int utolsoSzamjegy = aktualisHatralevo % 10;
            aktualisHatralevo = (aktualisHatralevo - utolsoSzamjegy) / 10;

            if (helyiertek == 1) {
                ret = egyesek[utolsoSzamjegy] + ret;
            } else if ((helyiertek - 1) % 3 == 0) {
                String s = "";
                s = helyiertek == 4 ? "ezer" : helyiertek == 7 ? "millió" : helyiertek == 10 ? "milliárd" : "";
                ret = szazasok[utolsoSzamjegy] + s + bele + ret;
            } else if ((helyiertek - 2) % 3 == 0) {
                ret = tizesek[utolsoSzamjegy] + ret;
            } else if (helyiertek % 3 == 0) {
                if (utolsoSzamjegy != 0) {
                    ret = szazasok[utolsoSzamjegy] + "száz" + ret;
                }
            }

            helyiertek = helyiertek + 1;
        }

        ret = ret.replace("tizen#", "tíz");
        ret = ret.replace("huszon#", "húsz");
        ret = ret.replace("-##millió", "-");
        ret = ret.replace("-##ezer", "-");
        ret = ret.replace("#", "");
        ret = ret.replaceAll("--*", "-");
        ret = ret.replaceAll("^millió", "egymillió");
        ret = ret.replaceAll("^milliárd", "egymilliárd");
        ret = ret.replaceAll("egyszáz", "száz");
        ret = ret.replaceAll("egyezer", "ezer");

        ret = ret.trim().replaceAll("-*$", "");

        return ret;

    }

}
