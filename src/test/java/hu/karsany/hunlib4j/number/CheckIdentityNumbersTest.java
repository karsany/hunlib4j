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
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.CDV_ERROR, CheckIdentityNumbers.checkTAJ("037687211"));
        Assert.assertEquals(CheckIdentityNumbers.IdentityNumberError.OK, CheckIdentityNumbers.checkTAJ("037687210"));

    }
}
