package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Domain.Lecturer;

public class DAOLecturer {
	public static Boolean createLecturer(Lecturer lecturer){
		boolean result=true;
		FileWriter file = null;
        PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/lecturers.txt", true);
            pw = new PrintWriter(file);
            pw.println(lecturer.getAssignedId()+","+lecturer.getAssignedName()+","+lecturer.getAssignedPassword()+","+lecturer.getAssignedPosition()+","+lecturer.getAssignedDepartment());

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
	
	public static Lecturer getLecturer(String id){
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/lecturers.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(id.equals(parts[0])){
	        		b.close();
	        		return new Lecturer(parts[0], parts[1], parts[2], parts[3], parts[4]);
	        	}
	        }
	        b.close();
		}catch(Exception e){
			e.getMessage();
		}
		return null;
	}
	
	public static List<Lecturer> getAllLecturers(){
		String line;
		List<Lecturer> lecturerList = new ArrayList<Lecturer>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/lecturers.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	lecturerList.add(new Lecturer(parts[0], parts[1], parts[2], parts[3], parts[4]));
	        }
	        b.close();
		}catch(Exception e){
			e.getMessage();
			lecturerList = null;
		}
		return lecturerList;
	}
}
