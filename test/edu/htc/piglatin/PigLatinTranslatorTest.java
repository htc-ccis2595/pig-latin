package edu.htc.piglatin;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest  {

    @Test
    public void translateToPigLatin() throws TranslationException {
        assertEquals("Elephant'ay is'ay a'ay ig'bay animal'ay.",PigLatinTranslator.translateToPigLatin("Elephant is a big animal."));

    }

    @Test
    public void translateToPigLatin_emptyAndBlankStrings() throws TranslationException {
        assertEquals("",PigLatinTranslator.translateToPigLatin(""));
        assertEquals(" ",PigLatinTranslator.translateToPigLatin(" "));

    }

    @Test
    public void translateFromPigLatin() throws TranslationException{
        assertEquals("Mary had a little lamb?!",PigLatinTranslator.translateFromPigLatin("Ary'may ad'hay a'ay ittle'lay amb'lay?!"));
    }

    @Test
    public void translateFromPigLatin_emptyAndBlankStrings(){
        assertEquals("",PigLatinTranslator.translateFromPigLatin(""));
        assertEquals(" ",PigLatinTranslator.translateFromPigLatin(" "));

    }

    @Test
    public void wordToPigLatin_emptyAndBlankStrings() throws TranslationException {
        assertEquals("",PigLatinTranslator.wordToPigLatin(""));
        assertEquals(" ", PigLatinTranslator.wordToPigLatin(" "));
        assertEquals("  ", PigLatinTranslator.wordToPigLatin("  "));

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() throws TranslationException {
        assertEquals("elephant'ay",PigLatinTranslator.wordToPigLatin("elephant"));

    }

    @Test
    public void wordToPigLatin_withPunctuation() throws TranslationException {
        assertEquals("amb'lay!?",PigLatinTranslator.wordToPigLatin("lamb!?"));
        assertEquals("ey'hay!?",PigLatinTranslator.wordToPigLatin("hey!?"));

    }

    @Test
    public void wordToPigLatin_startsWithCapitalVowel() throws TranslationException {
        assertEquals("Eggs'ay", PigLatinTranslator.wordToPigLatin("Eggs"));

    }



    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() throws TranslationException {
        assertEquals("ord'way", PigLatinTranslator.wordToPigLatin("word"));


    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() throws TranslationException{
        assertEquals("Amb'lay", PigLatinTranslator.wordToPigLatin("Lamb"));

    }

    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() throws TranslationException{
        assertEquals("", PigLatinTranslator.wordFromPigLatin(""));
        assertEquals(" ", PigLatinTranslator.wordFromPigLatin(" "));

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseVowel() throws TranslationException{
        assertEquals("eat", PigLatinTranslator.wordFromPigLatin("eat'ay"));

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalVowel() throws TranslationException{
        assertEquals("Eat", PigLatinTranslator.wordFromPigLatin("Eat'ay"));

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseConsonant() throws TranslationException{
        assertEquals("lamb", PigLatinTranslator.wordFromPigLatin("amb'lay"));

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalConsonant() throws TranslationException{
        assertEquals("Little", PigLatinTranslator.wordFromPigLatin("Ittle'lay"));

    }

}
