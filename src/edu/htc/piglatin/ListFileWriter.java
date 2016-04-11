package edu.htc.piglatin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by clifford.mauer on 4/4/2016.
 */
public class ListFileWriter {

    public static void writeToFile(ArrayList<String> list, String fileName) throws IOException {

        // Complete this method so that the test below in the main method is correct.
        boolean blnExit = false;

        FileWriter fw = new FileWriter(fileName);
        try {
            for (String str : list) {
                if ( str.trim().length() != 0){
                    fw.write(str.trim() + "\r\n");
                }
            }
            fw.close();
        }
        catch (IOException e){
            System.out.println("I/O Error: " + e);
        }
    }

}
