package persistence;

import java.util.List;

public interface DAOInterface {
	List<Object> getAll();
	Object getById(String id);
	boolean createObject(Object object);
}
