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

/**
 * PersonName - személynév osztály
 * <p/>
 * tartalmazza a vezetéknevet, két keresztnevet, és két titulust.
 *
 * @author Ferenc Karsány
 * @since 1.0
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
