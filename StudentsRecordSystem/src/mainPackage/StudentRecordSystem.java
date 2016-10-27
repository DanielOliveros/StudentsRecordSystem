package mainPackage;

public class StudentRecordSystem {
	public static void main(String[] args) {
		MySystem system = new MySystem();
		StateI state = new LoggedOutState();
		system.setState(state);
		system.request();
	}
}
