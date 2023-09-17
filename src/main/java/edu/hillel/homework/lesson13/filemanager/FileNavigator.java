package edu.hillel.homework.lesson13.filemanager;

import edu.hillel.homework.lesson13.filemanager.exceptions.InvalidFilePathException;
import org.jetbrains.annotations.NotNull;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FileNavigator {

    /**
     * Map<String, List<FileData>> to store file path as key and List<FileData> as value
     */
    private final Map<String, List<FileData>> fileStorage;

    /**
     * File navigator initial constructor
     */
    public FileNavigator() {
        this.fileStorage = new HashMap<>();
    }

    /**
     * @param path     - adding file path for new FileData
     * @param fileData - current FileData type
     * @throws InvalidFilePathException   - throw when adding file path mismatch the actual file path
     * @throws FileAlreadyExistsException - throw when such file name and file path already exist
     */
    public void add(@NotNull String path, @NotNull FileData fileData) throws
            InvalidFilePathException,
            FileAlreadyExistsException {
        final String filePath = fileData.getFilePath();
        final String fileName = fileData.getFileName();
        if (path.equals(filePath)) {
            if (!isFileAlreadyExist(fileData)) {
                if (!isFilePathAlreadyExist(filePath)) {
                    fileStorage.put(filePath, new ArrayList<>());
                }
                fileStorage.get(filePath).add(fileData);
            } else {
                throw new FileAlreadyExistsException("File already exist: {" +
                        "fileName:'" + fileName + "', " +
                        "filePath:'" + filePath + "'}", fileName, filePath);
            }
        } else {
            try {
                throw new RuntimeException();
            } catch (Exception e) {
                throw new InvalidFilePathException("There was a mismatch in the file adding paths: " + "{" +
                        "addingPath=\"" + path + "\", " +
                        "fileName=\"" + fileName + "\", " +
                        "filePath=\"" + filePath + "\"}", e, false, true);
            }
        }
    }

    /**
     * @param filePath parameter
     * @return new List<FileData> contains all FileData which have the same file path (or null)
     */
    public List<FileData> find(@NotNull String filePath) {
        if (!fileStorage.isEmpty()) {
            final List<FileData> findFilesList = new ArrayList<>();
            for (Map.Entry<String, List<FileData>> entry : fileStorage.entrySet()) {
                if (entry.getKey().equals(filePath)) {
                    findFilesList.addAll(entry.getValue());
                }
            }
            if (findFilesList.size() > 1) {
                findFilesList.sort(Comparator.comparing(FileData::getFileName)); // sort by file name
//                findFilesList.sort(Comparator.comparingInt(FileData::getFileSize)); // sort by file size
            }
            return findFilesList;
        }
        return null;
    }

    /**
     * @param maxFileSize parameter
     * @return new List<FileData> filtered by size but not more than maxFileSize parameter (or null)
     */
    public List<FileData> filterBySize(int maxFileSize) {
        if (!fileStorage.isEmpty()) {
            final List<FileData> filteredFilesList = new ArrayList<>();
            for (List<FileData> fileDataList : fileStorage.values()) {
                if (!fileDataList.isEmpty()) {
                    for (FileData fd : fileDataList) {
                        if (fd.getFileSize() <= maxFileSize) {
                            filteredFilesList.add(fd);
                        }
                    }
                }
            }
            if (filteredFilesList.size() > 1) {
//                filteredFilesList.sort(Comparator.comparing(FileData::getFileName)); // sort by file name
                filteredFilesList.sort(Comparator.comparingInt(FileData::getFileSize)); // sort by file size
            }
            return filteredFilesList;
        }
        return null;
    }

    /**
     * @param filePath - parameter for removing FileData
     */
    public void remove(@NotNull String filePath) {
        if (!fileStorage.isEmpty() && isFilePathAlreadyExist(filePath)) {
            fileStorage.remove(filePath);
        }
    }

    /**
     * @return new List<FileData> filtered by size (or null)
     */
    public List<FileData> sortBySize() {
        if (!fileStorage.isEmpty()) {
            final List<FileData> sortedFilesList = new ArrayList<>();
            for (List<FileData> fileDataList : fileStorage.values()) {
                if (!fileDataList.isEmpty()) {
                    sortedFilesList.addAll(fileDataList);
                }
            }
            if (sortedFilesList.size() > 1) {
                sortedFilesList.sort(Comparator.comparingInt(FileData::getFileSize));
            }
            return sortedFilesList;
        }
        return null;
    }

    /**
     * @param filePath - parameter to check actual file path
     * @return boolean
     */
    private boolean isFilePathAlreadyExist(@NotNull String filePath) {
        for (String path : fileStorage.keySet()) {
            if (path.equals(filePath)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param fileData - parameter to check actual file path & file name
     * @return boolean
     */
    private boolean isFileAlreadyExist(@NotNull FileData fileData) {
        for (Map.Entry<String, List<FileData>> entry : fileStorage.entrySet()) {
            if (entry.getKey().equals(fileData.getFilePath())) {
                for (FileData fd : entry.getValue()) {
                    if (fd.getFileName().equals(fileData.getFileName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
