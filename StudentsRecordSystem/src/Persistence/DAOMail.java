package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class DAOMail {

	public static List<String> getAllRegisteredStudent(){
		String line;
		
		List<String> studentList = new ArrayList<String>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/studentsForMail.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	studentList.add(line);
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			studentList = null;
		}
		return studentList;
	}
	
	public static String checkStudentId(String id){
		String line;
		String role = "Student";
		try{
	        FileReader f = new FileReader("./StorageFiles/users.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(id.equals(parts[0]) && role.equals(parts[3])){
	        		b.close();
	        		return ("Valid");
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return ("Invalid");
	}
	
	public static String getRegisteredStudent(String id){
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/studentsForMail.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	if(id.equals(line)){
	        		b.close();
	        		return("Duplicate");
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return ("unique");
	}
	
	public static Boolean addStudentToMailList(String id){
		boolean result=true;
		FileWriter file = null;
		PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/studentsForMail.txt", true);
            pw = new PrintWriter(file);
            pw.println(id);
            
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
	
	
}
