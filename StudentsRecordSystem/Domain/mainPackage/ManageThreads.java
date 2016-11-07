package mainPackage;

import UserInterface.LoginMenu;

public class ManageThreads {
	StateI state;
	
	public void countDown(){
		
		for (int i = 300; i>0; i--){
			try{
				Thread.sleep(1000);
				
			}catch(InterruptedException e){
				System.out.println("An error occured");
			}
			
			if (i == 61){
				LoginMenu.expirationWarning();
			}
		}
		
		LoginMenu.expirationAction();
		Thread.currentThread().interrupt();
		
	}
}
