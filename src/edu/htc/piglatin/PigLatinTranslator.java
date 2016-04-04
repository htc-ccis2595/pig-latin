package edu.htc.piglatin;

import org.junit.runners.model.InitializationError;
import org.omg.CORBA.INITIALIZE;

import java.util.ArrayList;


/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    public static String translateToPigLatin(String sentence) {
        //Take a sentence, translate each word using wordToPigLatin.
        //Read until a space to get the word.
        //?? What to use to store the sentence/strings as it progresses.


    }

    public static String translateFromPigLatin(String sentence) {
        //Same format as translateToPigLatin but use wordFromPigLatin

    }

    protected static String wordToPigLatin(String word) {
        //if word starts with a vowel, add 'ay to the end.
        //Otherwise read until vowel, move vowel to end of word to beginning of word. Add 'ay to end of original word. End of word should be initial consonants.
        //make sure other punctuation isn't a problem - period stays at the end of the word for example
        ArrayList<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        char firstLetter = word.charAt(0);
        int firstVowel = 0;
        String wordAsPigLatin = "";

        if (vowels.contains(firstLetter)){
            wordAsPigLatin = word + "'ay";
        } else {
            for ( int i = 1; i < word.length(); i++){
                if (vowels.contains(word.charAt(i))){
                    firstVowel = i;
                    break;
                } else {
                    firstVowel = word.length();
                }
            }
            for (int i = firstVowel; i < word.length(); i++){
                wordAsPigLatin = wordAsPigLatin + word.charAt(i);
            }

            wordAsPigLatin = wordAsPigLatin + "'ay";

            for (int i = 0; i < firstVowel; i++){
                wordAsPigLatin = wordAsPigLatin + word.charAt(i);
            }
        }

        return wordAsPigLatin;
    }

    protected static String wordFromPigLatin(String word) {
        //Find 'ay and remove it. Move all letters in front of 'ay to the back of the word
        //make sure punctuation remains in the correct spot
        String wordAsEnglish = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '\'' && word.charAt(i + 1) == 'a' && word.charAt(i + 2) == 'y') {
                for (int x = i + 3; x < word.length(); x++) {
                    wordAsEnglish = wordAsEnglish + word.charAt(x);
                }
                for (int x = 0; x < i; x++) {
                    wordAsEnglish = wordAsEnglish + word.charAt(x);
                }
            }

        }

        return wordAsEnglish;
    }


}
