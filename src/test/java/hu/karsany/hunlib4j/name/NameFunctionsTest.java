package hu.karsany.hunlib4j.name;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by fkarsany on 2014.01.08..
 */
public class NameFunctionsTest {

    @Test
    public void test1() {
        Assert.assertEquals("A doktor az titulus", true, NameFunctions.isTitle("dr."));
    }
}
