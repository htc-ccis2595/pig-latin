package edu.htc.piglatin;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {

    @Test
    public void translateToPigLatin(){
    String englishText = "Hello Translator.";
        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(englishText),"Ello\'hay Anslator\'tray.");
    }

    @Test
    public void translateToPigLatin_emptyAndBlankStrings(){
        String englishText = " ";
        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(englishText)," ");

    }


    @Test
    public void translateFromPigLatin(){
        String pigLatinText = "Ello'hay anslator'tray.";
        try {
            Assert.assertEquals(PigLatinTranslator.translateFromPigLatin(pigLatinText), "Hello translator.");
        }catch (TranslationException te){
            System.out.println(te.getMessage());
        }

    }

    @Test
    public void translateFromPigLatin_emptyAndBlankStrings(){
        String pigLatinText = " ";
        try {
            Assert.assertEquals(PigLatinTranslator.translateFromPigLatin(pigLatinText), " ");
        }catch (TranslationException te){
            System.out.println(te.getMessage());
        }

    }

    @Test
    public void wordToPigLatin_emptyAndBlankStrings() {
        String englishText = " ";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(englishText), " ");

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() {
        String englishText = "element";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(englishText), "element\'ay");

    }

    @Test
    public void wordToPigLatin_withPunctuation() {
        String englishText = "objects,";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(englishText), "objects\'ay,");

    }

    @Test
    public void wordToPigLatin_startsWithCapitalVowel() {
        String englishText = "Apples";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(englishText), "Apples\'ay");

    }

    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() {
        String englishText = "guide";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(englishText),"uide\'gay");

    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {
        String englishText = "Sixth";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(englishText), "Ixth\'say");

    }

    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() {
        String pigLatinText = " ";
        try {
            Assert.assertEquals(PigLatinTranslator.wordFromPigLatin(pigLatinText), " ");
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseVowel() {
        String pigLatinText = "uide\'gay";
        try {
            Assert.assertEquals(PigLatinTranslator.wordFromPigLatin(pigLatinText), "guide");
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalVowel() {
        String pigLatinText = "Apples\'ay";
        try {
            Assert.assertEquals(PigLatinTranslator.wordFromPigLatin(pigLatinText), "Apples");
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }

    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseConsonant() {
        String pigLatinText = "ger\'ginay";
        try {
            Assert.assertEquals(PigLatinTranslator.wordFromPigLatin(pigLatinText), "ginger");
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }

    }

    @Test
    public void wordFromPigLatin_startsWithCapitalConsonant() {
        String pigLatinText = "Ger\'ginay";
        try {
            Assert.assertEquals(PigLatinTranslator.wordFromPigLatin(pigLatinText), "Ginger");
        } catch (TranslationException te) {
            System.out.println(te.getMessage());
        }
    }

}
