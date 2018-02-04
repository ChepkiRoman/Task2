package by.tc.task02.dao.impl;

import by.tc.task02.dao.FileWorker;
import by.tc.task02.entity.RentUnit;

import java.io.*;
import java.util.List;
import java.util.ResourceBundle;


public class FileWorkerImpl implements FileWorker, Closeable {
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String line;


    public FileWorkerImpl(String nameOfFile) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(loadFile(nameOfFile)));
    }

    public File loadFile(String nameOfFile) {
        String filePath = ResourceBundle.getBundle("source_name").getString(nameOfFile);
        File file = new File(filePath);
        return file;
    }

    public String getStringFromFile() throws IOException {
        line = bufferedReader.readLine();
        return line;

    }

    public void writeInFile(String nameOfFile, List<RentUnit> rentUnitsList) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(loadFile(nameOfFile)));
        for (RentUnit s : rentUnitsList
                ) {
            bufferedWriter.write(s.toString());
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
    }


    public void close() throws IOException {
        bufferedReader.close();
    }
}
