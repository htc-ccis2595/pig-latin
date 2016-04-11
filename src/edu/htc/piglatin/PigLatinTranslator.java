package edu.htc.piglatin;
import java.util.ArrayList;

/**
 * Created by marymosman on 3/21/16.
 */

// * on wordFromPigLatin method *
// Mary, i am unsure as to why when i use StringBuilders in my method the StringBuilder.length() value returns out of bounds
// When being used as a perameter. That is why i used - 1 after all the .lengh() method calls





public class PigLatinTranslator {
  static char[] vowelArray = {'A','E','I','O','U','Y','a','e','i','o','u','y'};


    public static ArrayList<String> translateToPigLatin(ArrayList<String> sentence) {
        ArrayList<String> TranslatedSentence = new ArrayList<String>();
        String holder = "";

        for(int i = 0; i < sentence.size(); i++){

            String[] words = sentence.get(i).split(" ");
            for(int y = 0; y < words.length; y++){

                if(words[y].length() > 0 && words[y] != "\n") {
                    holder = holder + wordToPigLatin(words[y]);
                    holder = holder + " ";
                }
            }
            TranslatedSentence.add(holder);
            holder = "";
        }



        return TranslatedSentence;
    }

    public static ArrayList<String> translateFromPigLatin(ArrayList<String> sentence) {
        ArrayList<String> TranslatedSentence = new ArrayList<String>();
        String holder = "";

        for(int i = 0; i < sentence.size(); i++){

            String[] words = sentence.get(i).split(" ");
        for(int y = 0; y < words.length; y++){
            if(words[y].length() > 0 && words[y] != "\n") {
                holder = holder + wordFromPigLatin(words[y]);
                holder = holder + " ";
            }
        }
        TranslatedSentence.add(holder);
        holder = "";
    }



        return TranslatedSentence;
    }




    protected static String wordToPigLatin(String word) {
        if (word == "" || word == " ") {
            return word;
        } else {




            String TranslatedWord = "";

            if (IsFirstLetterVowel(word) == true) {
                TranslatedWord = word + "'ay";

            } else {
                int FirstVowel = FindFirstVowel(word);

                word = word + "'";
                StringBuilder sb = new StringBuilder(word);






                for (int i = 0; i < FirstVowel; i++) {
                    sb.insert(word.length(), word.charAt(i));
                    sb.deleteCharAt(0);


                }
                TranslatedWord = sb.toString();
                TranslatedWord = TranslatedWord + "ay";

            }


            return TranslatedWord;
        }
    }

    protected static String wordFromPigLatin(String word) {

        if(word == "" || word == " " || word == "\n") {
       return word;
        }
        else {

       word = word.replace(",", "");
            word = word.replace(".", "");

            String TranslatedWord = "";
            int ApostrophePosition = 0;
            ApostrophePosition = FindApostrophePosition(word);
            StringBuilder sb = new StringBuilder(word);





            if (TranslationException.canTranslateWord(word) == true) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
                for (int i = sb.length() - 1; i > ApostrophePosition; i--) {

                    if (sb.charAt(sb.length() - 1) != '\'') {
                        sb.insert(0, sb.charAt(sb.length() - 1));
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        sb.deleteCharAt(sb.length() - 1);
                    }

                }
                sb.deleteCharAt(sb.length() - 1);
                TranslatedWord = sb.toString();
                return TranslatedWord;
            } else {
                System.out.println(word);
                System.out.println("A word you have attemeped to translate from piglatin cannot be translated due to lack of an apostrophe");
                return TranslatedWord;
            }

        }

    }







    public static boolean IsFirstLetterVowel(String Word){
        Boolean Answer = false;

        for(int i = 0; i < vowelArray.length; i ++){
            if (Word.charAt(0) == vowelArray[i]){
            Answer = true;
            }

        }


        return Answer;
    }



    public static int FindFirstVowel(String Word){
        int FirstVowelIndex = -1;

        for(int i = 0; i < Word.length(); i++){

            for( int y = 0; y < vowelArray.length; y++){
                if(Word.charAt(i) == vowelArray[y]){
                    FirstVowelIndex = i;
                    return FirstVowelIndex;
                }

            }

        }




        return FirstVowelIndex;
    }


    public static int FindApostrophePosition(String Word){
        int ApostrophePosition = -1;

        for(int i = 0; i < Word.length(); i ++){
            if(Word.charAt(i) == '\''){
                ApostrophePosition = i;

            }

        }

        return ApostrophePosition;
    }



}


