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

import hu.karsany.hunlib4j.exceptions.Hunlib4jException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class TitulusSet implements Set<String> {

    private static final String ERR_CANNOT_ADD = "Titulusokhoz futás közben hozzáadni nem lehet.";
    private static final String ERR_CANNOT_DELETE = "Titulusok közül futás közben törölni nem lehet.";

    private static TitulusSet titulusSet;
    private Set<String> titulusok;

    private TitulusSet() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/name/TITULUS.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, Charset.forName("UTF-8"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        titulusok = new HashSet<String>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            titulusok.add(line.toUpperCase().trim());
        }
    }

    public static TitulusSet getInstance() {
        if (titulusSet == null) {
            try {
                titulusSet = new TitulusSet();
            } catch (IOException e) {
                throw new Hunlib4jException("Cannot open resource TITULUS.txt", e);
            }
        }

        return titulusSet;
    }

    @Override
    public int size() {
        return titulusok.size();
    }

    @Override
    public boolean isEmpty() {
        return titulusok.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return titulusok.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return titulusok.iterator();
    }

    @Override
    public Object[] toArray() {
        return titulusok.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return titulusok.toArray(a);
    }

    @Override
    public boolean add(String s) {
        throw new UnsupportedOperationException(ERR_CANNOT_ADD);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException(ERR_CANNOT_DELETE);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return titulusok.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException(ERR_CANNOT_ADD);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException(ERR_CANNOT_DELETE);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException(ERR_CANNOT_DELETE);
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException(ERR_CANNOT_DELETE);
    }
}
