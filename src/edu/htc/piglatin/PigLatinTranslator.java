package edu.htc.piglatin;

import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    //
    public static String translateToPigLatin(String sentence) throws TranslationException {
        if (sentence.trim().equals("")) {
            return sentence;
        }
        String result = "";
        Scanner scan = new Scanner(sentence);
        sentence = sentence.toLowerCase();
        while (scan.hasNext()) {
            try {
                result += wordToPigLatin(scan.next());
            } catch (TranslationException e) {
                e.printStackTrace();
            }
            result += " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;

    }

    public static String translateFromPigLatin(String sentence) {
        if (sentence.trim().equals("")) {
            return sentence;
        }

        String result = "";
        Scanner scan = new Scanner(sentence);
        sentence = sentence.toLowerCase();
        while (scan.hasNext()) {
            try {
                result += wordFromPigLatin(scan.next());
            } catch (TranslationException e) {
                e.printStackTrace();
            }
            result += " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;


    }


    public static String wordToPigLatin(String word) throws TranslationException {
        if (word.trim().equals("")) {
            return word;
        }
        String strWordToPigLatin = "";

        //Separating the word if there is any punctuation in the word
        String strWord = word.replaceAll("[^a-zA-Z]", "");
        String punctuation = word.replaceAll("[a-zA-Z]", "");


        char startLetter = strWord.charAt(0);
        String s = new Character(startLetter).toString();


        if (firstVowel(s) == true) {
            if (Character.isUpperCase(startLetter) == true) {
                strWordToPigLatin = strWord.substring(0, 1).toUpperCase() + word.substring(1) + ("'ay") + punctuation;
            } else {
                strWordToPigLatin = strWord + ("'ay" + punctuation);
            }
        } else {
            String startConsonant = "";
            startConsonant = String.valueOf(startLetter);

            if (Character.isUpperCase(strWord.charAt(0)))
            {
                strWordToPigLatin = strWord.substring(1, 2).toUpperCase() + strWord.substring(2) + "'" + startConsonant.toLowerCase() + ("ay" + punctuation);
            }
            else {
                strWordToPigLatin = strWord.substring(1) + "'" + startConsonant + ("ay" + punctuation);
            }
        }

        return strWordToPigLatin;
    }


    public static boolean firstVowel(String word) {

        String vowel = "aeiouyAEIOUY";

        char firstLetter = word.charAt(0);
        if (vowel.indexOf(firstLetter) >= 0) {
            return true;
        } else {
            return false;
        }
    }


    public static String wordFromPigLatin(String word) throws TranslationException {

        if (word.trim().equals("")) {
            return word;
        }


        String[] parts = word.split("'");

        //Splitting the word into two words removing ' in between them.

        String partFirst = parts[0];
        String partSecond = parts[1];
        int mark = partSecond.indexOf("ay");
        String firstLetters = partSecond.substring(0, mark);
        String punctuation = partSecond.substring(mark + 2);

        //It will check it the first letter is captial
        String strWordFromPigLatin = "";
        if (firstVowel(partFirst) == true && partSecond.equals("ay")) {
            if (Character.isUpperCase(partFirst.charAt(0)) == true) {
                strWordFromPigLatin = partFirst.substring(0, 1).toUpperCase() + partFirst.substring(1) + punctuation;
            } else {
                strWordFromPigLatin = partFirst.substring(0, 1).toLowerCase() + partFirst.substring(1) + punctuation;
            }
        } else {
            if (Character.isUpperCase(partFirst.charAt(0)) == true) {
                strWordFromPigLatin = partSecond.substring(0, 1).toUpperCase() + partFirst.substring(0, 1).toLowerCase() + partFirst.substring(1) + punctuation;
            } else {
                strWordFromPigLatin = partSecond.substring(0, 1) + partFirst + punctuation;
            }
        }

        return strWordFromPigLatin;
    }

    public static void main(String[] args)throws TranslationException {

        System.out.println("Translating from English to Pig Latin...");
        System.out.println("Word \"lamb\" in pig latin is: " + wordToPigLatin("lamb"));
        System.out.println("Word \"Lamb\" in pig latin is: " + wordToPigLatin("Lamb"));
        System.out.println("Word \"eggs\" in pig latin is: " + wordToPigLatin("eggs"));
        System.out.println("Word \"Eggs\" in pig latin is: " + wordToPigLatin("Eggs"));
        System.out.println("Word with punctuation \"lamb?!\" in pig latin is: " + wordToPigLatin("lamb?!"));
        System.out.println("Word with punctuation \"Lamb?!\" in pig latin is: " + wordToPigLatin("Lamb?!"));

        System.out.println();
        System.out.println("Translating from Pig Latin to English...");
        System.out.println("Word \"amb'lay\" in English is: " + wordFromPigLatin("amb'lay"));
        System.out.println("Word \"Amb'lay\" in English is: " + wordFromPigLatin("Amb'lay"));
        System.out.println("Word \"eggs'ay\" in English is: " + wordFromPigLatin("eggs'ay"));
        System.out.println("Word \"Eggs'ay\" in English is: " + wordFromPigLatin("Eggs'ay"));
        System.out.println("Word with punctuation\"amb'lay?!\" in pig latin is: " + wordFromPigLatin("amb'lay?!"));
        System.out.println();
        System.out.println("Translating sentence from English to Pig Latin...");
        System.out.println("Sentence \"Mary had a little lamb?!\" in pig latin: " + translateToPigLatin("Mary had a little lamb?!"));

        System.out.println();
        System.out.println("Translating sentence from Pig Latin to English...");
        System.out.println("Sentence \"Ary'may ad'hay a'ay ittle'lay amb'lay?!\" in English: " + translateFromPigLatin("Ary'may ad'hay a'ay ittle'lay amb'lay?!"));


    }
}
