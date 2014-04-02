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
}
