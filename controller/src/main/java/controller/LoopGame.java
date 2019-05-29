package controller;

import model.PlayableMap;
import model.element.mobile.Mobile;
import model.element.mobile.Player;

public class LoopGame {
	private static Boolean isRunning = true;

	public static void loopGame() throws InterruptedException
	{
		while (getIsRunning()) {
			doGameUpdates();
			render();
			Thread.sleep(1000); //the timing mechanism
		}
	}
	

	private static void doGameUpdates() {
		if (Player.getAlive() == true){
			Mobile.move();
		}else {
			setIsRunning(false);
		}
	}
	
	private static void render() {
		if (getIsRunning() == false) {
			System.out.println("Vous avez perdu...");
		}
	}
	
	 public static void setIsRunning(Boolean isRunning) {
		 isRunning = isRunning;
	 }
	 
	 public static Boolean getIsRunning() {
		 return isRunning;
	 }
}
