package edu.htc.piglatin;

/**
 * Created by clifford.mauer on 4/11/2016.
 */
public class PigLatinExceptions extends Exception {
    public PigLatinExceptions(String message) {
        super(message);
    }
}

class NoSentenceException extends Exception {
    public NoSentenceException(String message) {
        super(message);
    }
}