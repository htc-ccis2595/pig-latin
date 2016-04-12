package edu.htc.piglatin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by marymosman on 3/21/16.
 */
public class PigLatinTranslator {

    public static String translatesentencetoPigLatin(String sentence) {

        String piglatin = "";
        String[] words = sentence.split("\\s+");

        if (sentence.trim().equalsIgnoreCase("")) {
            return sentence;
        }


        System.out.println("last word is " + words[words.length - 1]);

        for (String word : words) {

            piglatin = piglatin + translateToPigLatin(word) + ' ';
        }

        return piglatin.trim();


    }


    public static String translatesentencetoEnglish(String sentence) throws CannotTranslate {

        String english = "";
        String[] words = sentence.split("\\s+");

        if (sentence.trim().equalsIgnoreCase("")) {
            return sentence;
        }

        for (String word : words) {
            if (startswithLVowel(word) == true) {
                String temp = wordFromLowerPigLatin(word) ;
                english += movePunctuation(temp) + ' ';
            } else {
                String temp = wordFromUpperPigLatin(word);
                english += movePunctuation(temp) + ' ';
            }
        }

        return english.trim();
    }

    public static String translateToPigLatin(String word) {

        Pattern pNonAlph = Pattern.compile("[^a-zA-Z\\d\\s:]");
        Matcher mNonAlph = pNonAlph.matcher(word);


        if (mNonAlph.find()) {
            String wordUpdate = "";
            if (startswithUVowel(word) == true) {
                wordUpdate = uppercasevowelToPigLatin(word);

            } else if (startswithLVowel(word) == true) {
                wordUpdate = lowercasevowelToPigLatin(word);

            } else if (startswithLConsonant(word) == true) {
                wordUpdate = lowerconsonantToPigLatin(word);

            } else if (startswithUConsonant(word) == true) {
                wordUpdate = upperconsonantToPigLatin(word);

            }

            System.out.println("Matches");
            String punc = mNonAlph.group();
            System.out.println(punc);
            String flipPunc = movePunctuation(wordUpdate);

            return flipPunc;
        } else {

            if (startswithLConsonant(word) == true) {
                String piglatin = lowerconsonantToPigLatin(word);
                return piglatin;

            }
            if (startswithUConsonant(word) == true) {
                String piglatin = upperconsonantToPigLatin(word);
                return piglatin;

            }
            if (startswithUVowel(word) == true) {
                String piglatin = uppercasevowelToPigLatin(word);
                return piglatin;

            }
            if (startswithLVowel(word) == true) {
                String piglatin = lowercasevowelToPigLatin(word);
                return piglatin;
            }

            if (startswithUVowel(word) == true) {
                String piglatin = uppercasevowelToPigLatin(word);
                return piglatin;

            }
            if (startswithLVowel(word) == true) {
                String piglatin = lowercasevowelToPigLatin(word);
                return piglatin;
            }


        }

        return word;


    }



      private static String movePunctuation(String word) {
          StringBuilder sb = new StringBuilder(word);
          int i = 0;
          String punctuation = "";
          while (i < sb.length()) { // Iterate over letters in word

              if (isPunctuation(sb.charAt(i))) { // Move punctuation to end
                  char temp = sb.charAt(i);
                  sb.deleteCharAt(i);
                  punctuation = punctuation + temp;

              }

              else {
                  i++;
              }
          }
          sb.append(punctuation);
          return sb.toString();
      }


      private static boolean isPunctuation(char c) {
          return c == ',' || c == '.' || c == '!' ||
                  c == '?' || c == ':' || c == ';';
      }


    public static String lowerconsonantToPigLatin(String word) {
        if (word.equalsIgnoreCase("")) {
            return word;
        }

        String translatedword = word;

        if (startswithLConsonant(word) == true) {
            for (int i = 0; i < translatedword.length(); i++) {
                int index = findVowelIndex(word);
                String wordFront = translatedword.substring(0, index); //removes all chars from beginning of word to the first vowel encountered

                String wordBack = translatedword.substring(index, word.length()); //removes first char of english word

                String pigword = wordBack + "'" + wordFront + "ay";

                return pigword;

            }


        }
        return translatedword;
    }



    public static String upperconsonantToPigLatin(String word) {
        if(word.equalsIgnoreCase("")) {
            return word;
        }

        String translatedword = word;

        if (startswithUConsonant(word) == true) {
            for(int i = 0; i < translatedword.length(); i++) {
                int index = findVowelIndex(word);


                String wordFront = translatedword.substring(0, index); //removes all chars from beginning of word to the first vowel encountered



                String wordBack = translatedword.substring(index, word.length()); //removes first char of english word

                String capFront = wordFront.substring(0);


                String backword = wordBack.substring(0, 1);

                String backword2 = backword.toUpperCase();


                String frontword2 = capFront.toLowerCase();



                String letters = wordBack.substring(1); //removes consonants


                String pigword = backword2 + letters + "'" + frontword2 + "ay";



                return pigword;

            }
        }
        return translatedword;
    }



