package edu.hillel.homework.lesson13.filemanager;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class FileData {

    /**
     * Actual file name
     */
    private final String fileName;
    /**
     * Actual file size in bytes
     */
    private final int fileSize;
    /**
     * Actual file path
     */
    private final String filePath;

    /**
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @return fileSize
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param fileName initialisation
     * @param fileSize initialisation
     * @param filePath initialisation
     */
    public FileData(
            String fileName,
            int fileSize,
            String filePath
    ) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.filePath = filePath;
    }

    /**
     * @return new String with FileData structure (fileName, fileSize, filePath)
     */
    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return "FileData{" +
                "fileName=\"" + fileName + "\", " +
                "fileSize=\"" + fileSize + " bytes\", " +
                "filePath=\"" + filePath + "\"" +
                '}';
    }
}
