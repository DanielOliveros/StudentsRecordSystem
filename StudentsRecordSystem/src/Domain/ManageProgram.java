package Domain;

import java.util.Scanner;

import Persistence.DAOProgram;

public class ManageProgram {
	public int choose(){
		System.out.println("All the programs:"); 
		DAOProgram.showAll();
		Scanner sc = new Scanner(System.in); 
		System.out.println("Please choose what to do next:"); 
        System.out.println("\t"+"0:Search");
        System.out.println("\t"+"1:Add");
        System.out.println("\t"+"2:Delete");
        System.out.println("\t"+"3:Modify");
        System.out.println("Please insert number:"); 
        int choose = sc.nextInt();
        switch(choose){ 
        case 0:
        	System.out.println("Please insert Name/ID:");
        	Scanner sc1 = new Scanner(System.in); 
        	String condition = sc1.nextLine();
        	DAOProgram.search(condition);
        	break;
        case 1:
        	System.out.println("Please insert the details");
        	Scanner sc2 = new Scanner(System.in); 
        	System.out.println("Please insert ID:");
        	String ID = sc2.nextLine();
        	System.out.println("Please insert credits:");
        	int credits = sc2.nextInt();
        	System.out.println("Please insert program name:");
         	String name = sc2.next();
        	System.out.println("Please insert the description:");
        	String description = sc2.next();
        	System.out.println("Show the details:");
        	String content = ID+","+credits+","+name+","+description+",";
        	System.out.println(content);
        	DAOProgram.add(content);
        	break;
        case 2:
        	System.out.println("Please insert Name/ID you want to delete:");
        	Scanner sc3 = new Scanner(System.in); 
        	String contentDel = sc3.nextLine();
        	DAOProgram.delete(contentDel);
        	System.out.println("Delete successfully");
        	break;
        case 3:
        	Scanner sc4 = new Scanner(System.in); 
        	System.out.println("Please insert Name/ID to confirm the information you want to modify:");
        	String conditionMo = sc4.next();
        	System.out.println("Please choose which part you want to modify:");
        	System.out.println("0:ID");
        	System.out.println("1:credits");
        	System.out.println("2:name");
        	System.out.println("3:description");
        	int place = sc4.nextInt();
        	System.out.println("Please insert new information:");
        	String newChar = sc4.next();
        	DAOProgram.modify(place,conditionMo,newChar);
        	DAOProgram.search(conditionMo);
        	break;
        }
		return 1;
	}

}
