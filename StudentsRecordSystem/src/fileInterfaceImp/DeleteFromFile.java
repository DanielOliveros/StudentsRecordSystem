package fileInterfaceImp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileInterface.IDeleteFromFile;

public class DeleteFromFile implements IDeleteFromFile {
	public void Delete(String content,String fileName){
		File file = new File(fileName);  
        BufferedReader reader = null;  
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
				sb.append(temp).append("\n");
			}
			br.close();
			BufferedWriter bw=new BufferedWriter(new FileWriter(fileName));
			bw.write(sb.toString());
			bw.close();	
			}catch(Exception e){
			System.out.println("modify failed");
		}
	}
}
