package fileInterfaceImp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import fileInterface.IWriteInFile;

public class WriteInFile implements IWriteInFile {
    public void appendMethodA(String fileName, String content) {  
        try {  
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
            long fileLength = randomFile.length();  
            randomFile.seek(fileLength);  
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void appendMethodB(String fileName, String content) {  
        try {  
            FileWriter writer = new FileWriter(fileName, true);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
}
