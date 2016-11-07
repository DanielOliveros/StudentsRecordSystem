package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Domain.Admin;
import Domain.Lecturer;
import Domain.ProgramStudents;
import Domain.QCA;
import Domain.QPV;
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



	public static List<User> getAllUsers(String option) {
		String line;
		List<User> usersList = new ArrayList<User>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/users.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	for(int i=0; i<parts.length; i++){
					if(parts[i].indexOf(option)!= -1){
						usersList.add(new User(parts[0], parts[1], parts[2]));
						break;
					}
				}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			usersList = null;
		}
		return usersList;
	}



	public static List<ProgramStudents> getAllUsersByProgramID(String programID) {
		String line;
		List<ProgramStudents> usersList = new ArrayList<ProgramStudents>();
		
		try{
	        FileReader f = new FileReader("./StorageFiles/programStudents.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	for(int i=0; i<parts.length; i++){
					if(parts[i].indexOf(programID)!= -1){
						usersList.add(new ProgramStudents(parts[0], parts[1]));
						break;
					}
				}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			usersList = null;
		}
		return usersList;
	}



	public static boolean registerStudentIntoProgram(ProgramStudents prostu) {
		boolean result=true;
		FileWriter file = null;
        PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/programStudents.txt", true);
            pw = new PrintWriter(file);
            pw.println(prostu.getProgramID()+","+prostu.getStudentID());

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



	public static boolean checkProStu(String programId, String studentId) {
		String line;
		boolean result = false;
		try{
	        FileReader f = new FileReader("./StorageFiles/programStudents.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	if(programId.equals(parts[0])&&studentId.equals(parts[1])){
	        		result=true;
	        	}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			result=true;
		}
		return result;
	}

    public static QPV createQPVs(QPV qpv){
    	String content = qpv.getStudentID()+"";
    	String programId = null;
    	try{
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/programStudents.txt"));
			BufferedReader br1 = new BufferedReader(new FileReader("./StorageFiles/modules.txt"));
			FileWriter writer = new FileWriter("./StorageFiles/QPV.txt", true);  
			String line = null,line1 = null,newinformation = null;
			while((line = br.readLine())!= null){		
				String[] tmp = line.split(",");		//split by ","
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(content)!= -1){
						programId = tmp[0];
					}
				}
			}
			while((line1 = br1.readLine())!= null){		
				String[] tmp = line1.split(",");		//split by ","
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(programId)!= -1){
						newinformation = "\n"+tmp[0]+","+content+",D,1.0,0";
				        writer.write(newinformation);
					}
				}
			}
			writer.close();
			br1.close();
			br.close();
		}catch(IOException e){
			System.out.println("select failed");
		}finally{
			
		}				
    	return qpv;
    } 

	public static boolean createQCA(QCA qca) {
		boolean result=true;
		FileWriter file = null;
        PrintWriter pw = null;
        try
        {
        	file = new FileWriter("./StorageFiles/QCA.txt", true);
            pw = new PrintWriter(file);
            pw.println(qca.getStudentID()+","+qca.getProgramID()+","+qca.getQCA()+","+qca.getAwardClassification());
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



	public static boolean checkModuleState(String moduleId) {
		String line;
		boolean result = false;
		int total = 0;
		try{
	        FileReader f = new FileReader("./StorageFiles/assignment.txt");
	        BufferedReader b = new BufferedReader(f);
	        line = b.readLine();
	        while(line!=""&&line!=null){
		    	  String[] tmp = line.split(","); 
		    	  for(int i=0; i<tmp.length; i++){
						if(tmp[i].indexOf(moduleId)!= -1){
							total = total + Integer.parseInt(tmp[3]);
						} 
					}
		    }
	        if(total==100){
		    	result=true;
		    }else{
		    	result=false;
		    }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			result=true;
		}
		return result;
	}
}
