package by.tc.task02.dao.impl;

import by.tc.task02.dao.FileWorker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ResourceBundle;


public class FileWorkerImpl implements FileWorker {
    BufferedReader bufferedReader;
    String line;

    public FileWorkerImpl() throws IOException{
        loadFile();
        bufferedReader = new BufferedReader(new FileReader(loadFile()));
    }

    public File loadFile() {
        String filePath = ResourceBundle.getBundle("source_name").getString("source.name");
        File file = new File(filePath);
        return file;
    }

    public String getStringFromFile() throws IOException {
        try {
            line = bufferedReader.readLine();
            return line;
        }finally {
           // bufferedReader.close();
        }
    }
}
