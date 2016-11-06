package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import Domain.Assignment;
import Domain.Module;
import Domain.Program;
import Domain.ProgramStudents;

public class DAOAssignment {
	private static Scanner scan = new Scanner(System.in);
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

	public static List<Module> getUserModule(String lecturerID) {
		String line;
		List<Module> moduleList = new ArrayList<Module>();
		try{
	        FileReader f = new FileReader("./StorageFiles/modules.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	for(int i=0; i<parts.length; i++){
					if(parts[i].indexOf(lecturerID)!= -1){
						moduleList.add(new Module(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5]));
						break;
					}
				}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			moduleList = null;
		}
		return moduleList;
	}

	public static List<Assignment> getModuleAssignment(String moduleID) {
		String line;
		List<Assignment> assList = new ArrayList<Assignment>();
		try{
	        FileReader f = new FileReader("./StorageFiles/assignment.txt");
	        BufferedReader b = new BufferedReader(f);
	        while((line = b.readLine())!=null) {
	        	String[] parts = line.split(",");
	        	for(int i=0; i<parts.length; i++){
					if(parts[i].indexOf(moduleID)!= -1){
						assList.add(new Assignment(parts[0], parts[1], parts[2],Integer.parseInt(parts[3])));
						break;
					}
				}
	        }
	        b.close();
		}catch(Exception e){
			System.out.println("Error in the file reading");
			assList = null;
		}
		return assList;
	}

	public static void setGrade(String studentID, String moduleID) {
		String content;
		content=studentID+","+moduleID;
		try{
			BufferedReader br = new BufferedReader(new FileReader("./StorageFiles/assignment.txt"));
			String line = null;
			int total = 0;
			while((line = br.readLine())!= null){		
				String[] tmp = line.split(",");		//split by ","
				for(int i=0; i<tmp.length; i++){
					if(tmp[i].indexOf(moduleID)!= -1){
						System.out.println("Please input grade of " + tmp[2]+" (full mark is 100):");	
						int number=scan.nextInt();
						number=number * Integer.parseInt(tmp[3])/100;
						total+=number;
					}
				}
			}
			System.out.println("Final grade is: "+total);
			update(studentID,moduleID,total);
			br.close();
		}catch(IOException e){
			System.out.println("select failed");
		}finally{
			
		}				
		
	}
	
	public static void update(String studentID,String moduleID,int total){
		 File file = new File("./StorageFiles/QPV.txt");
		   try{
		      if(file.isFile()!=true){
		       file.createNewFile();
		       }
		      BufferedReader br = new BufferedReader(new FileReader(file));
		      String line = br.readLine();
		      Vector newtxt = new Vector();
		      String content = null;
		      String linecount = null;
		      while(line!=""&&line!=null){
		    	  String[] tmp = line.split(","); 
		    	  for(int i=0; i<tmp.length; i++){
						if(tmp[1].indexOf(studentID)!= -1&&tmp[0].indexOf(moduleID)!= -1){
							content = tmp[2];
							linecount = line;
						} 
					}
		    if(line==linecount){
		       if(line.split(",")[2].equals(content)){ 
		    	   String str1=line.substring(0,line.indexOf(content));
		    	   String str2=line.substring(line.indexOf(content)+content.length(),line.length());
		    	   newtxt.add(str1+total+str2);
		       }else{
		    	   newtxt.add(line);
		       }
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
