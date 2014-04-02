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
import org.junit.Test;

/**
 * Created by fkarsany on 2014.01.08..
 */
public class NameFunctionsTest {

    @Test
    public void test1() {
        Assert.assertEquals("A doktor az titulus", true, NameFunctions.isTitle("dr."));
        Assert.assertEquals("A doktor az titulus", true, NameFunctions.isTitle("Dr."));
        Assert.assertEquals("Az ifjabb az titulus", true, NameFunctions.isTitle("ifj."));
        Assert.assertEquals("Az özvegy az titulus", true, NameFunctions.isTitle("özv."));
        Assert.assertEquals("Üres string nem titulus", false, NameFunctions.isTitle(""));
        Assert.assertEquals("Null string nem titulus", false, NameFunctions.isTitle(null));
        Assert.assertEquals("Egyéb string nem titulus", false, NameFunctions.isTitle("lo"));
    }
}
