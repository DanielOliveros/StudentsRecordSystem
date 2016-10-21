package FileMethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SelectFromFile {
	public static void selectByContent(String fileName,String content){
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while((line = br.readLine())!= null){		
				String[] tmp = line.split(",");		//split by ","
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(content)!= -1){
						System.out.println("\t" + tmp[i]);	
						System.out.println(line);
					}
				}
			}
		}catch(IOException e){
			System.out.println("select failed");
		}finally{
			
		}				
	}

	public static void main(String args[]) throws IOException{
		String fileName = "File/test.txt";
		String content = "aa";
		selectByContent(fileName,content);				  
	}
}
