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


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fkarsany on 2014.01.20..
 */
public class NumberToStringTest {

    @Test
    public void t1() {
        Assert.assertEquals("kétmilliárd-tizenegymillió-harmincezer", NumberToString.toString(2011030000));
        Assert.assertEquals("egymilliárd", NumberToString.toString(1000000000));
        Assert.assertEquals("százezer", NumberToString.toString(100000));
        Assert.assertEquals("százmillió", NumberToString.toString(100000000));
        Assert.assertEquals("tízmillió", NumberToString.toString(10000000));
        Assert.assertEquals("egymillió", NumberToString.toString(1000000));
        Assert.assertEquals("kétmillió", NumberToString.toString(2000000));
        Assert.assertEquals("egy", NumberToString.toString(1));
        Assert.assertEquals("kettő", NumberToString.toString(2));
        Assert.assertEquals("három", NumberToString.toString(3));
        Assert.assertEquals("négy", NumberToString.toString(4));
        Assert.assertEquals("öt", NumberToString.toString(5));
        Assert.assertEquals("hat", NumberToString.toString(6));
        Assert.assertEquals("hét", NumberToString.toString(7));
        Assert.assertEquals("nyolc", NumberToString.toString(8));
        Assert.assertEquals("kilenc", NumberToString.toString(9));
        Assert.assertEquals("tíz", NumberToString.toString(10));
        Assert.assertEquals("húsz", NumberToString.toString(20));
        Assert.assertEquals("tizenhárom", NumberToString.toString(13));
        Assert.assertEquals("huszonhét", NumberToString.toString(27));
        Assert.assertEquals("száz", NumberToString.toString(100));
        Assert.assertEquals("százhárom", NumberToString.toString(103));
        Assert.assertEquals("hétszáztíz", NumberToString.toString(710));
        Assert.assertEquals("kilencszáz", NumberToString.toString(900));
        Assert.assertEquals("száztizenhárom", NumberToString.toString(113));
        Assert.assertEquals("kétszázhuszonhét", NumberToString.toString(227));
        Assert.assertEquals("ezertizennégy", NumberToString.toString(1014));
        Assert.assertEquals("ezerkilencszázkilencvenhét", NumberToString.toString(1997));
        Assert.assertEquals("kétezer-három", NumberToString.toString(2003));
        Assert.assertEquals("tizenötezer-százkettő", NumberToString.toString(15102));
        Assert.assertEquals("ötezer-négyszázegy", NumberToString.toString(5401));
        Assert.assertEquals("hatszázhuszonötezer-négyszázegy", NumberToString.toString(625401));
        Assert.assertEquals("négymillió", NumberToString.toString(4000000));
        Assert.assertEquals("hárommillió-hatszázhuszonötezer-négyszázegy", NumberToString.toString(3625401));
        Assert.assertEquals("ötvenhárommillió-hatszázhuszonötezer-négyszázegy", NumberToString.toString(53625401));
        Assert.assertEquals("háromszázötvenhárommillió-hatszázhuszonötezer-négyszázegy", NumberToString.toString(353625401));
        Assert.assertEquals("ötvenhárommillió-egy", NumberToString.toString(53000001));
        Assert.assertEquals("nulla", NumberToString.toString(0));
        Assert.assertEquals("egymilliárd-kilencszázkilencvenkilencmillió-kilencszázkilencvenkilencezer-kilencszázkilencvenkilenc", NumberToString.toString(1999999999));
    }

}
