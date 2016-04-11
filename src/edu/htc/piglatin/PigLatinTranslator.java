package edu.htc.piglatin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ken nagel on 3/21/16.
 */
public class PigLatinTranslator {
        public static Pattern pattern;

        /*
            translate string into pig latin word by word
         */
        public static String translateToPigLatin(String sentence) throws TranslateException  {
            String newString = "";

            String[] words = sentence.split("\\s+");
            //for (String word : words) System.out.println(word);
            for (String word : words) newString = newString + parseWord(word, "To") + " ";

            try {
                newString = newString.substring(0, newString.length() - 1);
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("\nString is blank or null");
                throw new TranslateException();
                    //remove blank space at end of line
            }
            //System.out.println(newString);
            return newString;
        }

        /*
            translate string into english word by word
         */
        public static String translateFromPigLatin(String sentence) throws TranslateException  {
            String newString = "";

            String[] words = sentence.split("\\s+");
            //for (String word : words) System.out.println(word);
            try {
                for (String word : words) newString = newString + parseWord(word, "From") + " ";
                newString = newString.substring(0, newString.length() - 1);
            } catch (StringIndexOutOfBoundsException e){
                throw new TranslateException("Translate sentence to English failure");
                //remove blank space at end of line
            }
            //System.out.println(newString);
            return newString;
        }

        /*
            translates word to pig latin
            starts with vowel add 'ay at end eggs becomes eggs'ay  //note y is vowel when not first letter -- gym ym'gay
            starts with consonant move letters up to first vowel to end and add 'ay'
            word becomes ord'way //the becomes e'thay  //y is consonant when first letter --yes es'yay (yes-ay)***

         */
        protected static String wordToPigLatin(String word) {
            String newString = "";
            int index=-1;

            try {
                index = patternMatch(word, "aeiouy");
            } catch (TranslateException e) {
                System.out.println("No vowels found");
            }

            switch (index){
                case 0:
                        newString = word + "'ay";
                    break;
                default:
                    try {
                        if (Character.isUpperCase(word.codePointAt(0))) {
                            newString = word.substring(index, index + 1).toUpperCase() +
                                    word.substring(index + 1, word.length()) + "'" +
                                    word.substring(0, 1).toLowerCase() +
                                    word.substring(1, index) + "ay";
                        } else
                            newString = word.substring(index, word.length()) + "'" + word.substring(0, index) + "ay";
                        } catch (StringIndexOutOfBoundsException e){
                            //System.out.println("Word is null or blank");
                    }
            }
            return newString;
        }

        /*
            translate a word from pig latin to english
            ends with 'ay  //eggs'ay becomes eggs  //yay'ay becomes yay
            ends with '?ay' //ord'way becomes word  //e'thay the becomes the

         */
        protected static String wordFromPigLatin(String word) {
            String newString = "";
            int index=-1;
            try {
                index = patternMatch(word, "'");
            } catch (TranslateException e) {
                System.out.println("Failed to find apostrophe in word: " + word);
                newString = word;
            }


            if (index == -1){   //is there an apostrophe?
                newString = word;
                System.out.println("Failed to translate '" + word + "' to english\n");
            } else {

                if (word.length() - index == 3)
                    newString = word.substring(0, index);
                else
                    try {
                        if (Character.isUpperCase(word.charAt(0))) {
                            newString = word.substring(index + 1, index + 2).toUpperCase() +
                                    word.substring(index + 2, word.length() - 2) +
                                    word.substring(0, 1).toLowerCase() + word.substring(1, index);
                        } else
                            newString = word.substring(index + 1, word.length() - 2) +
                                    word.substring(0, index);
                    } catch (StringIndexOutOfBoundsException e) {
                        //System.out.println("Word is null or blank");
                    }
            }
            return newString;
        }
    /*
        Method returns index where pattern match occurs
     */
        public static int patternMatch(String word, String pattern) throws TranslateException{

            int index=-1;
            Pattern p = Pattern.compile("[" + pattern + "]", Pattern.CASE_INSENSITIVE);
            Matcher match = p.matcher(word);
            match.find();
            try {
                index = match.start();
            }catch (IllegalStateException e) {
                if (pattern == "'" || word == "" || word == " "){
                    throw new TranslateException("Word translation failure blank, null or missing apostrophe");
                }
                //System.out.println("No matching character pattern (" + pattern + ") found for the word: " + word);
            }
            return index;
        }

