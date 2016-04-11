package edu.htc.piglatin;

/**
 * Created by marymosman on 3/21/16.
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PigLatinTranslator {



    public static String translateToPigLatin(String sentence) throws PigLatException {
        String[] word = sentence.split("\\s+");
        String pLatSent = wordToPigLatin(word[0]);
        try {

            for (int i = 1; i < word.length; i++) {
                String translatedWord = wordToPigLatin(word[i]);
                pLatSent = pLatSent + " " + translatedWord;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String is blank or null");
            throw new PigLatException("Unable to translate to pig latin");
        }
        return pLatSent;

    }

    public static String translateFromPigLatin(String sentence) throws PigLatException {
        String[] word = sentence.split("\\s+");
        String engSent = wordFromPigLatin(word[0]);
        try {
            for (int i = 1; i < word.length; i++) {
                Pattern pattern = Pattern.compile("\\w+'\\w*ay.*");
                Matcher m = pattern.matcher(word[i]);
                if (m.matches()) {
                    String translatedWord = wordFromPigLatin(word[i]);
                    engSent = engSent + " " + translatedWord;
                } else {
                    System.out.println("It seems an error has occured");
                }
            }

            }catch(StringIndexOutOfBoundsException e){
                //throw new PigLatException("Unable to translate to english");

            System.out.println("It seems an error has occured");


            }
            return engSent;
    }
    protected static String wordToPigLatin(String word) {
        Boolean blnError = false;
        String pLatWord = "";
        do {

            try {
                if (!word.isEmpty()) {
                    pLatWord = "";
                    //break;
                } else if (word.trim().length() > 0) {
                    pLatWord = "";
                }
            } catch (StringIndexOutOfBoundsException e) {
                blnError = true;
            }
        } while (blnError);
        ArrayList<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('Y');
        try {
            char fLetter = word.charAt(0);
            String lLetter = word.substring(word.length() - 1);
            String punct = "";
            if (lLetter.matches(".*\\p{Punct}")) {
                word = word.substring(0, word.length() - 1);
                punct = lLetter;
            }
            int fVowel = 0;


            if (vowels.contains(fLetter)) {
                pLatWord = word + "'ay";
            } else {
                for (int i = 1; i < word.length(); i++) {
                    if (vowels.contains(word.charAt(i))) {
                        fVowel = i;
                        break;
                    } else {
                        fVowel = word.length();
                    }
                }

                for (int i = fVowel; i < word.length(); i++) {
                    pLatWord = pLatWord + word.charAt(i);
                }

                pLatWord = pLatWord + "'";

                for (int i = 0; i < fVowel; i++) {
                    pLatWord = pLatWord + word.charAt(i);
                }
                pLatWord = pLatWord + "ay";
            }
            if (punct.length() > 0) {
                pLatWord = pLatWord + punct;
            }
            pLatWord = pLatWord.toLowerCase();
            if (Character.isUpperCase(fLetter)) {

                pLatWord = pLatWord.substring(0, 1).toUpperCase() + pLatWord.substring(1, pLatWord.length());
            }


        } catch (StringIndexOutOfBoundsException e) {
            //throw new PigLatException("Unable to translate to english");

            System.out.println("It seems an error has occured");


        }
        return pLatWord;
    }


    protected static String wordFromPigLatin(String word) throws PigLatException {
        Boolean blnError = false;
        String engWord;
        do {



            try {

                if (word.isEmpty()) {
                    blnError = true;
                    engWord = "";
                    break;
                } else if (word.trim().length() == 0) {
                    blnError = true;
                     engWord = "";
                     break;
                } else {
                    blnError = false;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("an error has occured 1");

            }

            String lLetter = word.substring(word.length() - 1);
            String punct = "";

            char fLetter = word.charAt(0);
            if (lLetter.matches(".*\\p{Punct}")) {
                word = word.substring(0, word.length() - 1);
                punct = lLetter;
            }
            try {
                String apost = "\'";

                if (!word.contains(apost)){
                    blnError = true;

                }

            } catch (StringIndexOutOfBoundsException e) {

                throw new PigLatException("Unable to translate to english because there is not an apostrophe");
                //System.out.println("an error has occured 2");
            }
            String[] parts = word.split("'");
            int ayPos = parts[1].lastIndexOf("ay");
            String fPart = parts[1].substring(0, ayPos);
            String secPart = parts[1].substring((ayPos + 2), parts[1].length());
            engWord = fPart + secPart + parts[0];

            if (punct.length() > 0) {
                engWord = engWord + punct;
            }

            engWord = engWord.toLowerCase();
            if (Character.isUpperCase(fLetter)) {

                engWord = engWord.substring(0, 1).toUpperCase() + engWord.substring(1, engWord.length());
            }

        }while (blnError);

        return engWord;
    }


    public static void main(String[] args) throws PigLatException {
        System.out.println("Testing word to pig latin");
        String word = "player";
        String pLatWord = "layer'pay";
        String sentence = "Johnny does not know where he go";
        System.out.println("The word to be tested is: " + word + ". When it is translated to pig latin is: " + wordToPigLatin(word));
        System.out.println("Now let's test it back to English: " + wordFromPigLatin(pLatWord));
        System.out.println("Now let's test a sentence!");
        System.out.println("The sentence to be test translated is " + sentence + ". Here it is translated back" + translateToPigLatin(sentence));
        sentence = translateToPigLatin(sentence);
        System.out.println("Translating sentence back to English: " + translateFromPigLatin(sentence));


        System.out.println("\nTo....\n");
        System.out.println(wordToPigLatin("ride"));
        System.out.println(wordToPigLatin("okay"));
        System.out.println(wordToPigLatin("Bacon"));
        System.out.println(wordToPigLatin("find"));
        System.out.println(wordToPigLatin("Larry"));
        System.out.println(wordToPigLatin("Ghost"));
        System.out.println("\nFrom....\n");
        System.out.println(wordFromPigLatin("Eggs'ay"));
        System.out.println(wordFromPigLatin("kay'ay"));
        System.out.println(wordFromPigLatin("e'thay"));
        System.out.println(wordFromPigLatin("Arry'lay"));
        System.out.println(wordFromPigLatin("amb'lay"));
       // System.out.println(wordFromPigLatin("amblay"));// this is the only one I could not figure out, I do not know why my try catch does not work for checking if there is a ' or not.
    }



}
