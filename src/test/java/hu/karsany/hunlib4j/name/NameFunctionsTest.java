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
