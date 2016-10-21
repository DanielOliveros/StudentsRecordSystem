package FileMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteInFile {
	 /** 
     * A Methods��Use RandomAccessFile 
     */  
    public static void appendMethodA(String fileName, String content) {  
        try {  
            // ��һ����������ļ���������д��ʽ  
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
            // �ļ����ȣ��ֽ���  
            long fileLength = randomFile.length();  
            //��д�ļ�ָ���Ƶ��ļ�β��  
            randomFile.seek(fileLength);  
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * B Methods��use FileWriter 
     */  
    public static void appendMethodB(String fileName, String content) {  
        try {  
            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�  
            FileWriter writer = new FileWriter(fileName, true);  
            writer.write(content);  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void main(String[] args) { 
    	String id = "13";
    	String name = "mmmm";
    	String description = "m13m13";
        String fileName = "File/test.txt";  
        String content = id+","+name+","+description+",";  
        //Using methods A  
        WriteInFile.appendMethodA(fileName, content);  
        //WriteInFile.appendMethodA(fileName, "append end. \n");  
        //show  
        ReadFromFile.readFileByLines(fileName);  
        
        //All methods can be used,can use either one in this project
        //Using methods B  
//        WriteInFile.appendMethodB(fileName, content);  
//        WriteInFile.appendMethodB(fileName, "append end. \n");  
//        ReadFromFile.readFileByLines(fileName);  
       
    }  
}
