package FileMethods;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteInFile {
	 /** 
     * A Methods：Use RandomAccessFile 
     */  
    public static void appendMethodA(String fileName, String content) {  
        try {  
            // 打开一个随机访问文件流，按读写方式  
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            //将写文件指针移到文件尾。  
            randomFile.seek(fileLength);  
            randomFile.writeBytes(content);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * B Methods：use FileWriter 
     */  
    public static void appendMethodB(String fileName, String content) {  
        try {  
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件  
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
