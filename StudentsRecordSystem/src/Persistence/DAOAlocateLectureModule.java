package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Domain.LecturerModule;

public class DAOAlocateLectureModule {
	public static Boolean allocateLecturerModule(LecturerModule allocate){
		boolean result=true;
		FileWriter file = null;
        PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/lecturerModules.txt", true);
            pw = new PrintWriter(file);
            pw.println(allocate.getModuleID()+","+allocate.getLecturerID());

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
	
	public static LecturerModule getLecturerModule(String id){
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/lecturers.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(id.equals(parts[0])){
	        		b.close();
	        		return new LecturerModule(parts[0], parts[1]);
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return null;
	}
	
	public static List<LecturerModule> getAllLecturerModules(){
		String line;
		List<LecturerModule> lecturerModuleList = new ArrayList<LecturerModule>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/lecturerModules.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	lecturerModuleList.add(new LecturerModule(parts[0], parts[1]));
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			lecturerModuleList = null;
		}
		return lecturerModuleList;
	}
}