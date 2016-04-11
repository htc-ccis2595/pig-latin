package edu.htc.piglatin;

// ******* Mary *******
// i was confused on what exactly to do with the Main method.
// At the very bottom of the instruction on D2L it says
// the main method should only contain a few lines of code to read the data
// translate it and then write it to the files.
// i may have been missing somthing so i was unsure what to do with the prewritten main method you had.


import java.io.*;
import java.util.ArrayList;


public class Main {
    private static  ArrayList<String> dataFromSampleTextFile;
    private static ArrayList<String> dataFromPigLatinFile;

    public static void main(String[] args) throws IOException {

     


        readSamplePlainTextFile();

        readSamplePigLatinFile();

        writePlainText();

        writePigLatin();


    }

    public static void readSamplePlainTextFile() throws IOException{
   try {
       dataFromSampleTextFile = FileIo.readFile("src/data/sampleText.txt");
   }
   catch(IOException e){
           System.out.println("Could Not Read Data From English Sample File");
        }
   }

    public static void readSamplePigLatinFile() throws IOException{
        try {
            dataFromPigLatinFile = FileIo.readFile("src/data/samplePigLatin.txt");
        }
        catch(IOException e){
            System.out.println("Could Not Read Data From Pig Latin Sample File");
        }
    }


    public static void writePlainText() throws IOException{
        String target;
        for(int i = 0; i < dataFromPigLatinFile.size(); i ++){
try {
    FileIo.writeFile("out/production/Pig Latin Translator/data/PigLatin_English.txt", PigLatinTranslator.translateFromPigLatin(dataFromPigLatinFile));
}
        catch(IOException e){
                System.out.println("Could Not Write Data To English From Pig Latin File");
            }
        }
    }

    public static void writePigLatin() throws IOException{
        try {
            FileIo.writeFile("out/production/Pig Latin Translator/data/Text_PigLatin.txt", PigLatinTranslator.translateToPigLatin(dataFromSampleTextFile));
        }
        catch(IOException e){
            System.out.println("Could Not Write Data To Pig Latin To English File");
        }
    }
}
