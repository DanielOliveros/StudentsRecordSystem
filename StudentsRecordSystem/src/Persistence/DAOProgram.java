package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Domain.Program;
import Domain.ProgramStudents;


public class DAOProgram {
	public static Boolean createProgram(Program program){
		boolean result=true;
		FileWriter file = null;
        PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/programs.txt", true);
            pw = new PrintWriter(file);
            pw.println(program.getId()+","+program.getName()+","+program.getCredits()+","+program.getDescription());

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
	
	public static Program getProgram(String id){
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/programs.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(id.equals(parts[0])){
	        		b.close();
	        		return new Program(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return null;
	}
	
	public static List<Program> getAllPrograms(){
		String line;
		List<Program> programsList = new ArrayList<Program>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/programs.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	programsList.add(new Program(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));	        	
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			programsList = null;
		}
		return programsList;
	}

	
}
