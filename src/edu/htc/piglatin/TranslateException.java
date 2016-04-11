package edu.htc.piglatin;

/**
 * Created by Administrator on 4/4/16.
 */
public class TranslateException extends Exception {
    public TranslateException() {
        System.out.println("TRANSLATION EXCEPTION OCCURRED");
    }

    public TranslateException(String message) {
        super(message);
        System.out.println(message);
        // TODO Auto-generated constructor stub
    }

    public TranslateException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public TranslateException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
}
