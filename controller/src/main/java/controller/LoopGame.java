package controller;

import contract.IMobile;
import contract.IPlayer;
import model.PlayableMap;
import model.element.mobile.Mobile;
import model.element.mobile.Player;

public class LoopGame {
	private Boolean isRunning = true;

	public void loopGame() throws InterruptedException
	{
		while (getIsRunning()) {
			doGameUpdates();
			render();
			Thread.sleep(1000); //the timing mechanism
		}
	}
	

	private void doGameUpdates() {
		if (Player.getAlive() == true){
			Mobile.move();
		}else {
			this.setIsRunning(false);
		}
	}
	
	private void render() {
		if (getIsRunning() == false) {
			System.out.println("Vous avez perdu...");
		}
	}
	
	 public void setIsRunning(Boolean isRunning) {
		 this.isRunning = isRunning;
	 }
	 
	 public Boolean getIsRunning() {
		 return this.isRunning;
	 }
}
