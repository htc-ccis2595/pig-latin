package edu.htc.piglatin;

import java.util.Scanner;

/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {



    public static String translateToPigLatin(String sentence) {


        String result = "";
        Scanner scan = new Scanner(sentence);
        sentence = sentence.toLowerCase();
        while (scan.hasNext())
        {
            result += wordToPigLatin(scan.next());

        }
        return result;




    }

    public static String translateFromPigLatin(String sentence) {

    }

    public static String wordToPigLatin(String word) {


    }

    public static String wordFromPigLatin(String word) {
        String result = "";

    }


}
