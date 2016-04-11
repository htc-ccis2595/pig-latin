package edu.htc.piglatin;

/**
 * Created by joe on 4/10/2016.
 */
public class TranslationException {

    public static boolean canTranslateWord(String word){
        Boolean Answer = false;

        if(PigLatinTranslator.FindApostrophePosition(word) != -1){

            Answer = true;
        }


        return Answer;
    }



}
