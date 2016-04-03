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
        public static String translateToPigLatin(String sentence) {
            String newString = "";

            String[] words = sentence.split("\\s+");
            //for (String word : words) System.out.println(word);
            for (String word : words) newString = newString + parseWord(word, "To") + " ";

            newString = newString.substring(0, newString.length()-1); //remove blank space at end of line
            //System.out.println(newString);
            return newString;
        }

        /*
            translate string into english word by word
         */
        public static String translateFromPigLatin(String sentence) {
            String newString = "";

            String[] words = sentence.split("\\s+");
            //for (String word : words) System.out.println(word);
            for (String word : words) newString = newString + parseWord(word, "From") + " ";
            newString = newString.substring(0, newString.length()-1); //remove blank space at end of line
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

           index = patternMatch(word, "aeiouy");

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
            index = patternMatch(word, "'");

            if ( word.length()-index == 3)
                newString = word.substring(0,index);
            else
                try {
                    if (Character.isUpperCase(word.charAt(0))) {
                        newString = word.substring(index + 1, index + 2).toUpperCase() +
                                word.substring(index + 2, word.length() - 2) +
                                word.substring(0, 1).toLowerCase() + word.substring(1, index);
                    } else
                        newString = word.substring(index + 1, word.length() - 2) +
                                word.substring(0, index);
                    }catch (StringIndexOutOfBoundsException e){
                        //System.out.println("Word is null or blank");
                }
            return newString;
        }
    /*
        Method returns index where pattern match occurs
     */
        public static int patternMatch(String word, String pattern){

            int index=-1;
            Pattern p = Pattern.compile("[" + pattern + "]", Pattern.CASE_INSENSITIVE);
            Matcher match = p.matcher(word);
            match.find();
            try {
                index = match.start();
            }catch (IllegalStateException e){
                //System.out.println("No matching character pattern (" + pattern + ") found for the word: " + word);
            }
            return index;
        }

        /*
            Break words into pieces to handle dash(-) or and (&) and handle other end of line punctuation
         */
        public static String parseWord(String word, String translateMethod){
            String newString ="";
            int index=-1;
            String word1, word2, punctuation="";

            index = patternMatch(word, "!.,?"); // end of line have punctuation?
            if (index !=-1){
                punctuation = word.substring(index, word.length());
                word = word.substring(0, index);
            }

            index =  patternMatch(word, "-&");
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
            System.out.println("\nparse word to.....\n");
            System.out.println(parseWord("band-aide!?", "To"));
            System.out.println(parseWord("band-aide", "To"));
            System.out.println(parseWord("Band-aide!?", "To"));
            System.out.println(parseWord("Hello,", "To"));
            System.out.println(parseWord("Mary-Joe", "To"));
            System.out.println(parseWord("Jack&Jill", "To"));
            System.out.println(parseWord("test!", "To"));


            System.out.println("\nparse word from.....\n");
            System.out.println(parseWord("Ello'hay,", "From"));
            System.out.println(parseWord("Ary'may-Oe'jay", "From"));
            System.out.println(parseWord("Ack'jay&Ill'jay", "From"));

            System.out.println("\n");
            System.out.println(translateToPigLatin("This, is a test!"));
            System.out.println(translateFromPigLatin("Is'thay, is'ay a'ay est'tay!"));

        }
    }