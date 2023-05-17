package dev.tbdbatista.chainofresponsability.model;

public class File {
    private final String fileName;
    private final String fileType;

    public File(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }
}
