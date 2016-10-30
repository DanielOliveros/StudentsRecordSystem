package Domain;

import java.util.List;

import Persistence.DAOLecturer;


public class ManageLecturer {
	public static Lecturer addLecturer(String assignedId, String assignedName, String assignedPassword, String assignedPosition, String assignedDepartment){
		Lecturer Lecturer;
		if(DAOLecturer.getLecturer(assignedId)==null){
			Lecturer = new Lecturer(assignedId, assignedName, assignedPassword, assignedPosition, assignedDepartment);
			DAOLecturer.createLecturer(Lecturer);
		}else{
			Lecturer = null;
		}
		return Lecturer;
    }
	
	public static List<Lecturer> getAllLecturers(){
		return DAOLecturer.getAllLecturers();
	}
	
}
