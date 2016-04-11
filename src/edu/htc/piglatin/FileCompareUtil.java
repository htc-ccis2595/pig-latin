package edu.htc.piglatin;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * This is a utility class to compare files.
 * It is based on an example from the textbook.
 */
/**
 * Created by clifford.mauer on 4/4/2016.
 */
public class FileCompareUtil {

        public static boolean compare(String path1, String path2) throws IOException {

            boolean same = true;
            try (FileInputStream f1 = new FileInputStream(path1);
                 FileInputStream f2 = new FileInputStream(path2)) {
                System.out.println("Total file size to read (in bytes) : "
                        + f1.available());
                System.out.println("Total file size to read (in bytes) : "
                        + f2.available());

                int first, second;
                do {
                    first = f1.read();
                    second = f2.read();
                    if (first != second) {
                        same = false;
                        break;
                    }
                } while (first != -1 && second != -1);

                if (first != second){
                    same = false;
                }
            }
            return same;

        }
    }
