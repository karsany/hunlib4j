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

import java.security.InvalidParameterException;

/**
 * Bankszámlaszámok kezelésésre szolgáló csomag.
 *
 * @author Ferenc Karsány
 * @since 1.0
 */
public final class BankAccountNumber {

    private BankAccountNumber() {
    }


    public static String getBankFiok(String bankAccountNo) {

        if (bankAccountNo == null || bankAccountNo.length() < 8) {
            throw new InvalidParameterException("Bejövő paraméter üres vagy 8 karakternél rövidebb: " + bankAccountNo);
        }

        return BankAccountNumberMap.getInstance().get(bankAccountNo.substring(0, 8));
    }


}
