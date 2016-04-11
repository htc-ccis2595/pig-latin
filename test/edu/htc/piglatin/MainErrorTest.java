package edu.htc.piglatin;

import edu.htc.piglatin.file.FileCompareUtil;
import edu.htc.piglatin.file.FileParser;
import edu.htc.piglatin.file.ListFileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainErrorTest {

    public static void main(String[] args) throws IOException {

        String current = new File( "." ).getCanonicalPath();

        String origFileEnglish = ClassLoader.getSystemResource("data/sampleTextError.txt").getFile();
        String outputFilePigLatin = current + "/sampleText_PigLatinError.txt";

        String origFilePigLatin = ClassLoader.getSystemResource("data/samplePigLatinError.txt").getFile();
        String outputFileEnglish = current + "/samplePigLatin_EnglishError.txt ";

        try {

            translateFileToPigLatin(origFileEnglish, outputFilePigLatin);
            if (FileCompareUtil.compare(origFilePigLatin, outputFilePigLatin)){
                System.out.println("Translation of file to PigLatin matches expected.");
            } else {
                System.out.println("Translation of file to PigLatin does not match expected.\n");
            }

            translateFileFromPigLatin(origFilePigLatin, outputFileEnglish);
            if (FileCompareUtil.compare(origFileEnglish, outputFileEnglish)){
                System.out.println("Translation of file to English matches expected.\n");
            } else {
                System.out.println("Translation of file to English does not match expected.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred comparing the files.");
            System.out.println(e.getMessage());
        }
    }

    public static void translateFileToPigLatin(String inFilePath, String outFilePath) {
        // Read File
        ArrayList<String> sentences = null;
        try {
            sentences = FileParser.parseFile(inFilePath);
        } catch (FileNotFoundException e){
            System.out.println("Could not find file to translate to Pig Latin!\n");
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("An error occurred reading the file.");
            System.out.println(e.getMessage());
        }

        ArrayList<String> translated = new ArrayList<>();
        for (String sentence : sentences) {
            try {
                translated.add(PigLatinTranslator.translateToPigLatin(sentence));
            } catch (TranslateException e){
                System.out.println("Failed to translate sentence");
            }
        }

        try {
            ListFileWriter.writeToFile(translated, outFilePath);
        } catch (IOException e){
            System.out.println("An error occurred writing the file.");
            System.out.println(e.getMessage());
        }
    }

    public static void translateFileFromPigLatin(String inFilePath, String outFilePath) {
        // Read File
        ArrayList<String> sentences = null;
        try {
            sentences = FileParser.parseFile(inFilePath);
        } catch (FileNotFoundException e){
            System.out.println("Could not find file to tranlate to English!\n");
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println("An error occurred reading the file.");
            System.out.println(e.getMessage());
        }

        ArrayList<String> translated = new ArrayList<>();
        try {
            for (String sentence : sentences) {
                translated.add(PigLatinTranslator.translateFromPigLatin(sentence));
            }
        } catch (TranslateException e){
            System.out.println("Failed to translate sentences");
        }

        try {
            ListFileWriter.writeToFile(translated, outFilePath);
        } catch (IOException e){
            System.out.println("An error occurred writing the file.");
            System.out.println(e.getMessage());
        }
    }
}
