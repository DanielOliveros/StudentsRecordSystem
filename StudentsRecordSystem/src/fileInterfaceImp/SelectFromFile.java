package fileInterfaceImp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import fileInterface.ISelectFromFile;

public class SelectFromFile implements ISelectFromFile {
	public void selectByContent(String fileName,String content){
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while((line = br.readLine())!= null){		
				String[] tmp = line.split(",");		//split by ","
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(content)!= -1){
						System.out.println("The words contain the condition:"+tmp[i]);	//tmp[1]就是你想要的bb
						System.out.println("Show results:");
						System.out.println(line);
					}
				}
			}
		}catch(IOException e){
			System.out.println("select failed");
		}finally{
			
		}				
	}

}
