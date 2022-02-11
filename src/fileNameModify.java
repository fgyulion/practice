import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class fileNameModify {
    static List<String> fileNames = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\IdeaProject\\docs-of-guoyu");
        mkdir(file);
        getFileName(file);
        for (int i = 0; i < fileNames.size(); i++) {
            String newFileName = fileNames.get(i).replaceAll("C:", "d:");
            System.out.println(newFileName);
            File newFile = new File(newFileName);
            newFile.createNewFile();
        }
    }

    public static void getFileName(File file) {
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile()) {
                if (fileList[i].getName().endsWith("md")) {
                    fileNames.add(fileList[i].getPath());
                } else {
                    continue;
                }
            } else {
                getFileName(fileList[i]);
            }
        }
    }

    public static void mkdir(File file){
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                if (!fileList[i].getName().startsWith(".")) {
                    File newFile = new File(fileList[i].getPath().replaceAll("C:", "d:"));
                    newFile.mkdirs();
                }
            }
        }
    }
}
