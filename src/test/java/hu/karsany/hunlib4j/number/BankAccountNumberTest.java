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

import java.security.InvalidParameterException;

public class BankAccountNumberTest {

    @Test
    public void tesztGetBankFiok() {
        Assert.assertEquals("OTP Pest megyei LAFO fiók", BankAccountNumber.getBankFiok("11773425-87100068"));
        Assert.assertEquals("OTP Pest megyei LAFO fiók", BankAccountNumber.getBankFiok("11773425"));
        Assert.assertEquals("AXA Bank Europe SA Mo-i Fióktelepe", BankAccountNumber.getBankFiok("17000019"));

        try {
            BankAccountNumber.getBankFiok("170000");
            Assert.fail("Nem volt exception");
        } catch (InvalidParameterException e) {
            Assert.assertEquals("Bejövő paraméter üres vagy 8 karakternél rövidebb: 170000", e.getMessage());
        }

        Assert.assertNull(BankAccountNumber.getBankFiok("9283428937"));

    }

}