    public static int findVowelIndex(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'
                    || word.charAt(i) == 'y') {
                return i;
            }
        }
        return -1;

    }


    public static String lowercasevowelToPigLatin(String word) {

        if(word.equalsIgnoreCase("")) {
            return word;
        }

        String translatedword = word;

        if(startswithLVowel(word) == true) {
            translatedword = word.concat("'ay");
        }
        return translatedword;

    }

    public static String uppercasevowelToPigLatin(String word) {

        if(word.equalsIgnoreCase("")) {
            return word;
        }

        String translatedword = word;

        if(startswithUVowel(word) == true) {
            translatedword = word.concat("'ay");


        }

        return translatedword;


    }

    public static String wordFromLowerPigLatin(String word) throws CannotTranslate {

        String translatedword = word;

        if (!word.contains("'")) {
            throw new CannotTranslate("Cannot translate " + word);
        }

        if (word.equalsIgnoreCase("")) {
            return word;
        }


            if (startswithLVowel(word) == true) {
                String[] parts = word.split("'");

                for (String str : parts) {
                    if (parts[1].equalsIgnoreCase("ay")) {
                        String letter = parts[0].substring(0, 1);
                        letter = letter.toUpperCase();

                        String finishedword = parts[0];




                        return finishedword;
                    }


                }

                if (startswithLVowel(word) == true && !parts[1].equalsIgnoreCase("ay")) {
                    parts = word.split("'");
                    int pos = parts[1].lastIndexOf("ay");



                    String letters = parts[1].substring(0, pos);


                    letters = letters.toLowerCase();
                    parts[0] = parts[0].toLowerCase();
                    String punc = parts[1].substring(pos + 2);

                    System.out.println(punc);

                    String englishword = letters + parts[0] + punc;

                    return englishword;
                }


            }



        return translatedword;
    }





    public static String wordFromUpperPigLatin(String word) throws CannotTranslate {
        if (word == "") {
            return word;
        }

        //throws CannotTranslate for words that do not contain '
        if(!word.contains("'")) {
            throw new CannotTranslate("Cannot translate " + word);

        }

        if (startswithUVowel(word) == true) {
            String[] parts = word.split("'");

            if (parts[1].equalsIgnoreCase("ay")) {
                String letter = parts[0].substring(0, 1);
                letter = letter.toUpperCase();


                String finishedword =  parts[0];




                return finishedword;

            } else {

                int pos = parts[1].lastIndexOf("ay");

                String letters = parts[1].substring(0, pos);


                //needs work on making sure only first letter is caps
                if(startswithUVowel(word) == true) {
                    letters = letters.toUpperCase();
                    parts[0] = parts[0].toLowerCase();
                    String firstChar = letters.substring(0, 1);
                    String punc = parts[1].substring(pos + 2);

                    String followingChar = letters.substring(1);

                    followingChar = followingChar.toLowerCase();


                    String englishword = firstChar + followingChar + parts[0] + punc;


                    return englishword;
                }


            }


        }

        return word;
    }








    public static boolean startswithLVowel(String word) {

        boolean startswithlvowel = false;
        if(word.startsWith("a") || word.startsWith("e") || word.startsWith("i") || word.startsWith("o") || word.startsWith("u")
                || word.startsWith("y")) {
            startswithlvowel = true;
        }

        return startswithlvowel;

    }


    public static boolean startswithUVowel(String word) {

        boolean startswithuvowel = false;
        if(word.startsWith("A") || word.startsWith("E") || word.startsWith("I") || word.startsWith("O") || word.startsWith("U")
                || word.startsWith("Y")) {
            startswithuvowel = true;
        }

        return startswithuvowel;

    }

    public static boolean startswithLConsonant(String word) {
        Pattern pattern = Pattern.compile("[a-z].*");
        Matcher m = pattern.matcher(word);
        if ( m.matches() ) {
            if(!word.startsWith("a") && !word.startsWith("e") && !word.startsWith("i") && !word.startsWith("o") && !word.startsWith("u")
                    && !word.startsWith("y")) {
                return true;

            }
            else {
                return false;
            }

        } else {
            return false;
        }




    }

    public static boolean startswithUConsonant(String word) {

        Pattern pattern = Pattern.compile("[A-Z].*");
        Matcher m = pattern.matcher(word);
        if ( m.matches() ) {
            if(!word.startsWith("A") && !word.startsWith("E") && !word.startsWith("I") && !word.startsWith("O") && !word.startsWith("U")
                    && !word.startsWith("Y")) {
                return true;

            }
            else {
                return false;
            }

        } else {
           return false;
        }






    }

}
