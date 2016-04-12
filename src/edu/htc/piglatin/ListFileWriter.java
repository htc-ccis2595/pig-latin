package edu.htc.piglatin;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by volkg_000 on 4/10/2016.
 */
public class ListFileWriter {
    public static void writeToFile(ArrayList<String> translated, String myOutput) throws IOException {

        FileWriter fw = new FileWriter(myOutput);

        for(String s : translated){
            s = s.trim();
            if(!s.equals("") && s != null){
                fw.write(s + "\r\n");
            }
        }

        fw.close();

    }
}


