package edu.htc.piglatin;

/**
 * Created by Joel on 4/10/2016.
 */
public class PigLatException extends Exception {
    public PigLatException() {
        System.out.println("There seems to have been an error in translation");
    }

    public PigLatException(String erMsg) {
        super(erMsg);
        System.out.println(erMsg);
    }


}
