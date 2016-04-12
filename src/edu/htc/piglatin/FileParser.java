package edu.htc.piglatin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by volkg_000 on 4/10/2016.
 */
public class FileParser {
    public static ArrayList<String> parseFile(String path) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<String> translated = new ArrayList<String>();
        String line;



        for(int i = 0; i < 7; i++) {

            if ((line = br.readLine()) != null) {

                line = line.trim();
                System.out.println(line);
                if (!line.equals("")) {
                    translated.add(line);
                }


            }
        }

        return translated;



    }
}
