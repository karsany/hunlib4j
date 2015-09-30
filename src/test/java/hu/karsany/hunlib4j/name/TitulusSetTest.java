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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TitulusSetTest {

    private TitulusSet titulusSet;

    @Before
    public void setUp() throws Exception {
        titulusSet = TitulusSet.getInstance();
    }

    @Test
    public void testSize() throws Exception {

        Assert.assertNotNull(titulusSet.size());
        Assert.assertNotEquals(0, titulusSet.size());

    }

    @Test
    public void testIsEmpty() throws Exception {

        Assert.assertEquals(false, titulusSet.isEmpty());

    }

    @Test
    public void testContains() throws Exception {

        Assert.assertEquals(true, titulusSet.contains("DR."));

    }

    @Test
    public void testSingleton() {
        TitulusSet t2 = TitulusSet.getInstance();
        Assert.assertEquals(t2, titulusSet);
    }
}
