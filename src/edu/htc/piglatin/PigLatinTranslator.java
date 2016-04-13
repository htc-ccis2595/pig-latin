package edu.htc.piglatin;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {



    public static String translateToPigLatin(String sentence) {
        String[] englishWords = sentence.split(" ");
            for(String englishWord : englishWords){
                wordToPigLatin(englishWord);

            }
        return sentence;
    }


    public static String translateFromPigLatin(String sentence) {
        String[] latinWords = sentence.split(" ");
            for(String latinWord : latinWords){
                wordFromPigLatin(latinWord);
            }
        return sentence;

    }

    public static String wordToPigLatin(String word) {
        if (isVowel(word.substring(0, 1))) {
            word = word + "'ay";

        } else {
            int firstVowelPos = 0;
            for (int i = 0; i < word.length(); i++) {
                String letter = word.substring(i, i + 1);

                if (isVowel(letter)) {
                    firstVowelPos = i;
                    break;
                }
            }

            if(firstVowelPos != word.length()){

                word = word.substring(firstVowelPos, word.length()) + "\'" + word.substring(0, firstVowelPos) + "ay";
                word = word.toLowerCase();
                word = word.substring(0,1).toUpperCase() + word.substring(1, word.length());
            }
        }
     return word;


    }

    //--ORIGINAL CODE
//    public static String wordFromPigLatin(String word) {
//        if(isVowel(word.substring(findApostrophe(word), findApostrophe(word)+1))){
//            word  = word.substring(0, findApostrophe(word));
//            return word;
//        }
//        else {
//            int nextVowel = 0;
//            for (int i = findApostrophe(word); i < word.length(); i++) {
//                String nextLettter = word.substring(i, i + 1);
//                if (isVowel(nextLettter)) {
//                    nextVowel = i;
//                    break;
//                }
//            }
//            if(nextVowel != word.length()){
//                word = word.substring(findApostrophe(word)+1, nextVowel) + word.substring(0, findApostrophe(word));}
//
//            return word;
//        }
//    }

    public static String wordFromPigLatin(String word) {
        if (upperCase(word.substring(0, 1))) {
            if (isVowel(word.substring(findApostrophe(word), findApostrophe(word) + 1))) {
                word = word.substring(0, findApostrophe(word));
                word = word.toLowerCase();
                word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
                return word;
            } else {
                int nextVowel = 0;
                for (int i = findApostrophe(word); i < word.length(); i++) {
                    String nextLettter = word.substring(i, i + 1);
                    if (isVowel(nextLettter)) {
                        nextVowel = i;
                        break;
                    }
                }
                if (nextVowel != word.length()) {
                    word = word.substring(findApostrophe(word) + 1, nextVowel) + word.substring(0, findApostrophe(word));
                    word = word.toLowerCase();
                    word = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
                }

                return word;
            }
        }


        else if(!upperCase(word.substring(0,1))){
            if(isVowel(word.substring(findApostrophe(word), findApostrophe(word)+1))){
            word  = word.substring(0, findApostrophe(word));
            return word;
        }
        else {
            int nextVowel = 0;
            for (int i = findApostrophe(word); i < word.length(); i++) {
                String nextLettter = word.substring(i, i + 1);
                if (isVowel(nextLettter)) {
                    nextVowel = i;
                    break;
                }
            }
            if(nextVowel != word.length()){
                word = word.substring(findApostrophe(word)+1, nextVowel) + word.substring(0, findApostrophe(word));}

            return word;
            }
        } return word;
    }




    public static boolean isVowel(String word) {
        String vowels[] = {"a", "e", "i", "o", "u" , "y", "A", "E", "I", "O", "U", "Y"};
        if (Arrays.asList(vowels).contains(word)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int findApostrophe (String word) {
        String apostrophe = "\'";
        int apostropheIndex = 0;
        for(int i = 0; i < word.length(); i++){
            apostropheIndex = word.indexOf(apostrophe);
        }
        return apostropheIndex;
}
    public static int endPuncuation (String word){
        int endPuncuationIndex = 0;
        for(int i = 0; i < word.length(); i++){
            endPuncuationIndex = word.indexOf(endPuncuation(word));
        }
        return endPuncuationIndex;
    }

    public static boolean puncuation(String word) {
        String puncuations[] = {".", "?", "!"};
        if (Arrays.asList(puncuations).contains(word)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean upperCase(String word){
        String []upperCaseLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        if(Arrays.asList(upperCaseLetters).contains(word)){
            return true;
        }
        else {
            return false;
        }
    }
//    public static int endPuncuation (String word) {
//        String exclamation = "!";
//        int exclamationIndex = 0;
//
//        String period = ".";
//        int periodIndex = 0;
//
//        String question = "?";
//        int questionIndex = 0;
//
//        if(word.contains(period)){
//            for(int i = 0; i < word.length(); i++){
//                periodIndex = word.indexOf(period);
//            }
//        }
//        return periodIndex;
//
//        if(word.contains(exclamation)){
//            for(int i = 0; i < word.length(); i++){
//                exclamationIndex = word.indexOf(exclamation);
//            }
//        }
//        return exclamationIndex;
//
//        if(word.contains(question)){
//            for(int i = 0; i < word.length(); i++){
//                questionIndex = word.indexOf(question);
//            }
//        }
//        return questionIndex;
//    }



}
