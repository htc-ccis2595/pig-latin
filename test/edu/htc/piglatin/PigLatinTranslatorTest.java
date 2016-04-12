package edu.htc.piglatin;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * Tests for the PigLatinTranslator.
 */
public class PigLatinTranslatorTest {

    @Test //good
    public void wordToPigLatin(){
        assertEquals("Ary'may", PigLatinTranslator.wordToPigLatin("Mary"));
    }

    @Test
    public void wordToPigLatin4(){
        assertEquals("Ary'may?!", PigLatinTranslator.wordToPigLatin("Mary?!"));
    }

    @Test //good
    public void wordToPigLatin2(){
        assertEquals("Eggs'ay", PigLatinTranslator.wordToPigLatin("Eggs"));
    }

    @Test //good
    public void wordToPigLatin3(){
        assertEquals("eggs'ay", PigLatinTranslator.wordToPigLatin("eggs"));
    }


    @Test
    public void translateToPigLatin(){

        assertEquals("Ary'may ad'hay a'ay ittle'lay amb'lay?!", PigLatinTranslator.translateToPigLatin("Mary had a little lamb?!"));
    }

    @Test
    public void translateToPigLatin_emptyAndBlankStrings(){

    }

    @Test
    public void wordFromPigLatin(){
        assertEquals("Mary?!", PigLatinTranslator.wordFromPigLatin("Ary'may?!"));
    }

    @Test //nogood
    public void wordFromPigLatin2(){
        assertEquals("Mary", PigLatinTranslator.wordFromPigLatin("Ary'may"));
    }

    @Test
    public void wordFromPigLatin3(){
        assertEquals("the", PigLatinTranslator.wordFromPigLatin("e'thay"));
    }

    @Test
    public void wordFromPigLatin4(){
        assertEquals("eggs", PigLatinTranslator.wordFromPigLatin("eggs'ay"));
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

    }

    @Test
    public void wordToPigLatin_startsWithCapitalConsonant() {

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
