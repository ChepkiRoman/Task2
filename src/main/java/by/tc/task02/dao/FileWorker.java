package by.tc.task02.dao;

import java.io.File;
import java.io.IOException;

public interface FileWorker {
     File loadFile() ;
     String getStringFromFile() throws IOException;
}
