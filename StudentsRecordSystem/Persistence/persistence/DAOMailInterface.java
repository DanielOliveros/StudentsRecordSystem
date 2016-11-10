package persistence;

import java.util.List;

public interface DAOMailInterface {

	List<String> getallRegisteredStudent();
	String checkstudentId(String id);
	String getregisteredStudent(String id);
	Boolean addstudentToMailList(String id);
	
}
