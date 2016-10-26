package Persistence;

import fileInterface.*;
import fileInterfaceImp.*;

public class DAOProgram {
	public static void showAll(){
		IReadFromFile rf = new ReadFromFile();
		String fileName = "File/Program.txt";
		rf.readFileByLines(fileName);  
	}
	public static void search(String condition){
		ISelectFromFile sf = new SelectFromFile();
		String fileName = "File/Program.txt";
		sf.selectByContent(fileName,condition);	
		
	}
	public static void add(String content){
		IWriteInFile wf = new WriteInFile();
        String fileName = "File/Program.txt";  
        wf.appendMethodA(fileName,"\n"+content);  
	}
	public static void delete(String content){
		IDeleteFromFile df = new DeleteFromFile();
		String fileName = "File/Program.txt";
		df.Delete(content,fileName);
	}
	public static void modify(int place,String condition,String newChar){
		IUpdateDataInFile uf = new UpdateDataInFile();
		String fileName = "File/Program.txt";
		uf.update(fileName,condition,place,newChar);	
	}

}
