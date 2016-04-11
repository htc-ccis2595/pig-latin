package edu.htc.piglatin;

import java.io.*;
/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    public static String translateToPigLatin(String sentence) throws NoSentenceException {
        String returnstr = "";
        String newsentence = "";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        if (sentence.length()==0 | sentence == null){
            throw new NoSentenceException("The sentence cannot be empty or null");
        }

        //** Lets flag the first word of the sentence and the last word

        //** convert the sentence to PigLatin by splitting the sentence into words
        //** seperated by spaces
        String[] words = sentence.split(" ");
        // Store all the words into an array
        String[] arr = new String[words.length];
        //** convert each word into PigLatin
        // Convert English sentence into Pig Latin
        for (int i = 0; i < words.length; i++)
        {
            // Get string from array
            String str = words[i];
            // Convert the strength
            if (i==0){
                blnFirstWord = true;
                blnLastWord = false;
            }
            if (i==words.length-1){
                blnLastWord = true;
                blnFirstWord = false;
            }


            returnstr = wordToPigLatin(str, blnFirstWord, blnLastWord) ;
            // add the string to the arr array
            arr[i] = returnstr;
        }
        
        
        
        //** then reassemble the sentence into a string of words seperated by spaces

        for (int j = 0; j < arr.length ; j++) {

            newsentence = newsentence + arr[j] + " ";

        }

        returnstr = newsentence;
        //** return the sentence in its new form as a string

        return returnstr;
    }

    public static String translateFromPigLatin(String sentence) throws NoSentenceException{
        String returnstr = "";
        String newsentence = "";
        Boolean blnFirstWord = false;
        Boolean blnLastWord = false;

        if (sentence.length()==0 | sentence == null){
            throw new NoSentenceException("The sentence cannot be empty or null");
        }
        //** convert the sentence to English by splitting the sentence into words
        //** seperated by spaces
            String[] words = sentence.split(" ");
            // Store all the words into an array
            String[] arr = new String[words.length];
            //** convert each word into PigLatin
            // Convert English sentence into Pig Latin
            for (int i = 0; i < words.length; i++)
            {
                // Get string from array
                String str = words[i];
                blnFirstWord = false;
                blnLastWord = false;
                // Convert the strength
                if (i==0){
                    blnFirstWord = true;
                    blnLastWord = false;
                }
                if (i==words.length-1){
                    blnLastWord = true;
                    blnFirstWord = false;
                }
                 // Convert the strength
                returnstr = wordFromPigLatin(str, blnFirstWord, blnLastWord) ;
                // add the string to the arr array
                arr[i] = returnstr;
            }

            //** then reassemble the sentence into a string of words seperated by spaces

            for (int j = 0; j < arr.length ; j++) {

                newsentence = newsentence + arr[j] + " ";

            }

            returnstr = newsentence;
            //** return the sentence in its new form as a string

            return returnstr;
        }

    protected static String wordToPigLatin(String word, Boolean blnFirstWord, Boolean blnLastWord) {
        String returnstr = "";
        Boolean blnvowel = false;
        Boolean blnStartWithY = false;
        Integer intVowelLocation = 0;
        String strFirstPart = "";
        Boolean blnisCapitalized = false;

        //** convert the word to PigLatin by splitting the word into an array of char
        //** and then reassemble it according to PigLatin rules

        //** convert the string into an array of char
        char[] charArray = word.toCharArray();

        //** create the PigLatin word

        //** First check if the word starts with a vowel
        blnvowel = wordFromPigLatin_startsWithVowel(word);
        blnisCapitalized = IsCapitalized(word);
        Integer intPuctuationCount = GetPuctuationCount(word);

        //** if the word starts with a vowel or the letter y, add "ay" to the end of the word
        //** if the word starts with any other letter, then move all of the letters up to the first
        //** vowel to the end of the word and add "ay" to the end
        if (blnvowel | Character.toUpperCase(charArray[0]) == 'Y'){
            //**returnstr = word + Character.toLowerCase(charArray[0]);
            //**returnstr = word + "\'" + "ay";
            if (intPuctuationCount > 0) {
                returnstr = word.substring(intVowelLocation, charArray.length-1) + "\'"  + "ay" + word.substring(charArray.length - 1, charArray.length);
            } else {
                returnstr = word.substring(intVowelLocation, charArray.length) + "\'" +  "ay";
            }
        }
        else {
            //** get the location of the first vowel
            intVowelLocation = indexOfFirstVowel(word);
            //** get the beginning of the word up to the first vowel
            strFirstPart = word.substring(0, intVowelLocation);
            //** if there is a period or question mark or exclamation mark at the end of the word,
            //** move these characters to after the ay part.
            //** let's split the word at the
            //** build the word
            if (blnisCapitalized) {
                if (blnLastWord) {
                    if (intPuctuationCount > 0) {
                        returnstr = word.substring(intVowelLocation, intVowelLocation + 1).toUpperCase() + word.substring(intVowelLocation + 1, charArray.length - 1).toLowerCase()
                                + "\'" + strFirstPart.toLowerCase() + "ay" + word.substring(charArray.length - 1, charArray.length);
                    }
                } else {
                    returnstr = word.substring(intVowelLocation, intVowelLocation + 1).toUpperCase() + word.substring(intVowelLocation + 1, charArray.length).toLowerCase()
                            + "\'" + strFirstPart.toLowerCase() + "ay";
                }
            } else {
                intPuctuationCount = GetPuctuationCount(word);
                if (intPuctuationCount > 0) {
                    returnstr = word.substring(intVowelLocation, charArray.length-1) + "\'" + strFirstPart + "ay" + word.substring(charArray.length - 1, charArray.length);
                } else {
                    returnstr = word.substring(intVowelLocation, charArray.length) + "\'" + strFirstPart + "ay";
                }
            }


         }
        //** return the Pig Latin Word


        return returnstr;
    }

    protected static String wordFromPigLatin(String word, Boolean blnFirstWord, Boolean blnLastWord) {
        String returnstr = "";
        char[] charArray;
        Integer intApostropheLocation = 0;
        String strWordFront;
        Boolean blnisCapitalized = false;
        Boolean blnvowel = false;
        //** need to know the length of the wword
        Integer intWordlength = word.length();
        blnvowel = wordFromPigLatin_startsWithVowel(word);
        blnisCapitalized = IsCapitalized(word);

        //** convert the word to English from PigLatin by splitting the word into an array of char
        //** and then reassemble it according to the reverse interpretation of the PigLatin rules

        //** convert the string into an array of char
        charArray = word.toCharArray();

        //** create the English word
        //** need to find the location of the apostrophe

         for (int i = 0; i < charArray.length ; i++) {
             if ( charArray[i] == 39){
                 intApostropheLocation = i;
             }

         }

        //** lets get the front part of the word now
        blnisCapitalized = IsCapitalized(word);
        Integer intPuctuationCount = GetPuctuationCount(word);
        if (blnFirstWord){
            strWordFront = word.substring(intApostropheLocation+1,intWordlength-2).toUpperCase();
            if (strWordFront.length()> 1) {
                strWordFront = strWordFront.substring(0, 1).toUpperCase() + strWordFront.substring(1, strWordFront.length()).toLowerCase();
            }
            else {
                strWordFront = strWordFront.toUpperCase();
            }
        }
        else {
            if (intPuctuationCount > 0){
                strWordFront = word.substring(intApostropheLocation+1,intWordlength-3);
            }
            else {
                strWordFront = word.substring(intApostropheLocation+1,intWordlength-2);
            }
            if (blnisCapitalized){
                //** we need to change the first letter to uppercase
                if (strWordFront.length()>0){
                    strWordFront = strWordFront.substring(0,1).toUpperCase() + strWordFront.substring(1,strWordFront.length());
                }

            }
        }


        //** then reassemble the English Word
        if (intPuctuationCount>0){
            returnstr = strWordFront + word.substring(0,intApostropheLocation).toLowerCase()+word.substring(word.length()-1, word.length());
        }
        else {
            returnstr = strWordFront + word.substring(0,intApostropheLocation).toLowerCase();
        }

        if (blnvowel){
            if (blnisCapitalized ){
                returnstr = returnstr.substring(0,1).toUpperCase() + returnstr.substring(1,returnstr.length());
            }
            else {
                returnstr = returnstr.substring(0, 1).toLowerCase() + returnstr.substring(1, returnstr.length());
            }

        }

        //** return the English version of the Pig Latin Word

        return returnstr;

    }

    public static Boolean wordFromPigLatin_startsWithVowel(String inputStr) {

        Boolean blnvowel = false;
        char[] consonants = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
        char[] StringArray = inputStr.toCharArray();
        char current = StringArray[0];
        for (char c: consonants ) {
            if ( c == current){
                //** if this is a match then we have a lower case vowel
                blnvowel = true;
                break;
            }
            else {
                blnvowel = false;
            }
        }

        return blnvowel;
    }

    public static int indexOfFirstVowel(String word){
        String loweredWord = word.toLowerCase();
        String vowels = "aeiouy";

        for (int index = 0; index < loweredWord.length(); index++)
        {
            if (vowels.contains(String.valueOf(loweredWord.charAt(index))))
            {
                return index;
            }
        }

        // handle cases where a vowel is not found
        return -1;
    }

    public static <T> int indexOf(T needle, T[] haystack)
    {
        for (int i=0; i<haystack.length; i++)
        {
            if (haystack[i] != null && haystack[i].equals(needle)
                    || needle == null && haystack[i] == null) return i;
        }

        return -1;
    }


    public static Boolean IsCapitalized(String inputStr)
    {
        char[] StringArray = inputStr.toCharArray();
        char c;
        Boolean blnRetVal = false;
        c = StringArray[0];

        if ( c == Character.toUpperCase(c)){
                blnRetVal = true;
            }
            else {
                blnRetVal = false;
            }

        return blnRetVal;
    }

    public static Integer GetPuctuationCount(String word){
        Integer intReturnCount = 0;
        char[] StringArray = word.toCharArray();

        for (char c: StringArray ) {
            if (c == '.'){
                intReturnCount++;
            }
            if (c == ','){
                intReturnCount++;
            }
        }

        return intReturnCount;
    }

}
