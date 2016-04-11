package edu.htc.piglatin;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {


    @Test
    public void translateToPigLatin(){

        String TestString = "Joseph"
        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "oseph'Jay");
    }

    @Test
    public void translateToPigLatin_emptyAndBlankStrings(){
        String TestString = ""
        String OtherTestSting = " ";
        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "");
        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(OtherTestString), " ");
    }

    @Test
    public void translateFromPigLatin(){
        String TestString = "oseph'Jay"
        Assert.assertEquals(PigLatinTranslator.translateFromPigLatin(TestString), "Joseph");
    }

    @Test
    public void translateFromPigLatin_emptyAndBlankStrings(){
        String TestString = ""
        String OtherTestSting = " ";
        Assert.assertEquals(PigLatinTranslator.translateFromPigLatin(TestString), "");
        Assert.assertEquals(PigLatinTranslator.translateFromPigLatin(OtherTestString), " ");
    }

    @Test
    public void wordToPigLatin_emptyAndBlankStrings() {
        String TestString = ""
        String OtherTestSting = " ";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin()ToPigLatin(TestString), "");
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(OtherTestString), " ");
    }

    @Test
    public void wordToPigLatin_startsWithLowercaseVowel() {

        String TestString = "apple";

        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "apple'ay");
    }

    @Test
    public void wordToPigLatin_withPunctuation() {
     String TestSTring = "Joseph."
        String OtherTestSTring = "Joseph,"
        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "oseph'Jay.");
        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "oseph'Jay,");
    }

    @Test
    public void wordToPigLatin_startsWithCapitalVowel() {
        String TestString = "Apple";

        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "Apple'ay");
    }

    @Test
    public void wordToPigLatin_startsWithLowercaseConsonant() {
        String TestString = "joseph";

        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "oseph'jay");
    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {
        String TestString = "Joseph";

        Assert.assertEquals(PigLatinTranslator.translateToPigLatin(TestString), "oseph'Jay");
    }

    @Test
    public void wordFromPigLatin_emptyAndBlankStrings() {
        String TestString = ""
        String OtherTestSting = " ";
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin()ToPigLatin(TestString), "");
        Assert.assertEquals(PigLatinTranslator.wordToPigLatin(OtherTestString), " ")
    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseVowel() {
        String TestString = "apple'ay";

        Assert.assertEquals(PigLatinTranslator.translateFromPigLatin(TestString), "apple");
    }

    @Test
    public void wordFromPigLatin_startsWithCapitalVowel() {
        String TestString = "Apple'ay";

        Assert.assertEquals(PigLatinTranslator.translateFromPigLatin(TestString), "Apple");
    }

    @Test
    public void wordFromPigLatin_startsWithLowercaseConsonant() {
        String TestString = "oseph'jay";

        Assert.assertEquals(PigLatinTranslator.wordFromPigLatin(TestString), "joseph");
    }

    @Test
    public void wordFromPigLatin_startsWithCapitalConsonant() {
        String TestString = "oseph'Jay";

        Assert.assertEquals(PigLatinTranslator.wordFromPigLatin(TestString), "Joseph");
    }

}
