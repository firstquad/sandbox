package com.firstquad.sandbox.tasks.fileSorter;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class HugeFileSorter {
    private static final String OUT_FILE_NAME = "sorter_out.txt";
    private static int parts = 4;

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            throw new RuntimeException("Required argument <path to file> is not found! \n");
        }

        String pathInputFile = args[0];
        File fileIn = new File(pathInputFile);
        File fileOut = new File(OUT_FILE_NAME);
        fileOut.createNewFile();

        File tmpDir = new File("tmp");
        if (tmpDir.exists()) {
            tmpDir.delete();
        }
        tmpDir.mkdir();

        try (RandomAccessFile randomAccessFile = new RandomAccessFile(fileIn, "r")) {
            long length = randomAccessFile.length();
            parts = parts % 2 == 0 ? parts : parts + 1;
            for (int i = 0; i < parts; i++) {
                int countOfBytes = 0;
                File tmp = new File("tmp/tmp" + i + ".txt");
                tmp.createNewFile();
                try (FileWriter fileWriter = new FileWriter(tmp)) {
                    int b = 0;
                    boolean isFirstIter = true;
                    while (countOfBytes < length / parts || (i == parts - 1 && b > -1)) {
                        b = randomAccessFile.read();
                        if (isFirstIter && '\n' == (char) b) {
                            countOfBytes--;
                            continue;
                        }
                        fileWriter.write(b);
                        countOfBytes++;
                        isFirstIter = false;
                    }
                }
            }
        }

        File[] files = tmpDir.listFiles();

        if (files == null || files.length == 0) {
            throw new RuntimeException("Split files are not found");
        }

        for (File tmp : files) {
            FileReader fileReader = new FileReader(tmp);
            BufferedReader bf = new BufferedReader(fileReader);
            String t;
            TreeSet<String> tmpTree = new TreeSet<>();
            while ((t = bf.readLine()) != null) {
                tmpTree.add(t);
            }
            fileReader.close();
            FileWriter fileWriter = new FileWriter(tmp);
            while ((t = tmpTree.pollFirst()) != null) {
                fileWriter.write(t);
                fileWriter.write("\n");
            }
            fileWriter.close();
        }

        merge(files);
    }

    public static void merge(File[] files) throws IOException, InterruptedException {
        if (files.length == 1)
            return;

        for (int i = 0; i < files.length - 1; i += 2) {
            File f1 = files[i];
            File f2 = files[i + 1];

            try (BufferedReader fr1 = new BufferedReader(new FileReader(f1));
                 BufferedReader fr2 = new BufferedReader(new FileReader(f2))) {

                File newTmp = new File("tmp/tmp" + i + "_" + (i + 1) + "_" + System.nanoTime() + ".txt");
                newTmp.createNewFile();
                String s1 = fr1.readLine();
                String s2 = fr2.readLine();

                boolean isFirstGreater = false;
                try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(newTmp))) {
                    String sw;
                    do {
                        if (s1 != null && s2 != null) {
                            isFirstGreater = Comparator.<String>naturalOrder().compare(s1, s2) < 0;
                            sw = isFirstGreater ? s1 : s2;
                        } else if (s1 == null && s2 == null) {
                            sw = null;
                        } else if (s1 == null) {
                            sw = s2;
                            isFirstGreater = false;
                        } else {
                            sw = s1;
                            isFirstGreater = true;
                        }

                        if (sw != null) {
                            fileWriter.write(sw);
                            fileWriter.write("\n");
                        }

                        if (isFirstGreater)
                            s1 = fr1.readLine();
                        else {
                            s2 = fr2.readLine();
                        }

                    } while (sw != null);
                }

            }
        }

        Arrays.stream(files).forEach(f -> {
            while (f.exists())
                f.delete();
        });

        merge(new File("tmp").listFiles());
    }
}
