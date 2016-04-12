package edu.htc.piglatin;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {

    @Test(expected = CannotTranslate.class)
    public void testforThrownException() throws CannotTranslate {
        String word = "adhay";

        PigLatinTranslator.wordFromLowerPigLatin(word);

    }


    @Test
    public void translateToPigLatin_emptyAndBlankStrings(){
        String sentence = "";

        assertEquals("", PigLatinTranslator.translatesentencetoPigLatin(sentence));

    }

    @Test
    public void translatesentencetoPigLatin() {
        String sentence = "Mary,, had, a little, lamb.";

        assertEquals("Ary'may,, ad'hay, a'ay ittle'lay, amb'lay.", PigLatinTranslator.translatesentencetoPigLatin(sentence));




    }
    @Test
    public void translatesentencetoEnglish() throws CannotTranslate {
        String sentence = "ary'may, ad'hay a'ay, ittle'lay, amb'lay.";

        assertEquals("mary, had a, little, lamb.", PigLatinTranslator.translatesentencetoEnglish(sentence));

        String sentence2 = "is'thay, ourse'cay is'ay an'ay introduction'ay o'tay ogramming'pray in'ay ava'jay.";

        assertEquals("this, course is an introduction to programming in java.", PigLatinTranslator.translatesentencetoEnglish(sentence2));

        String sentence3 = "Opics'tay include'ay undamentals'fay of'ay Ava'jay ogramming'pray, including'ay object'ay oriented'ay ogramming'pray, imitive'pray ata'day ypes'tay, ontrol'cay uctures'stray, ethods'may, objects'ay, asses'clay, ass'clay inheritance'ay, imple'say aphical'gray user'ay interface'ay and'ay event'ay iven'dray ograms'pray using'ay Ing'sway.";

        assertEquals("Topics include fundamentals of Java programming, including object oriented programming, primitive data types, control structures, methods, objects, classes, class inheritance, simple graphical user interface and event driven programs using Swing.", PigLatinTranslator.translatesentencetoEnglish(sentence3));

    }


    @Test
    public void translatetoPigLatin() {
        String word = "Eggs";

        assertEquals("Eggs'ay", PigLatinTranslator.translateToPigLatin(word));

        String word2 = "had";

        assertEquals("ad'hay", PigLatinTranslator.translateToPigLatin(word2));


        String word3 = "They";

        assertEquals("Ey'thay", PigLatinTranslator.translateToPigLatin(word3));

        String word4 = "intense";

        assertEquals("intense'ay", PigLatinTranslator.translateToPigLatin(word4));
    }



    @Test
    public void translateFromPigLatin_emptyAndBlankStrings(){

    }

    @Test
    public void wordToPigLatin_emptyAndBlankStrings() {

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() {
       String word = "eggs";


        assertEquals("eggs'ay", PigLatinTranslator.lowercasevowelToPigLatin(word));


    }


    @Test
    public void wordToPigLatin_startsWithUppercaseVowel() {
        String word = "Eggs";


        assertEquals("Eggs'ay", PigLatinTranslator.uppercasevowelToPigLatin(word));




    }

    @Test
    public void startsLVowel() {
        assertTrue(PigLatinTranslator.startswithLVowel("eggs"));
        assertTrue(PigLatinTranslator.startswithLVowel("artic"));
        assertTrue(PigLatinTranslator.startswithLVowel("intense"));
        assertTrue(PigLatinTranslator.startswithLVowel("only"));
        assertTrue(PigLatinTranslator.startswithLVowel("unity"));
        assertTrue(PigLatinTranslator.startswithLVowel("yellow"));

        assertFalse(PigLatinTranslator.startswithLVowel("jordan"));
    }

    @Test
    public void startsUVowel() {
        assertTrue(PigLatinTranslator.startswithUVowel("Eggs"));
        assertTrue(PigLatinTranslator.startswithUVowel("Artic"));
        assertTrue(PigLatinTranslator.startswithUVowel("Intense"));
        assertTrue(PigLatinTranslator.startswithUVowel("Only"));
        assertTrue(PigLatinTranslator.startswithUVowel("Unity"));
        assertTrue(PigLatinTranslator.startswithUVowel("Yellow"));

        assertFalse(PigLatinTranslator.startswithUVowel("Jordan"));

    }

    @Test
    public void findVowelIndex() {
        String word = "word";

        assertEquals(1, PigLatinTranslator.findVowelIndex(word));


    }





    @Test
    public void wordToPigLatin_withPunctuation() {

    }

    @Test
    public void wordToPigLatin_startsWithCapitalVowel() {

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() {

        String word = "word";

        assertEquals("ord'way", PigLatinTranslator.lowerconsonantToPigLatin(word));

        String word2 = "had";

        assertEquals("ad'hay", PigLatinTranslator.lowerconsonantToPigLatin(word2));

        String word3 = "the";

        assertEquals("e'thay", PigLatinTranslator.lowerconsonantToPigLatin(word3));

        String word4 = "";

        assertEquals("", PigLatinTranslator.lowerconsonantToPigLatin(word4));

        String word5 = "monica";

        assertEquals("onica'may", PigLatinTranslator.lowerconsonantToPigLatin(word5));




    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {

        //String word = "Word";

        //assertEquals("Ord'way", PigLatinTranslator.upperconsonantToPigLatin(word));

        String word2 = "Had";
        assertEquals("Ad'hay", PigLatinTranslator.upperconsonantToPigLatin(word2));

        String word3 = "The";

        assertEquals("E'thay", PigLatinTranslator.upperconsonantToPigLatin(word3));

        String word4 = "Jordan";

        assertEquals("Ordan'jay", PigLatinTranslator.upperconsonantToPigLatin(word4));

        String word5 = "Monica";

        assertEquals("Onica'may", PigLatinTranslator.upperconsonantToPigLatin(word5));

    }



    @Test

    public void wordFromLowerVowelPigLatin() throws CannotTranslate {
        String word = "eggs'ay";

        assertEquals("eggs", PigLatinTranslator.wordFromLowerPigLatin(word));

        String word2 = "even'ay";

        assertEquals("even", PigLatinTranslator.wordFromLowerPigLatin(word2));

        String word3 = "ad'hay";

        assertEquals("had", PigLatinTranslator.wordFromLowerPigLatin(word3));

        String word4 = "is'thay";

        assertEquals("this", PigLatinTranslator.wordFromLowerPigLatin(word4));


    }



    //NEEEEEEEEEEEEEEEEEEEEEEED TO FIX METHOD
    @Test
    public void wordFromUpperPigLatin() throws CannotTranslate {
        String word3 = "Is'thay";

        assertEquals("This", PigLatinTranslator.wordFromUpperPigLatin(word3));

    }






    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() throws CannotTranslate {

        String word = "";

        assertEquals("", PigLatinTranslator.wordFromLowerPigLatin(word));

    }



    @Test
    public void wordFromPigLatin_startsWithCapital() throws CannotTranslate {

        String word = "Eggs'ay";

        assertEquals("Eggs", PigLatinTranslator.wordFromUpperPigLatin(word));

        String word2 = "Ord'way";

        assertEquals("Word", PigLatinTranslator.wordFromUpperPigLatin(word2));






    }

    public void wordFromPigLatin_startsWithLower() throws CannotTranslate {

        String word = "eggs'ay";

        assertEquals("eggs", PigLatinTranslator.wordFromLowerPigLatin(word));

        String word2 = "ord'way";

        assertEquals("word", PigLatinTranslator.wordFromLowerPigLatin(word2));

        String word3 = "is'thay";

        assertEquals("this", PigLatinTranslator.wordFromLowerPigLatin(word3));





    }


    @Test
    public void startswithLConsonant() {
        String word = "word";

        assertTrue(PigLatinTranslator.startswithLConsonant(word));

        String word2 = "Yay";

        assertFalse(PigLatinTranslator.startswithLConsonant(word2));

        String word3 = "yay";

        assertFalse(PigLatinTranslator.startswithLConsonant(word3));


        String word4 = "Word";

        assertFalse(PigLatinTranslator.startswithLConsonant(word4));
    }


    @Test
    public void startswithUConsonant() {
        String word = "Word";

        assertTrue(PigLatinTranslator.startswithUConsonant(word));

        String word2 = "Yay";

        assertFalse(PigLatinTranslator.startswithUConsonant(word2));

        String word3 = "yay";

        assertFalse(PigLatinTranslator.startswithUConsonant(word3));


        String word4 = "word";

        assertFalse(PigLatinTranslator.startswithUConsonant(word4));


    }




}
