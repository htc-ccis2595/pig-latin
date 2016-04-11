package edu.htc.piglatin;

import java.util.regex.Pattern;

import java.util.regex.Matcher;

/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    public static String translateToPigLatin(String sentence) {
        //Testing if the sentence is blank or empty
        if (sentence.trim().isEmpty()){
            return sentence;
        }

        StringBuilder translatedSentence = new StringBuilder();
        //Converting sentence to array of words
        String [] words = sentence.split(" ");
        for ( String word:words ) {

            translatedSentence.append(wordToPigLatin(word)).append(" "); //converts word to piglatin and adds space between
        }
        translatedSentence.deleteCharAt(translatedSentence.length()-1); //deleting extra space added before at only the end of a sentence
        return translatedSentence.toString();
    }

    public static String translateFromPigLatin(String sentence)throws TranslationException {
        //Testing if the sentence is blank or empty
        if (sentence.trim().isEmpty()){
            return sentence;
        }
        StringBuilder reverseTranslated = new StringBuilder();
        //Converting sentence to array of words
        String [] words = sentence.split(" ");
        for (String word:words) {

            reverseTranslated.append(wordFromPigLatin(word)).append(" ");//converts word to piglatin and adds space between
        }
        reverseTranslated.deleteCharAt(reverseTranslated.length()-1);//deleting extra space added before at only the end of a sentence
        return reverseTranslated.toString() ;

    }

    protected static String wordToPigLatin(String word) {
        //Checks if a word is empty
        if (word.trim().isEmpty()){
            return word;
        }

        //Words with punctuation
        char punctuation = ' ';
        if(word.endsWith(".") || word.endsWith(","))
        {
            punctuation = word.charAt(word.length() - 1);//gets the punctuation at the end of a word
            word = word.substring(0,word.length() - 1);//word without the punctuation
        }

        //Words that start with vowels
        if (word.matches("^[aeiouyAEIOUY].*")){
            //checking for punctuation
            if (punctuation != ' '){
                return word + "'ay" + punctuation;
            }
            else {
                return word + "'ay";
            }
        }
        //words that start with consonants
        else {
            int position = 0;
            Pattern p = Pattern.compile("\\s*[aeiouyAEIOUY]+");//pattern to check the position of the vowel in a word
            Matcher m = p.matcher(word.toLowerCase());//passing the word to the matcher with the pattern
            //if the matcher finds a vowel, get the position of the first vowel in the word
            if (m.find()) {
               position = m.start();
            }



            String part1 = word.substring(0,position).toLowerCase();
            String part2 = word.substring(position).toLowerCase();
            String pigLatinWord =  part2 + "'" + part1 + "ay";
            //words that start with upper case
            if(Character.isUpperCase(word.charAt(0)))
            {
                //converting first letter of the piglatin word to uppercase
               pigLatinWord = pigLatinWord.substring(0,1).toUpperCase() + pigLatinWord.substring(1);
            }

            //words without punctuation
            if (punctuation != ' '){
                pigLatinWord += punctuation;
            }
            return pigLatinWord;
        }
    }

    protected static String wordFromPigLatin(String word) throws TranslationException{
        //Check for empty words
        if (word.trim().isEmpty()){
            return word;
        }
        String englishWord;

        // Words with punctuation
        char punctuation = ' ';
        if(word.endsWith(".") || word.endsWith(","))
        {
            punctuation = word.charAt(word.length() - 1);
            word = word.substring(0,word.length() - 1);
        }

        //words without 'ay
        if(!word.contains("'")){
            throw new TranslationException("The sentence can not be translated");
        }

        //words that start with consonants (piglatin words can't start with consonants
        if(!word.matches("^[aeiouyAEIOUY].*")){
            throw new TranslationException("The word " + word + " is not piglatin");
        }

        //Finding the ' in a piglatin word
        String[] parts = word.toLowerCase().split("\'");

        //if the second part has 'ay then english word = first part
        if(parts[1].equals("ay")){
            englishWord = parts[0];
        }
        else{
            englishWord = parts[1].substring(0,parts[1].length() - 2) + parts[0];
        }
        //words that start with uppercase letters
        if(Character.isUpperCase(word.charAt(0)))
        {
            englishWord = englishWord.substring(0,1).toUpperCase() + englishWord.substring(1);
        }

        //words without punctuation
        if (punctuation != ' '){
            englishWord += punctuation;
        }
        return englishWord;
    }

    public static void main(String args[])
    {
        String sentence = " ";
        System.out.println(translateToPigLatin(sentence));
        try {
            System.out.println(translateFromPigLatin(sentence));
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }
        String word = "Java.";//uppercase
        System.out.println(wordToPigLatin(word));

        word = "programming,";//lowercase & punctuation
        System.out.println(wordToPigLatin(word));

        word = "education.";//vowel
        System.out.println(wordToPigLatin(word));

        word = "syntactically";//consonant
        System.out.println(wordToPigLatin(word));

        word = "Opics'tay";//uppercase
        try {
            System.out.println(wordFromPigLatin(word));
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }

        word = "ypes'tay,";//lowercase & punctuation
        try {
            System.out.println(wordFromPigLatin(word));
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }

    }
}
