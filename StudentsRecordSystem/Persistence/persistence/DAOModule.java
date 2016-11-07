package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Domain.Module;

public class DAOModule {
	public static Boolean createModule(Module module){
		boolean result=true;
		FileWriter file = null;
        PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/modules.txt", true);
            pw = new PrintWriter(file);
            pw.println(module.getId()+","+module.getName()+","+module.getCredits()+","+module.getDescription()+","+module.getIdProgram()+","+module.getIdLecturer());

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
	
	public static Module getModule(String id){
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/modules.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(id.equals(parts[0])){
	        		b.close();
	        		return new Module(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]);
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return null;
	}
	
	public static List<Module> getAllModules(){
		String line;
		List<Module> modulesList = new ArrayList<Module>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/modules.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	modulesList.add(new Module(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]));
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			modulesList = null;
		}
		return modulesList;
	}
}
