package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class ImportDataUtils {

    public static Optional<Scanner> load(final String inputFile) {
        final File myFile = new File(inputFile);
        if (myFile.exists()) {
            {
                try {
                    var scanner = new Scanner(myFile);
                    return Optional.of(scanner);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return Optional.empty();
    }

}
