package com.firstquad.sandbox.tasks.fileSorter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class HugeFileGenerator {
    private final static int rowsToFlush = 1000_000;
    private static final String OUT_FILE_NAME = "generator_out.txt";

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new RuntimeException("Required arguments <count of rows> <size of row> are not found! \n");
        }

        int countOfRows;
        int sizeOfRow;
        try {
            countOfRows = parseInt(args[0]);
            sizeOfRow = parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("All args must be a integer", e);
        }

        File out = new File(OUT_FILE_NAME);
        try (FileWriter fileWriter = new FileWriter(out)) {
            for (int i = 1; i <= countOfRows; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 1; j <= sizeOfRow; j++) {
                    sb.append(Character.toChars(97 + (i << j) % 25));
                }
                sb.append("\n");
                fileWriter.write(sb.toString());

                if (i % rowsToFlush == 0) {
                    fileWriter.flush();
                }
            }
        }
    }
}