        /*
            Break words into pieces to handle dash(-) or and (&) and handle other end of line punctuation
         */
        public static String parseWord(String word, String translateMethod)throws TranslateException{
            String newString ="";
            int index=-1;
            String word1, word2, punctuation="";

            try {
                index = patternMatch(word, "!.,?"); // end of line have punctuation?
            } catch (TranslateException e) {
                throw new TranslateException();
                //System.out.println("no ending punctuation");
            }
            if (index !=-1){
                punctuation = word.substring(index, word.length());
                word = word.substring(0, index);
            }

            try {
                index =  patternMatch(word, "-&");
            } catch (TranslateException e) {
                //System.out.println("No hyphen or & sign");
            }
            if (index != -1){
                word1 = word.substring(0,index);
                word2 = word.substring(index+1, word.length());

                if (translateMethod == "To") {
                    newString = wordToPigLatin(word1) + word.substring(index, index + 1) + wordToPigLatin(word2);
                } else {
                    newString = wordFromPigLatin(word1) + word.substring(index, index + 1) + wordFromPigLatin(word2);
                }
            } else
                if (translateMethod == "To") {
                    newString = wordToPigLatin(word);
                } else {
                    newString = wordFromPigLatin(word);
                }
            newString = newString + punctuation;
            return newString;
        }


        public static void main(String[] args) {

            System.out.println("\nTo....\n");
            System.out.println(wordToPigLatin("gym"));
            System.out.println(wordToPigLatin("yay"));
            System.out.println(wordToPigLatin("Eggs"));
            System.out.println(wordToPigLatin("the"));
            System.out.println(wordToPigLatin("Mary"));
            System.out.println(wordToPigLatin("Lamb"));
            System.out.println("\nFrom....\n");
            System.out.println(wordFromPigLatin("Eggs'ay"));
            System.out.println(wordFromPigLatin("ord'way"));
            System.out.println(wordFromPigLatin("e'thay"));
            System.out.println(wordFromPigLatin("Ary'may"));
            System.out.println(wordFromPigLatin("amb'lay"));
            System.out.println(wordFromPigLatin("amblay")); // this fails validation


            System.out.println("\nparse word to.....\n");
            try {
                System.out.println(parseWord("band-aide!?", "To"));
                System.out.println(parseWord("band-aide", "To"));
                System.out.println(parseWord("Hello,", "To"));
                System.out.println(parseWord("Mary-Joe", "To"));
                System.out.println(parseWord("Jack&Jill", "To"));
                System.out.println(parseWord("test!", "To"));

                System.out.println("\nparse word from.....\n");
                System.out.println(parseWord("Ello'hay,", "From"));
                System.out.println(parseWord("Ary'may-Oe'jay", "From"));
                System.out.println(parseWord("Ack'jay&Ill'jay", "From"));
            } catch (TranslateException e){
                System.out.println("Failed word translation");
            }

            System.out.println("\n");
            try {
                System.out.println(translateToPigLatin("This, is a test!"));
            } catch (TranslateException e){
                System.out.println("Failed to translate: This, is a test!");
            }
            try {
                System.out.println(translateFromPigLatin("Is'thay, is'ay a'ay est'tay!"));
            } catch (TranslateException e){
                System.out.println("Failed to translate to English");
            }

            System.out.println(wordFromPigLatin("non name"));

        }
    }