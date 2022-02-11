import java.io.*;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

public class fileNameModify {
    static List<String> fileNames = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\IdeaProject\\docs-of-guoyu");
        mkdir(file);
        getFileName(file);
        for (int i = 0; i < fileNames.size(); i++) {
            String temp = fileNames.get(i).replaceAll("C:", "d:");
            StringBuffer newFileName = new StringBuffer(temp);
            newFileName.insert(newFileName.length() - 3, "Security");
            System.out.println(newFileName.toString());
            File newFile = new File(newFileName.toString());
            newFile.createNewFile();
        }
        File file1 = new File("d:\\test.java");
        if (file1.exists()) {
            file1.delete();
        }
        file1.createNewFile();
        modifyFileContext(file1);
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

    public static void mkdir(File file) {
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

    public static void modifyFileContext(File file) throws IOException {
        FileOutputStream out = new FileOutputStream(file, true);
        StringBuffer sb = new StringBuffer();
        sb.append("package org.jkiss.dbeaver.ext.postgresql;\r\n");
        sb.append("public class " + file.getName().substring(0, file.getName().length() - 5) + "Security extends " + file.getName().substring(0, file.getName().length() - 5) + " {\r\n");
        sb.append("\r\n");
        sb.append("}\r\n");
        out.write(sb.toString().getBytes("utf-8"));
        out.close();
    }
}
