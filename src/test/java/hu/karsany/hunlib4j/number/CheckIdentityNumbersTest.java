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

import org.junit.Assert;
import org.junit.Test;

public class CheckIdentityNumbersTest {
    @Test
    public void testCheckTAJ() throws Exception {
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.EMPTY, CheckIdentityNumbers.checkTAJ(null));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.EMPTY, CheckIdentityNumbers.checkTAJ(""));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.LENGTH_ERROR, CheckIdentityNumbers.checkTAJ("123 456 789"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.FORMAT_ERROR, CheckIdentityNumbers.checkTAJ("I23456789"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.FORMAT_ERROR, CheckIdentityNumbers.checkTAJ("12345678A"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.CDV_ERROR, CheckIdentityNumbers.checkTAJ("000456780"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.CDV_ERROR, CheckIdentityNumbers.checkTAJ("037687211"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.OK, CheckIdentityNumbers.checkTAJ("037687210"));
    }

    @Test
    public void testCheckPersonalTaxNumber() throws Exception {
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.EMPTY, CheckIdentityNumbers.checkPersonalTaxNumber(null));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.EMPTY, CheckIdentityNumbers.checkPersonalTaxNumber(""));
        Assert.assertNotEquals(CheckIdentityNumbers.IdentityNumberError.EMPTY, CheckIdentityNumbers.checkPersonalTaxNumber("AAA"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.LENGTH_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("AAA"));
        Assert.assertNotEquals(CheckIdentityNumbers.IdentityNumberError.LENGTH_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("AAAAAAAAAA"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.FORMAT_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("AAAAAAAAAA"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.FORMAT_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("0123456789"));
        Assert.assertNotEquals(CheckIdentityNumbers.IdentityNumberError.FORMAT_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("8888888887"));
        Assert.assertNotEquals(CheckIdentityNumbers.IdentityNumberError.FORMAT_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("8888888888"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.CDV_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("8365670002"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.OK, CheckIdentityNumbers.checkPersonalTaxNumber("8365670003"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.OTHER_ERROR, CheckIdentityNumbers.checkPersonalTaxNumber("8356432120"));

    }
}
