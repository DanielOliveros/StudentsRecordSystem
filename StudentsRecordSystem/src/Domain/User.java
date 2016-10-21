package Domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class User{

public interface userInterface {
	public String userDetails(String username, String password);
}

public static void main(String[] args) throws IOException { 
	
	PrintWriter writer = new PrintWriter("userInfo.txt", "UTF-8");
	writer.println("clara;123456;Admin");
	writer.println("favour;jjjjjj;Lecturer");
	writer.println("mirian;kkkkkk;student");
	writer.close();
	
    BufferedReader brConsole = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter your username");
    String uName = brConsole.readLine();
    System.out.print("Enter your password:");
    String pWord = brConsole.readLine();
    
    
    try{
        FileReader fr = new FileReader("userInfo.txt");
        BufferedReader brTxt = new BufferedReader(fr);
        
        String detailsChecker;
        boolean login = false;
        
        while((detailsChecker = brTxt.readLine()) != null){
        	String[] details = detailsChecker.split(";");
        	String detailUser  = details[0];
        	String detailPass  = details[1];
        	
        	if ((pWord.equals(detailPass)) && (uName.equals(detailUser))){
        		login = true;
        		System.out.print("Congratulations " + detailUser + ", you are logged in as " + details[2]);
        		break;
        	}
        }
        brTxt.close();
        
        if (login == false){
        	System.err.println("Wrong Input");
        }
        
    }catch(NumberFormatException nfe){
        System.err.println("Error Occured!");
    }
    
}

}