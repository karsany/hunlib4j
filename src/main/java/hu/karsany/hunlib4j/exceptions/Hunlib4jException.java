package hu.karsany.hunlib4j.exceptions;

/**
 * Created by fkarsany on 2015. 09. 10..
 */
public class Hunlib4jException extends RuntimeException {
    public Hunlib4jException(String msg, Throwable e) {
        super(msg, e);
    }
}
