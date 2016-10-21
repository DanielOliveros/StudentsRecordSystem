package FileMethods;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFromFile {
	public static void Delete(String content,String fileName){
		try{
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			StringBuffer sb=new StringBuffer(4096);
			String temp=null;
			int line=0;
			int lineDel = 0;
			while((temp=br.readLine())!=null){
				line++;
				String[] tmp = temp.split(",");
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(content)!= -1){
						//System.out.println("\t" + tmp[i]);	
						//System.out.println(line);
						lineDel = line;
					}
				}
				if(line==lineDel) continue;
				sb.append(temp).append("\r\n");
			}
			br.close();
			BufferedWriter bw=new BufferedWriter(new FileWriter(fileName));
			bw.write(sb.toString());
			bw.close();	
			}catch(Exception e){
			System.out.println("modify failed");
		}
	}
	public static void main(String args[]) throws IOException{
		//content:the information used to locate which line to delete,it can just include part of the information 
		String content="ff";
		String fileName = "File/test.txt";
		Delete(content,fileName);
	}
}