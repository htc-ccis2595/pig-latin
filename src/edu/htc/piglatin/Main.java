package edu.htc.piglatin;





import java.io.*;
import java.util.ArrayList;


public class Main {
    private static  ArrayList<String> dataFromSampleTextFile;
    private static ArrayList<String> dataFromPigLatinFile;

    public static void main(String[] args) throws IOException {
   
        readDataFromPlainTextFile();

        readDataFromPigLatinFile();

        writePlainTextFile();

        writePigLatin();


    }

    public static void readDataFromPlainTextFile() throws IOException{

        dataFromSampleTextFile = FileIo.readFile("src/data/sampleText.txt");
    }

    public static void readDataFromPigLatinFile() throws IOException{

        dataFromPigLatinFile = FileIo.readFile("src/data/samplePigLatin.txt");
    }

    public static void writePlainTextFile() throws IOException{
        String target;
        for(int i = 0; i < dataFromPigLatinFile.size(); i ++){

        FileIo.writeFile("out/production/Pig Latin Translator/data/PigLatin_English.txt", PigLatinTranslator.translateFromPigLatin(dataFromPigLatinFile));
        }
    }

    public static void writePigLatin() throws IOException{
        FileIo.writeFile("out/production/Pig Latin Translator/data/Text_PigLatin.txt", PigLatinTranslator.translateToPigLatin(dataFromSampleTextFile));

    }
}
