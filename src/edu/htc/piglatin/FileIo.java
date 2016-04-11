package edu.htc.piglatin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;

/**
 * Created by joe on 4/10/2016.
 */
public class FileIo {

    public static ArrayList<String> readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        try {
            ArrayList<String> readData = new ArrayList<String>();
            String sentence = reader.readLine();

            while (sentence != null) {
                readData.add(sentence);
                readData.add("\n");
                sentence = reader.readLine();
            }
            return readData;
        }
        finally {
            reader.close();
        }
    }
 public static void writeFile(String fileName, ArrayList<String> data) throws IOException{
     BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

try {
    for (int i = 0; i < data.size(); i++) {
        writer.write(data.get(i));
        writer.write("\n");
    }
}finally {
    writer.close();
}

 }


}
