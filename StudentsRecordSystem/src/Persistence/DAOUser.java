package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Domain.Admin;
import Domain.Lecturer;
import Domain.Program;
import Domain.Student;
import Domain.User;

public class DAOUser {
	public static Boolean createUser(User user){
		boolean result=true;
		FileWriter fileUsers = null;
        PrintWriter pw = null;
        try {
        	fileUsers = new FileWriter("./StorageFiles/users.txt", true);
            pw = new PrintWriter(fileUsers);
            pw.println(user.getId()+","+user.getName()+","+user.getPassword()+","+user.getClass().getSimpleName());

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
           try {
           if (null != fileUsers)
        	   fileUsers.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
		return result;
	}
	
	
	
	public static User getUser(String id){
		String line;
		try{
	        FileReader f = new FileReader("./StorageFiles/users.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(id.equals(parts[0])){
	        		switch(parts[3]){
	        		case "Admin": 
	        			b.close();
	        			return new Admin(parts[0], parts[1], parts[2]);
	        		case "Lecturer":
	        			b.close();
	        			return new Lecturer(parts[0], parts[1], parts[2]);
	        		case "Student":
	        			b.close();
	        			return new Student(parts[0], parts[1], parts[2]);
	        		}
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
		}
		return null;
	}
	
	public static List<User> getAllUsers(){
		String line;
		List<User> userslist = new ArrayList<User>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/users.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	
        		switch(parts[3]){
        		case "Admin": 
        			userslist.add(new Admin(parts[0], parts[1], parts[2]));
        			break;
        		case "Lecturer":
        			userslist.add(new Lecturer(parts[0], parts[1], parts[2]));
        			break;
        		case "Student":
        			userslist.add(new Student(parts[0], parts[1], parts[2]));
        			break;
        		}
	        	     	
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading (getAllUsers)");
			userslist = null;
		}
		return userslist;
	}
}
