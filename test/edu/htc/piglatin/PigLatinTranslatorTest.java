package edu.htc.piglatin;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.htc.piglatin.*;

/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {

    @Test
    public void translateToPigLatin(){
        //Test with capital letters, numbers, symbols
        PigLatinTranslator.translateToPigLatin("This is a test with symbols *&, Capital Letters, and numbers like 1, 2, and 3.");
    }

    @Test
    public void translateToPigLatin_emptyAndBlankStrings(){
        PigLatinTranslator.translateToPigLatin("");
        PigLatinTranslator.translateToPigLatin("  ");
    }

    @Test
    public void translateFromPigLatin(){
        PigLatinTranslator.translateFromPigLatin("Is'thay ourse'cay is'ay an'ay introduction'ay o'tay ogramming'pray in'ay Ava'jay.");

    }

    @Test
    public void translateFromPigLatin_emptyAndBlankStrings(){
        PigLatinTranslator.translateFromPigLatin("");
        PigLatinTranslator.translateFromPigLatin("  ");

    }

    @Test
    public void wordToPigLatin_emptyAndBlankStrings() {
        PigLatinTranslator.wordToPigLatin("");
        PigLatinTranslator.wordToPigLatin(" ");

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() {
        PigLatinTranslator.wordToPigLatin("lowercase");

    }

    @Test
    public void wordToPigLatin_withPunctuation() {
        PigLatinTranslator.wordToPigLatin("punctuation.");

    }

    @Test
    public void wordToPigLatin_startsWithCapitalVowel() {
        PigLatinTranslator.wordToPigLatin("Uppercase");

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() {
        PigLatinTranslator.wordToPigLatin("lowercase");

    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {
        PigLatinTranslator.wordToPigLatin("Capital");
    }

    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() {
        PigLatinTranslator.wordFromPigLatin("");
        PigLatinTranslator.wordFromPigLatin("  ");
    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseVowel() {
        PigLatinTranslator.wordFromPigLatin("ourse'cay");

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalVowel() {
        PigLatinTranslator.wordFromPigLatin("Ourse'cay");

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseConsonant() {
        //There is no scenario in which a piglatin word would start with a consonant
    }

    @Test
    public void wordFromPigLatin_startsWithCapitalConsonant() {
        //There is no scenario in which a piglatin word would start with a consonant

    }

}
