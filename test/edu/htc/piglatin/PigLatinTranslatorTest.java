package edu.htc.piglatin;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {

    @Test
    public void translateToPigLatin(){

    }

    @Test
    public void translateToPigLatin_emptyAndBlankStrings(){

    }

    @Test
    public void translateFromPigLatin(){

    }

    @Test
    public void translateFromPigLatin_emptyAndBlankStrings(){

    }

    @Test
    public void wordToPigLatin_emptyAndBlankStrings() {

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() {

    }

    @Test
    public void wordToPigLatin_withPunctuation() {

    }

    @Test
    public void wordToPigLatin_startsWithCapitalVowel() {

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() {
        String word=PigLatinTranslator.wordToPigLatin("hello");
        assertEquals("ello'hay",word);
    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {
        String word=PigLatinTranslator.wordToPigLatin("Hello");
        assertEquals("Ello'hay",word);
    }

    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() {

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseVowel() {

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalVowel() {

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseConsonant() {

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalConsonant() {

    }

}
