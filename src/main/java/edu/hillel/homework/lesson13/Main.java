package edu.hillel.homework.lesson13;

import edu.hillel.homework.lesson13.filemanager.FileData;
import edu.hillel.homework.lesson13.filemanager.FileNavigator;
import edu.hillel.homework.lesson13.filemanager.exceptions.InvalidFilePathException;

import java.nio.file.FileAlreadyExistsException;

public class Main {

    public static void main(String[] args) {

        FileNavigator notebook = new FileNavigator();

        try {
            notebook.add("data/path/folder1/", new FileData("XYW", 10000, "data/path/folder1/"));
            notebook.add("data/path/folder1/", new FileData("XXX", 10901, "data/path/folder1/"));
            notebook.add("data/path/folder1/", new FileData("YYY", 2000, "data/path/folder1/"));
            notebook.add("data/path/folder1/", new FileData("BBB", 1040, "data/path/folder1/"));
            notebook.add("data/path/folder1/", new FileData("yyy", 102230, "data/path/folder1/"));
            // file already exist exception - throw FileAlreadyExistsException
//            notebook.add("data/path/folder1/", new FileData("YYY", 12000, "data/path/folder1/"));
            // invalid file path exception - throw InvalidFilePathException
//            notebook.add("some/another/folder1/", new FileData("YYY", 12000, "data/path/folder1/"));

            notebook.add("data/path/folder2/", new FileData("BBB", 20000, "data/path/folder2/"));
            notebook.add("data/path/folder2/", new FileData("WWW", 303, "data/path/folder2/"));
            notebook.add("data/path/folder2/", new FileData("ASW", 2456, "data/path/folder2/"));
            notebook.add("data/path/folder2/", new FileData("QAA", 90877, "data/path/folder2/"));

            notebook.add("data/path/folder3/", new FileData("CCC", 30000, "data/path/folder3/"));
            notebook.add("data/path/folder3/", new FileData("LLL", 80900, "data/path/folder3/"));
            notebook.add("data/path/folder3/", new FileData("TTT", 100000, "data/path/folder3/"));
            notebook.add("data/path/folder3/", new FileData("VVV", 60770, "data/path/folder3/"));
            notebook.add("data/path/folder3/", new FileData("TtT", 1000400, "data/path/folder3/"));
            // file already exist exception - throw FileAlreadyExistsException
//            notebook.add("data/path/folder3/", new FileData("TTT", 22403, "data/path/folder3/"));
            // invalid file path exception - throw InvalidFilePathException
//            notebook.add("some/new_folder/folder3/", new FileData("TTT", 22403, "data/path/folder3/"));

            notebook.add("data/path/folder4/", new FileData("DDD", 40000, "data/path/folder4/"));
            notebook.add("data/path/folder4/", new FileData("TTT", 77760, "data/path/folder4/"));

            notebook.add("data/path/folder5/", new FileData("EEE", 50909, "data/path/folder5/"));
            notebook.add("data/path/folder5/", new FileData("BBB", 60, "data/path/folder5/"));
            notebook.add("data/path/folder5/", new FileData("XYW", 87003, "data/path/folder5/"));
            notebook.add("data/path/folder5/", new FileData("PPP", 99040, "data/path/folder5/"));
        } catch (InvalidFilePathException | FileAlreadyExistsException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }

        // Find files by path
        System.out.println("\n".concat("-".repeat(80)).concat(" Find files by file path"));
        System.out.println("Find such files by path \"data/path/folder1/\":");
        for (FileData fd : notebook.find("data/path/folder1/")) {
            System.out.println(fd);
        }
        System.out.println("Done.");

        // Remove file data by path
        System.out.println("\n".concat("-".repeat(80)).concat(" Remove file data by file path"));
        System.out.println("The following files will be remove now:");
        for (FileData fd : notebook.find("data/path/folder2/")) {
            System.out.println(fd);
        }
        notebook.remove("data/path/folder2/"); // file path exist, so FileData will be removed
        notebook.remove("data/some_path/"); // file path doesn't exist, so FileData will not be removed
        System.out.println("Done.");

        // Filter files by size
        System.out.println("\n".concat("-".repeat(80)).concat(" Filter files by size"));
        System.out.println("Filtered files by size. Maximum file size is 40000 bytes (included):");
        notebook.filterBySize(40000).forEach(System.out::println);
        System.out.println("Done.");

        // Sort all files by size
        System.out.println("\n".concat("-".repeat(80)).concat(" Sort all files by size"));
        System.out.println("All files was sorted by size:");
        notebook.sortBySize().forEach(System.out::println);
        System.out.println("Done.");
    }
}
