package mainPackage;


public class MySystem {
	private static MySystem instance = null;
	private StateI state;//state: initialState,sesionAdmin, sesionLecturer, sesionStudent 
	public static MySystem getSystem(){
		if(instance == null){
			instance = new MySystem();
		}
		return instance;
	}
	public StateI getState(){
		return this.state;
	}
	public void setState(StateI state){
		this.state=state;
	}
	public void request(){
		state.handle();
	}
}

