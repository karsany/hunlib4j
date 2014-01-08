package hu.karsany.hunlib4j.name;

/**
 * PersonName - személynév osztály
 *
 * tartalmazza a vezetéknevet, két keresztnevet, és két titulust.
 *
 */
public class PersonName {

    private String lastName;
    private String firstName1;
    private String firstName2;
    private String beforeTitle;
    private String afterTitle;

    public PersonName() {
    }

    public PersonName(String lastName, String firstName1, String firstName2, String beforeTitle, String afterTitle) {

        this.lastName = lastName;
        this.firstName1 = firstName1;
        this.firstName2 = firstName2;
        this.beforeTitle = beforeTitle;
        this.afterTitle = afterTitle;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getBeforeTitle() {
        return beforeTitle;
    }

    public void setBeforeTitle(String beforeTitle) {
        this.beforeTitle = beforeTitle;
    }

    public String getAfterTitle() {
        return afterTitle;
    }

    public void setAfterTitle(String afterTitle) {
        this.afterTitle = afterTitle;
    }
}
