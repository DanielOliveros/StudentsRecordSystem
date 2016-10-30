package Domain;

import java.util.List;

import Persistence.DAOAlocateLectureModule;
import Persistence.DAOLecturer;
import Persistence.DAOModule;

public class ManageLecturerModule {
	

	public static Boolean allocateLecturerToModule(String lecturerID, String moduleID){
		
			if(DAOLecturer.getLecturer(lecturerID)==null || DAOModule.getModule(moduleID)==null){ //means either the lecturer or module have not been registered
				return false;
			}else{
		
			LecturerModule lecturerModule = new LecturerModule(lecturerID, moduleID);
			
			if (DAOAlocateLectureModule.allocateLecturerModule(lecturerModule) == true){
				return true;
			}else{
				return false;
			}
			
	    }
		
	}
	
	public static List<LecturerModule> getAlocateLectureModule(){
		return DAOAlocateLectureModule.getAllLecturerModules();
	}
	
}