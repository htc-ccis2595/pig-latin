package edu.htc.piglatin;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by volkg_000 on 4/10/2016.
 */
public class FileCompareUtil {
    public static boolean compare(String path1, String path2) throws IOException {

        boolean same = true;
        try (FileInputStream f1 = new FileInputStream(path1);
             FileInputStream f2 = new FileInputStream(path2)) {

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
