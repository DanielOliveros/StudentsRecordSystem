package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Domain.Assignment;
import Domain.Program;

public class DAOAssignment {

	public static String checkState(String moduleID) {
		String result = "ready";
		try{
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/assignment.txt"));
			String line = null;
			int total=0;
			while((line = br.readLine())!= null){		
				String[] tmp = line.split(",");		//split by ","
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(moduleID)!= -1){
						total += Integer.parseInt(tmp[3]);
					}
				}
			}
			//System.out.println("total:"+total);
			if(total == 100){
	        	result="ready";
	        }else if(total<100){
	        	result="not ready";
	        }else{
	        	System.out.println("over 100");
	        }
	        br.close();
		}catch(IOException e){
			System.out.println("select failed");
			result="over 100";
		}
		//System.out.print(result);
		return result;
	}

	public static Assignment getItem(String item) {
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/assignment.txt");
	        BufferedReader b = new BufferedReader(f);
	        
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(item.equals(parts[0])){
	        		b.close();
	        		return new Assignment(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return null;
	}

	public static boolean createAssignment(Assignment assignment) {
		boolean result=true;
		FileWriter file = null;
        PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/assignment.txt", true);
            pw = new PrintWriter(file);
            pw.println(assignment.getName()+","+assignment.getModuleId()+","+assignment.getDescription()+","+assignment.getPercentage());

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
           try {
           if (null != file)
        	   file.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		return result;
	}

	public static String checkBeforeAdd(String moduleId,int percentage) {
		String result = "ready";
		try{
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/assignment.txt"));
			String line = null;
			int total=0;
			while((line = br.readLine())!= null){		
				String[] tmp = line.split(",");		//split by ","
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(moduleId)!= -1){
						total += Integer.parseInt(tmp[3]);
					}
				}
			}
			
			total=total+percentage;
			System.out.println("total:"+total);
			if(total == 100){
	        	result="ready";
	        }else if(total<100){
	        	result="not ready";
	        }else{
	        	result="over 100";
	        	System.out.println("Total percevtage over 100");
	        }
	        br.close();
		}catch(IOException e){
			System.out.println("select failed");
			result="over 100";
		}
		return result;
	}
}
