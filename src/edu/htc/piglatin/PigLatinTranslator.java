package edu.htc.piglatin;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    public static String translateToPigLatin(String sentence) {
        //Take a sentence, translate each word using wordToPigLatin.
        //Read until a space to get the word.
        //?? What to use to store the sentence/strings as it progresses.
        String[] words = sentence.split("\\s+");
        String pigLatinSentence = wordToPigLatin(words[0]);

        for (int i = 1; i < words.length; i++){
            String translatedWord = wordToPigLatin(words[i]);
            pigLatinSentence = pigLatinSentence + " " + translatedWord;
        }
        return pigLatinSentence;


    }

    public static String translateFromPigLatin(String sentence) {
        //Same format as translateToPigLatin but use wordFromPigLatin
        String[] words = sentence.split("\\s+");
        String englishSentence = wordFromPigLatin(words[0]);


        for (int i = 1; i < words.length; i++){
            Pattern pattern = Pattern.compile("\\w+'\\w*ay.*");
            Matcher m = pattern.matcher(words[i]);
            if(m.matches()) {
                String translatedWord = wordFromPigLatin(words[i]);
                englishSentence = englishSentence + " " + translatedWord;
            } else {
                System.out.println("Some of the words in this sentence are not in Pig Latin");
                System.out.println(words[i]);
            }
        }
        return englishSentence;

    }

    protected static String wordToPigLatin(String word) {
        //if word starts with a vowel, add 'ay to the end.
        //Otherwise read until vowel, move vowel to end of word to beginning of word. Add 'ay to end of original word. End of word should be initial consonants.
        //make sure other punctuation isn't a problem - period stays at the end of the word for example
        String wordAsPigLatin = "";
        if(word.isEmpty()){
            wordAsPigLatin = "";
            return wordAsPigLatin;
        } else if (word.trim().length() == 0){
            wordAsPigLatin = "";
            return wordAsPigLatin;
        }

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

        char firstLetter = word.charAt(0);
        String lastLetter = word.substring(word.length()-1);
        String punctuation = "";
        if (lastLetter.matches(".*\\p{Punct}")){
            word = word.substring(0, word.length() - 1);
            punctuation = lastLetter;
        }
        int firstVowel = 0;


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

            wordAsPigLatin = wordAsPigLatin + "'";

            for (int i = 0; i < firstVowel; i++){
                wordAsPigLatin = wordAsPigLatin + word.charAt(i);
            }
            wordAsPigLatin = wordAsPigLatin + "ay";
        }
        if(punctuation.length() > 0){
            wordAsPigLatin = wordAsPigLatin + punctuation;
        }
        wordAsPigLatin = wordAsPigLatin.toLowerCase();
        if (Character.isUpperCase(firstLetter)){

            wordAsPigLatin = wordAsPigLatin.substring(0,1).toUpperCase() + wordAsPigLatin.substring(1, wordAsPigLatin.length());
        }

        return wordAsPigLatin;
    }

    protected static String wordFromPigLatin(String word) {
        //Find 'ay and remove it. Move all letters in front of 'ay to the back of the word
        //make sure punctuation remains in the correct spot
        String wordAsEnglish;
        if(word.isEmpty()){
            wordAsEnglish = "";
            return wordAsEnglish;
        } else if (word.trim().length() == 0){
            wordAsEnglish = "";
            return wordAsEnglish;
        }
        String lastLetter = word.substring(word.length()-1);
        String punctuation = "";

        char firstLetter = word.charAt(0);

        if (lastLetter.matches(".*\\p{Punct}")){
            word = word.substring(0, word.length() - 1);
            punctuation = lastLetter;
        }
        String[] parts = word.split("'");
        int ayPosition = parts[1].lastIndexOf("ay");
        String firstPart = parts[1].substring(0,ayPosition);
        String secondPart = parts[1].substring((ayPosition+2), parts[1].length());
        wordAsEnglish = firstPart + secondPart + parts[0];

        if(punctuation.length() > 0){
            wordAsEnglish = wordAsEnglish + punctuation;
        }

        wordAsEnglish = wordAsEnglish.toLowerCase();
        if (Character.isUpperCase(firstLetter)){

            wordAsEnglish = wordAsEnglish.substring(0,1).toUpperCase() + wordAsEnglish.substring(1, wordAsEnglish.length());
        }

        return wordAsEnglish;
    }

    /*String pigLatin1 = "Ord'way";
    Pattern pattern = Pattern.compile("\\w+'\\w*ay");
    Matcher m = pattern.matcher(pigLatin1);

    if (m.matches()){
        System.out.println("This is valid pig latin");
    } else {
        System.out.println("This is invalid pig latin");
    }*/


    public static void main(String[] args) {
        System.out.println("Testing word to pig latin");
        String word = "word";
        String pigLatinWord = "ord'way";
        String sentence = "Mary had a little lamb.";
        System.out.println("The word: word translated to pig latin is: " + wordToPigLatin(word));
        System.out.println("Translating it back to English gives: " + wordFromPigLatin(pigLatinWord));
        System.out.println("Translating the sentence: Mary had a little lamb.: " + translateToPigLatin(sentence));
        sentence = translateToPigLatin(sentence);
        System.out.println("Translating sentence back to English: " + translateFromPigLatin(sentence));
    }

}




