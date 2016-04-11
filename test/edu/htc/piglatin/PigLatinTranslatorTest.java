package edu.htc.piglatin;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.IOException;

/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {
    @Test
    public void translateToPigLatin() {
        String strTestWord = "objects,";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;
        String strResult = PigLatinTranslator.wordToPigLatin(strTestWord, blnFirstWord, blnLastWord);
        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void translateSentenceToPigLatin() throws NoSentenceException {
        String strTestSentence = "This course is an introduction to programming in Java.";
        String strResult = PigLatinTranslator.translateToPigLatin(strTestSentence);
        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void translateSentenceFromPigLatin() throws NoSentenceException{
        String strTestSentence = "Object'ay oriented'ay esign'day using'ay e'thay Unified'ay Odeling'may Anguage'lay ill'way also'ay e'bay introduced'ay.";
        String strResult = PigLatinTranslator.translateFromPigLatin(strTestSentence);
        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void translateToPigLatin_emptyAndBlankStrings() throws NoSentenceException {
        String strTestSentence = "";
        String strResult = PigLatinTranslator.translateToPigLatin(strTestSentence);


        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void translateFromPigLatin() {
        String strTestWord = "Is'thay";
        Boolean blnFirstWord = true;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordFromPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void translateFromPigLatin_emptyAndBlankStrings() throws NoSentenceException {
        String strTestSentence = "";
        String strResult = PigLatinTranslator.translateFromPigLatin(strTestSentence);


        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void wordToPigLatin_emptyAndBlankStrings() throws NoSentenceException {
        String strTestSentence = "";
        String strResult = PigLatinTranslator.translateFromPigLatin(strTestSentence);

        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() {
        String strTestWord = "unbelievable";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordToPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }

    }

    @Test
    public void wordToPigLatin_withPunctuation() {
        String strTestWord = "Universal.";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordToPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }

    }

    @Test
    public void wordToPigLatin_startsWithCapitalVowel() {
        String strTestWord = "Universal";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordToPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }
    }

    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() {
        String strTestWord = "collections";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordToPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }

    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {
        String strTestWord = "Company";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordToPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }

    }

    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() throws NoSentenceException{

        String strTestSentence = "";
        String strResult = PigLatinTranslator.translateFromPigLatin(strTestSentence);


        if (strResult != null){
            System.out.println(strResult);
        }

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseVowel() {
        String strTestWord = "ugly'ay";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordFromPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalVowel() {
        String strTestWord = "Ugly'ay";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        String strResult = PigLatinTranslator.wordFromPigLatin(strTestWord, blnFirstWord, blnLastWord);

        if (strResult != null){
            System.out.println(strResult);
        }
    }
    @Test
    public void wordFromPigLatin_startsWithLowercaseConsonant() {
        String inputStr = "liff'cay";
        char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
                'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z' };
        char[] StringArray = inputStr.toCharArray();
        Integer intCharLocation = indexOfIntArray(StringArray,'\'');
        char current = StringArray[intCharLocation+1];
        for (char c: consonants ) {
            if ( c == current){
                //** if this is a match then we have a lower case consonant
                System.out.println(c + " is a match");
                System.out.println(current + " is a lower case consonant");
                break;
            }
            else {
                System.out.println(c + " is not a match");
            }
        }
        }
    @Test
    public void wordFromPigLatin_startsWithCapitalConsonant() {
        String inputStr = "liff'Cay";


        char[] consonants = { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z' };
        char[] StringArray = inputStr.toCharArray();
        Integer intCharLocation = indexOfIntArray(StringArray,'\'');
        char current = StringArray[intCharLocation+1];

        for (char c: consonants ) {
            if ( c == current){
                //** if this is a match then we have a capital consonant
                System.out.println(c + " is a match");
                System.out.println(current + " is a capital consonant");
                break;
            }
            else {
                System.out.println(c + " is not a match");
            }
        }
     }

    public static int indexOfIntArray(char[] array, char key) {
        int returnvalue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                returnvalue = i;
                break;
            }
        }
        return returnvalue;
    }
}
