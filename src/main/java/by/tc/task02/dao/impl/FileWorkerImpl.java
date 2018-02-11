package by.tc.task02.dao.impl;

import by.tc.task02.dao.FileWorker;
import by.tc.task02.entity.RentUnit;

import java.io.*;
import java.util.List;
import java.util.ResourceBundle;


public class FileWorkerImpl implements FileWorker {

    public File loadFile(String nameOfFile) {
        String filePath = ResourceBundle.getBundle("source_name").getString(nameOfFile);
        File file = new File(filePath);
        return file;
    }

    public String getStringFromFile(String nameOfFile) {
        String line = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(loadFile(nameOfFile)));) {
            line = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return line;
    }

    public void writeInFile(String nameOfFile, List<RentUnit> rentUnitsList) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(loadFile(nameOfFile)));
        for (RentUnit s : rentUnitsList
                ) {
            bufferedWriter.write(s.toString());
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
    }


}
