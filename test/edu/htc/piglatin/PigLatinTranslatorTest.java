package edu.htc.piglatin;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {

    /*
        Translate from English pig latin
     */

    @Test
    public void translateToPigLatin(){
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words to pig latin....");
        ArrayList<String> str = new ArrayList<String>();
        str.add("eggs");
        str.add("yay");
        str.add("word");
        str.add("the");
        str.add("Mary");
        str.add("had");
        str.add("a");
        str.add("little");
        str.add("lamb");
        str.add("gym");
        str.add("yes");
        assertEquals(word1.wordToPigLatin("eggs"), "eggs'ay" );
        assertEquals(word1.wordToPigLatin("yay"), "yay'ay" ); //*
        assertEquals(word1.wordToPigLatin("word"), "ord'way" );
        assertEquals(word1.wordToPigLatin("the"), "e'thay" );
        assertEquals(word1.wordToPigLatin("rye"), "ye'ray" );
        assertEquals(word1.wordToPigLatin("Mary"), "Ary'may" );

        for (String word: str)
            System.out.println(word1.wordToPigLatin(word));
    }

    /*
        Translate from english to pigt latin and identify blank or empty strings
     */
    @Test
    public void translateToPigLatin_emptyAndBlankStrings(){
        System.out.println("translate to pig latin empty and blank...");
        try {
            PigLatinTranslator.translateToPigLatin("");
        }catch (TranslateException e){
            System.out.println("Failed to translate empty string");
        }
        try {
            PigLatinTranslator.translateToPigLatin(" ");
        } catch (TranslateException e){
            System.out.println("Failed to translate blank string");
        }
    }

    /*
        Translate from pig latin to English
     */
    @Test
    public void translateFromPigLatin(){
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words from pig latin....");
        ArrayList<String> str = new ArrayList<String>();
        int i=0;
        str.add("eggs'ay");
        str.add("yay'ay");
        str.add("ord'way");
        str.add("e'thay");
        str.add("Ary'may");
        str.add("ad'hay");
        str.add("a'ay");
        str.add("ittle'lay");
        str.add("amb'lay");
        str.add("ym'gay");
        str.add("yes'ay");
        assertEquals(word1.wordFromPigLatin("eggs'ay"), "eggs" );
        assertEquals(word1.wordFromPigLatin("yay'ay"), "yay" ); //*
        assertEquals(word1.wordFromPigLatin("ord'way"), "word" );
        assertEquals(word1.wordFromPigLatin("e'thay"), "the" );
        assertEquals(word1.wordFromPigLatin("ye'ray"), "rye" );
        assertEquals(word1.wordFromPigLatin("Ary'may"), "Mary" );

        System.out.println(word1.wordFromPigLatin("Armay")); // fail translation missing apostrophe

        for (String word: str)
            System.out.println(word1.wordFromPigLatin(word));
    }

    /*
        Translate from pig latin to English and identify blank or empty strings

     */
    @Test
    public void translateFromPigLatin_emptyAndBlankStrings() {
        System.out.println("translate from pig latin empty and blank...");
        try {
            PigLatinTranslator.translateFromPigLatin("");
            PigLatinTranslator.translateFromPigLatin(" ");
        } catch (TranslateException e) {
            System.out.println("\nFailed to translate to english");
        }
    }
    /*
        Translate a word to pig latin that is blank or null
     */
    @Test
    public void wordToPigLatin_emptyAndBlankStrings() {
        System.out.println("translate to pig latin empty and blank...");

        PigLatinTranslator.wordToPigLatin("");
        PigLatinTranslator.wordToPigLatin(" ");
    }

    /*
        Translate word to pig latin that has lowercase vowel
     */
    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words to pig latin with/without uppercse....");
        ArrayList<String> str = new ArrayList<String>();
        str.add("Mary"); // translates successful
        str.add("telephone");
        str.add("eggs");
        str.add("Eggs"); // translates successful
        for (String word: str)
            System.out.println(word1.wordToPigLatin(word));

        assertEquals(word1.wordToPigLatin("Mary"), "Ary'may" );
        assertEquals(word1.wordToPigLatin("telephone"), "elephone'tay" );
        assertEquals(word1.wordFromPigLatin("Ary'may"), "Mary" );
        assertEquals(word1.wordFromPigLatin("elephone'tay"), "telephone" );
        assertEquals(word1.wordToPigLatin("eggs"), "eggs'ay" );

    }
    /*
        Translate word to pig latin that has punctuation
     */
    @Test
    public void wordToPigLatin_withPunctuation() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words to pig latin with punctuation....");

        try {
            System.out.println(word1.parseWord("Mary!!!", "To"));
            assertEquals(word1.parseWord("Mary!", "To"), "Ary'may!");

            System.out.println(word1.parseWord("Mary-Joe?!", "To"));
            assertEquals(word1.parseWord("Mary-Joe", "To"), "Ary'may-Oe'jay");

            System.out.println(word1.parseWord("Jack&Jill,", "To"));
            assertEquals(word1.parseWord("Jack&Jill", "To"), "Ack'jay&Ill'jay");
        } catch (TranslateException e){
            System.out.println("Translate word to pig latin failure");
        }

        System.out.println("\n");

    }
    /*
        Translate word to pig latin that starts with capital letter
     */
    @Test
    public void wordToPigLatin_startsWithCapitalVowel() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words to pig latin with capital vowel....");

        System.out.println(word1.wordToPigLatin("Mary"));
        assertEquals(word1.wordToPigLatin("Mary"), "Ary'may" );
        try {
            System.out.println(word1.parseWord("Mary-Joe", "To"));
            assertEquals(word1.parseWord("Mary-Joe", "To"), "Ary'may-Oe'jay");
        } catch (TranslateException e){
            System.out.println("Word translation failure");
        }


        System.out.println("\n");
    }
    /*
        Translate word to pig latin that starts with lowercase consonant
     */
    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words to pig latin that starts with lowercase consonant....");
        System.out.println(word1.wordToPigLatin("bread"));
        assertEquals(word1.wordToPigLatin("bread"), "ead'bray" );

        try {
            System.out.println(word1.parseWord("time-out", "To"));
            assertEquals(word1.parseWord("time-out", "To"), "ime'tay-out'ay");
        } catch (TranslateException e){
            System.out.println("Word translation failure");
        }

    }
    /*
        Translate word to pig latin that starts with capital consonant
     */
    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words to pig latin that start with uppercase consonant....");
        System.out.println(word1.wordToPigLatin("Bread"));
        assertEquals(word1.wordToPigLatin("Bread"), "Ead'bray" );

        try {
            System.out.println(word1.parseWord("Time-out", "To"));
            assertEquals(word1.parseWord("Time-out", "To"), "Ime'tay-out'ay");
        }catch (TranslateException e){
            System.out.println("Word translation failure");
        }

    }

    /*
        Translate word to English that is blank or null
     */
    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() {
        PigLatinTranslator.wordFromPigLatin("");
        PigLatinTranslator.wordFromPigLatin(" ");
    }

    /*
        Translate word to english that starts with lowercase vowel
     */
    @Test
    public void wordFromPigLatin_startsWithLowercaseVowel() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words from pig latin starts with lowercase consonant....");
        System.out.println(word1.wordFromPigLatin("ead'bray"));
        assertEquals(word1.wordFromPigLatin("ead'bray"), "bread" );

        try {
            System.out.println(word1.parseWord("ime'tay-out'ay", "From"));
            assertEquals(word1.parseWord("ime'tay-out'ay", "From"), "time-out");
        }catch (TranslateException e){
            System.out.println("Word translation error");
        }
    }

    /*
        Trasnlate word to english that starts with capital letter
     */
    @Test
    public void wordFromPigLatin_startsWithCapitalVowel() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words from pig latin starts with uppercase vowel....");
        System.out.println(word1.wordFromPigLatin("Apple'ay"));
        assertEquals(word1.wordFromPigLatin("Apple'ay"), "Apple" );

        try {
            System.out.println(word1.parseWord("ABC'ay-EFG'ay", "From"));
            assertEquals(word1.parseWord("ABC'ay-EFG'ay", "From"), "ABC-EFG");
        }catch (TranslateException e){
            System.out.println("Word translation failure");
        }
    }
    /*
        Translate word to english that starts with lowercase consonant
     */
    @Test
    public void wordFromPigLatin_startsWithLowercaseConsonant() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words from pig latin starts with lowercase consonant....");
        System.out.println(word1.wordFromPigLatin("ananna'bay"));
        assertEquals(word1.wordFromPigLatin("ananna'bay"), "bananna" );

        try {
            System.out.println(word1.parseWord("ist'tway-ie'tay", "From"));
            assertEquals(word1.parseWord("ist'tway-ie'tay", "From"), "twist-tie");
        }catch (TranslateException e){
            System.out.println("Word translation failure");
        }
    }

    /*
        Translate word to english that starts with capital consonant
     */
    @Test
    public void wordFromPigLatin_startsWithCapitalConsonant() {
        PigLatinTranslator word1 = new PigLatinTranslator();
        System.out.println("\ntranslate words from pig latin starts with uppercase consonant....");
        System.out.println(word1.wordFromPigLatin("Ananna'bay"));
        assertEquals(word1.wordFromPigLatin("Ananna'bay"), "Bananna" );

        try {
            System.out.println(word1.parseWord("Ist'tway-Ie'tay", "From"));
            assertEquals(word1.parseWord("Ist'tway-Ie'tay", "From"), "Twist-Tie");
        }catch (TranslateException e){
            System.out.println("Word translation error");
        }
    }
    /*
        Translate full sample to pig latin
     */
    @Test
    public void fullTranslationToPigLatin(){
        PigLatinTranslator string1 = new PigLatinTranslator();

        System.out.println("\nTranslate full text to pig latin....\n");
        try {
            System.out.println(PigLatinTranslator.translateToPigLatin("This course is an introduction to programming in Java."));
            System.out.println(PigLatinTranslator.translateToPigLatin("Topics include fundamentals of Java programming, including object oriented programming, primitive data types, control structures, methods, objects, classes, class inheritance, simple graphical user interface and event driven programs using Swing."));
            System.out.println(PigLatinTranslator.translateToPigLatin("Object oriented design using the Unified Modeling Language will also be introduced."));
            System.out.println(PigLatinTranslator.translateToPigLatin("This course is an excellent course both in terms of work force relevance and continuing education."));
            System.out.println(PigLatinTranslator.translateToPigLatin("Java is widely used in industry and is syntactically very similar to many other popular languages such as Javascript and Ruby."));
            System.out.println(PigLatinTranslator.translateToPigLatin("Java is also widely used in educational settings and if you intend to earn a higher degree, this course may transfer to cover the introductory object oriented programming course common at many other institutions."));
        }catch (TranslateException e){
            System.out.println("Failed to translate full text to pig latin");
        }
    }
    /*
        Translate full sample to English
     */
    @Test
    public void fullTranslationFromPigLatin(){
        PigLatinTranslator string1 = new PigLatinTranslator();

        System.out.println("\nTranslate full text From pig latin....\n");
        try {
            System.out.println(PigLatinTranslator.translateFromPigLatin("Is'thay ourse'cay is'ay an'ay introduction'ay o'tay ogramming'pray in'ay Ava'jay."));
            System.out.println(PigLatinTranslator.translateFromPigLatin("Opics'tay include'ay undamentals'fay of'ay Ava'jay ogramming'pray, including'ay object'ay oriented'ay ogramming'pray, imitive'pray ata'day ypes'tay, ontrol'cay uctures'stray, ethods'may, objects'ay, asses'clay, ass'clay inheritance'ay, imple'say aphical'gray user'ay interface'ay and'ay event'ay iven'dray ograms'pray using'ay Ing'sway."));
            System.out.println(PigLatinTranslator.translateFromPigLatin("Object'ay oriented'ay esign'day using'ay e'thay Unified'ay Odeling'may Anguage'lay ill'way also'ay e'bay introduced'ay."));
            System.out.println(PigLatinTranslator.translateFromPigLatin("Is'thay ourse'cay is'ay an'ay excellent'ay ourse'cay oth'bay in'ay erms'tay of'ay ork'way orce'fay elevance'ray and'ay ontinuing'cay education'ay."));
            System.out.println(PigLatinTranslator.translateFromPigLatin("Ava'jay is'ay idely'way used'ay in'ay industry'ay and'ay is'ay yntactically'say ery'vay imilar'say o'tay any'may other'ay opular'pay anguages'lay uch'say as'ay Avascript'jay and'ay Uby'ray."));
            System.out.println(PigLatinTranslator.translateFromPigLatin("Ava'jay is'ay also'ay idely'way used'ay in'ay educational'ay ettings'say and'ay if'ay you'ay intend'ay o'tay earn'ay a'ay igher'hay egree'day, is'thay ourse'cay ay'may ansfer'tray o'tay over'cay e'thay introductory'ay object'ay oriented'ay ogramming'pray ourse'cay ommon'cay at'ay any'may other'ay institutions'ay."));
        } catch (TranslateException e){
            System.out.println("Failed to translate to english full text");
        }
    }


}
