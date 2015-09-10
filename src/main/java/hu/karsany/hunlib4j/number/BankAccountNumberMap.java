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

import hu.karsany.hunlib4j.exceptions.Hunlib4jException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

class BankAccountNumberMap implements Map<String, String> {

    private static final String ERR_CANNOT_MODIFY = "Bankszámla prefixeket futás közben módosítani nem lehet.";

    private static BankAccountNumberMap instance;

    private Map<String, String> bankAccounts;

    private BankAccountNumberMap() {
        this.bankAccounts = new HashMap<String, String>();

        InputStream resourceAsStream = this.getClass().getResourceAsStream("/name/BANKKODOK.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, Charset.forName("UTF-8"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] bankData = line.split("\t");
                this.bankAccounts.put(bankData[0], bankData[1]);
            }
        } catch (IOException e) {
            throw new Hunlib4jException("Cannot open resource BANKKODOK.txt", e);
        }

    }

    public static BankAccountNumberMap getInstance() {
        if (instance == null) {
            instance = new BankAccountNumberMap();
        }
        return instance;
    }

    @Override
    public int size() {
        return bankAccounts.size();
    }

    @Override
    public boolean isEmpty() {
        return bankAccounts.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return bankAccounts.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return bankAccounts.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return bankAccounts.get(key);
    }

    @Override
    public String put(String key, String value) {
        throw new UnsupportedOperationException(ERR_CANNOT_MODIFY);
    }

    @Override
    public String remove(Object key) {
        throw new UnsupportedOperationException(ERR_CANNOT_MODIFY);
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        throw new UnsupportedOperationException(ERR_CANNOT_MODIFY);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(ERR_CANNOT_MODIFY);
    }

    @Override
    public Set<String> keySet() {
        return new HashSet<String>(bankAccounts.keySet());
    }

    @Override
    public Collection<String> values() {
        return new HashSet<String>(bankAccounts.values());
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        return new HashSet<Entry<String, String>>(bankAccounts.entrySet());
    }
}
