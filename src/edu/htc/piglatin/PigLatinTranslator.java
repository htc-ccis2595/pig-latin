package edu.htc.piglatin;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    public static String translateToPigLatin(String sentence) {
        String[] words=sentence.split(" ");
        String translate = "";
        for (String word : words){

            translate = translate + " " + wordToPigLatin(word);

        }
        return translate;
    }

    public static String translateFromPigLatin(String sentence) {
        return "";

    }
    protected static boolean isItAVowel(char letter) {
        letter = Character.toLowerCase(letter);
        if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y' ){
            return true;
        }
        else{
            return false;
        }

    }

    protected static String wordToPigLatin(String word) {
        char firstLetter = word.charAt(0);
        String pigLatinWord = new String("");
        if (isItAVowel(firstLetter)== true) {
            pigLatinWord = word + "'ay";


        }
        else {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (isItAVowel(letter) == true) {
                    String wordNew = word.substring(i, word.length());
                    pigLatinWord = wordNew + "'" + word.substring(0, i) + "ay";
                    break;
                }
            }
        }
        return pigLatinWord;
    }

    protected static String wordFromPigLatin(String word) {

    }


}
