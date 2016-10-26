package fileInterfaceImp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

import fileInterface.IUpdateDataInFile;

public class UpdateDataInFile implements IUpdateDataInFile{
	public void update(String fileName,String oldChar,int place,String newChar){
		 File file = new File(fileName);
		   try{
		      if(file.isFile()!=true){
		       file.createNewFile();
		       }
		      BufferedReader br = new BufferedReader(new FileReader(file));
		      String line = br.readLine();
		      Vector newtxt = new Vector();
		      String content = null;
		      while(line!=""&&line!=null){
		    	  String[] tmp = line.split(","); 
		    	  for(int i=0; i<tmp.length; i++){
						if(tmp[i].indexOf(oldChar)!= -1){
							content = tmp[place];
						} 
					}
		       if(line.split(",")[place].equals(content)){ 
		    	   String str1=line.substring(0,line.indexOf(content));
		    	   String str2=line.substring(line.indexOf(content)+content.length(),line.length());
		    	   newtxt.add(str1+newChar+str2);
		       }else{
		    	   newtxt.add(line);
		       }
		       line=br.readLine();
		      }
		      
		      br.close();
		      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		      for(int i=0;i<newtxt.size();i++)
		      {
		    	  writer.write(newtxt.get(i).toString());
		    	  writer.newLine();
		      }
		      
		      writer.flush();
		      writer.close();

		 }catch(Exception e)
		   {
		    e.printStackTrace();
		   }
	}
		
}
