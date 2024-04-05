package File_IO.textNote.model;

public class modelEditor {
    private String fileName = "";
    private String path;

    public modelEditor(String fileName, String path) {
        this.fileName = fileName;
        this.path = path;
    }

    public modelEditor(){

    }
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return fileName;
    }
}
