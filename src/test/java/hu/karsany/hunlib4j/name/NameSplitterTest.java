package hu.karsany.hunlib4j.name;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by fkarsany on 2014.01.07..
 */
public class NameSplitterTest {


    @Test
    public void test1() {
        PersonName t = NameSplitter.splitName(null);
        Assert.assertEquals("Null esetén nem száll el, null az eredmény", null, t.getAfterTitle());
        Assert.assertEquals("Null esetén nem száll el, null az eredmény", null, t.getBeforeTitle());
        Assert.assertEquals("Null esetén nem száll el, null az eredmény", null, t.getFirstName1());
        Assert.assertEquals("Null esetén nem száll el, null az eredmény", null, t.getFirstName2());
        Assert.assertEquals("Null esetén nem száll el, null az eredmény", null, t.getLastName());
    }

    @Test
    public void test2() {
        PersonName t = NameSplitter.splitName("Karsány Ferenc");
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", "Karsány", t.getLastName());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", "Ferenc", t.getFirstName1());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", null, t.getFirstName2());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", null, t.getAfterTitle());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", null, t.getBeforeTitle());
    }

    @Test
    public void test3() {
        PersonName t = NameSplitter.splitName("Karsány Ferencné");
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", "Karsány", t.getLastName());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", "Ferencné", t.getFirstName1());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", null, t.getFirstName2());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", null, t.getAfterTitle());
        Assert.assertEquals("Sima kéttagú név esetén vezetéknév, keresztnév kitöltött, a többi üres", null, t.getBeforeTitle());
    }

    @Test
    public void test4() {
        PersonName t = NameSplitter.splitName("Karsány Ferenc József");
        Assert.assertEquals("Névfelbontás helyes", "Karsány", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ferenc", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "József", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test5() {
        PersonName t = NameSplitter.splitName("Tamás Gáspár Miklós");
        Assert.assertEquals("Névfelbontás helyes", "Tamás", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Gáspár", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "Miklós", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test6() {
        PersonName t = NameSplitter.splitName("Nagyné Kovács Ildikó");
        Assert.assertEquals("Névfelbontás helyes", "Nagyné Kovács", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ildikó", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", null, t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test7() {
        PersonName t = NameSplitter.splitName("Kovács Sándor Józsefné");
        Assert.assertEquals("Névfelbontás helyes", "Kovács", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Sándor", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "Józsefné", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test8() {
        PersonName t = NameSplitter.splitName("Kovácsné Horváth Beáta Sára");
        Assert.assertEquals("Névfelbontás helyes", "Kovácsné Horváth", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Beáta", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "Sára", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test9() {
        PersonName t = NameSplitter.splitName("Kovács Sándorné Nagy Ilona");
        Assert.assertEquals("Névfelbontás helyes", "Kovács Sándorné Nagy", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ilona", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", null, t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test10() {
        PersonName t = NameSplitter.splitName("Kovács Sándorné Nagy Ilona Klára");
        Assert.assertEquals("Névfelbontás helyes", "Kovács Sándorné Nagy", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ilona", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "Klára", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test11() {
        PersonName t = NameSplitter.splitName("Kovács József Sándorné Nagy Ilona");
        Assert.assertEquals("Névfelbontás helyes", "Kovács József Sándorné Nagy", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ilona", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", null, t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test12() {
        PersonName t = NameSplitter.splitName("Kovács József Sándorné Nagy Ilona Klára");
        Assert.assertEquals("Névfelbontás helyes", "Kovács József Sándorné Nagy", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ilona", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "Klára", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test13() {
        PersonName t = NameSplitter.splitName("Kiss Ariadné Eleonóra");
        Assert.assertEquals("Névfelbontás helyes", "Kiss", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ariadné", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "Eleonóra", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test14() {
        PersonName t = NameSplitter.splitName("Kissné Horváth Ariadné Eleonóra");
        Assert.assertEquals("Névfelbontás helyes", "Kissné Horváth", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Ariadné", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "Eleonóra", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test15() {
        PersonName t = NameSplitter.splitName("Kissné Röné Eleonóra");
        Assert.assertEquals("Névfelbontás helyes", "Kissné Röné", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Eleonóra", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", null, t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test16() {
        PersonName t = NameSplitter.splitName("Kiss Józsefné Röné Eleonóra");
        Assert.assertEquals("Névfelbontás helyes", "Kiss Józsefné Röné", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Eleonóra", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", null, t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test17() {
        PersonName t = NameSplitter.splitName("Gané Józsefné Röné Eleonóra");
        Assert.assertEquals("Névfelbontás helyes", "Gané Józsefné Röné", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "Eleonóra", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", null, t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test18() {
        PersonName t = NameSplitter.splitName("KOVÁCS - HORVÁTH GIZELLA SÁRA");
        Assert.assertEquals("Névfelbontás helyes", "KOVÁCS-HORVÁTH", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "GIZELLA", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "SÁRA", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", null, t.getBeforeTitle());
    }

    @Test
    public void test19() {
        PersonName t = NameSplitter.splitName("B.KOVÁCS ESZTER");
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "B. KOVÁCS", t.getLastName());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "ESZTER", t.getFirstName1());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getFirstName2());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getAfterTitle());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getBeforeTitle());
    }

    @Test
    public void test20() {
        PersonName t = NameSplitter.splitName("KOVÁCS B. ESZTER");
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "KOVÁCS B.", t.getLastName());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "ESZTER", t.getFirstName1());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getFirstName2());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getAfterTitle());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getBeforeTitle());
    }

    @Test
    public void test21() {
        PersonName t = NameSplitter.splitName("B .KOVÁCS ESZTER TAMARA");
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "B. KOVÁCS", t.getLastName());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "ESZTER", t.getFirstName1());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "TAMARA", t.getFirstName2());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getAfterTitle());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getBeforeTitle());
    }

    @Test
    public void test22() {
        PersonName t = NameSplitter.splitName("KOVÁCS B . ESZTER TAMARA");
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "KOVÁCS B.", t.getLastName());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "ESZTER", t.getFirstName1());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", "TAMARA", t.getFirstName2());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getAfterTitle());
        Assert.assertEquals("Egybetűs pontozott vezetéknév esetén is jól működjön", null, t.getBeforeTitle());
    }

    @Test
    public void test23() {
        PersonName t = NameSplitter.splitName("Dr. Nagyné Dr. Kovács Ildikó");
        Assert.assertEquals("Titulusok kezelése jól működjön", "Nagyné Kovács", t.getLastName());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Ildikó", t.getFirstName1());
        Assert.assertEquals("Titulusok kezelése jól működjön", null, t.getFirstName2());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Dr.", t.getAfterTitle());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Dr.", t.getBeforeTitle());
    }

    @Test
    public void test24() {
        PersonName t = NameSplitter.splitName("Kovács József Sándorné Dr. Nagy Ilona Klára");
        Assert.assertEquals("Titulusok kezelése jól működjön", "Kovács József Sándorné Nagy", t.getLastName());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Ilona", t.getFirstName1());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Klára", t.getFirstName2());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Dr.", t.getBeforeTitle());
        Assert.assertEquals("Titulusok kezelése jól működjön", null, t.getAfterTitle());
    }

    @Test
    public void test25() {
        PersonName t = NameSplitter.splitName("Dr.Karsány Ferenc");
        Assert.assertEquals("Titulusok kezelése jól működjön", "Karsány", t.getLastName());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Ferenc", t.getFirstName1());
        Assert.assertEquals("Titulusok kezelése jól működjön", null, t.getFirstName2());
        Assert.assertEquals("Titulusok kezelése jól működjön", "Dr.", t.getBeforeTitle());
        Assert.assertEquals("Titulusok kezelése jól működjön", null, t.getAfterTitle());
    }

    @Test
    public void test26() {
        PersonName t = NameSplitter.splitName("DR. KOVÁCS - HORVÁTH GIZELLA SÁRA");
        Assert.assertEquals("Névfelbontás helyes", "KOVÁCS-HORVÁTH", t.getLastName());
        Assert.assertEquals("Névfelbontás helyes", "GIZELLA", t.getFirstName1());
        Assert.assertEquals("Névfelbontás helyes", "SÁRA", t.getFirstName2());
        Assert.assertEquals("Névfelbontás helyes", null, t.getAfterTitle());
        Assert.assertEquals("Névfelbontás helyes", "DR.", t.getBeforeTitle());
    }

}
