package edu.htc.piglatin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by clifford.mauer on 4/4/2016.
 */
public abstract class FileParser {

    /**
     * This class will read sentences from a file and store them in an ArrayList.
     * The file must have one sentence per line.
     *
     * Punctuation at the end of the sentence will not be removed.
     */
      public static ArrayList<String> parseFile(String fileName) throws IOException {

            // Complete this method so that the test below in the main method is correct.
            ArrayList<String> strReturn = new ArrayList<>();
            boolean blnExit = false;

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            try {
                while (!blnExit) {
                    String line = reader.readLine();
                    if (line.trim().length() != 0) {
                        strReturn.add(line);
                        System.out.println(line);
                        blnExit = false;
                    }
                    else {
                        if (line == null){
                            blnExit = true;
                        }
                    }
                }
            } finally {
                reader.close();
                return strReturn;
            }
        }
    }
